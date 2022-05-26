package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.message.DefaultMessage;
import com.acme.dbo.txlog.saver.AbstractSaver;

public class LogService {
    private Message currentAccumulatedMessage = new DefaultMessage();
    private AbstractSaver saver;

    public LogService(AbstractSaver saver) {
        this.saver=saver;
    }

    public void log(Message message) {
        if (currentAccumulatedMessage.isSame(message)) {
            currentAccumulatedMessage = currentAccumulatedMessage.accumulate(message);
        } else {
            flush();
            currentAccumulatedMessage = message;
        }
    }

    public void flush() {
        saver.save(currentAccumulatedMessage.decorate());
        currentAccumulatedMessage = new DefaultMessage();
    }
}

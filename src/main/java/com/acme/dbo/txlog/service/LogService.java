package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.message.AbstractMessage;
import com.acme.dbo.txlog.message.NullMessage;
import com.acme.dbo.txlog.saver.AbstractSaver;

public class LogService {
    private AbstractMessage currentAccumulatedMessage = new NullMessage();
    private AbstractSaver saver;

    public LogService(AbstractSaver saver) {
        this.saver=saver;
    }

    public void log(AbstractMessage message) {
        if (currentAccumulatedMessage.isSame(message)) {
            currentAccumulatedMessage = currentAccumulatedMessage.accumulate(message);
        } else {
            flush();
            currentAccumulatedMessage = message;
        }
    }

    public void flush() {
        saver.save(currentAccumulatedMessage.decorate());
        currentAccumulatedMessage = new NullMessage();
    }
}

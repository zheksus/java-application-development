package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.message.DefaultMessage;
import com.acme.dbo.txlog.saver.Saver;
import com.acme.dbo.txlog.saver.SaverMessageIsNullException;

public class LogService {
    private Message currentAccumulatedMessage = new DefaultMessage();
    private Saver saver;

    public LogService(Saver saver) {
        this.saver=saver;
    }

    public void log(Message message) throws LogOperationException {
        if (currentAccumulatedMessage.isSame(message)) {
            currentAccumulatedMessage = currentAccumulatedMessage.accumulate(message);
        } else {
            flush();
            currentAccumulatedMessage = message;
        }
    }

    public void flush() throws LogOperationException {
        try {
//            saver.save(currentAccumulatedMessage.decorate());
            saver.save(null);
        }
        catch (SaverMessageIsNullException e) {
            e.printStackTrace();
            throw new LogOperationException(e.getMessage());
        }
        currentAccumulatedMessage = new DefaultMessage();
    }
}

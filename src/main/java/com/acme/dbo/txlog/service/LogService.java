package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.message.AbstractMessage;
import com.acme.dbo.txlog.message.NullMessage;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class LogService {
    private AbstractMessage currentAccumulatedMessage = new NullMessage();

    public LogService() {
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
        print(currentAccumulatedMessage.decorate());
        currentAccumulatedMessage = new NullMessage();
    }
}

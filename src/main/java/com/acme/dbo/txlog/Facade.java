package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.saver.ConsoleSaver;
import com.acme.dbo.txlog.service.LogOperationException;
import com.acme.dbo.txlog.service.LogService;

public class Facade {
    private static final LogService logger = new LogService(new ConsoleSaver());

    public static void log(int message) throws LogOperationException {
        logger.log(new IntMessage(message));
    }

    public static void log(String message) throws LogOperationException {
        logger.log(new StringMessage(message));
    }

    public static void flush() throws LogOperationException {
        logger.flush();
    }
}

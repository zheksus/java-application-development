package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.service.LogService;

import static com.acme.dbo.txlog.decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class Facade {
    private static LogService logger = new LogService();


    public static void log(int message) {
        logger.log(new IntMessage(message));
    }

    public static void log(String message) {
        logger.log(new StringMessage(message));
    }

    public static void flush() {
        logger.flush();
    }

}

package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.service.LogService;

import static com.acme.dbo.txlog.decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class Facade {
//    private static int integerAccumulator = 0;
//    private static String stringAccumulator = null;
//    private static int stringCounter = 0;
//    private static boolean integerAccumulationMode = false;
//    private static boolean stringAccumulationMode = false;

    private static LogService logger = new LogService();


    public static void log(int message) {
        logger.log(new IntMessage(message));

//        flushString();
//
//        if (message > Integer.MAX_VALUE - integerAccumulator) {
//            flushInteger();
//            print(decorate(message));
//        } else {
//            integerAccumulator += message;
//            integerAccumulationMode = true;
//        }
    }

//    public static void log(byte message) {
//        flush();
//        print(decorate(message));
//    }

//    public static void log(char message) {
//        print(decorate(message));
//    }

    public static void log(String message) {
        logger.log(new StringMessage(message));
/*
        if (message == null)
            return;

        flushInteger();

        if (!stringAccumulationMode) {
            startStringAccumulation(message);
        } else {
            if (message.equals(stringAccumulator)) {
                stringCounter++;
            } else {
                flush();
                startStringAccumulation(message);
            }
        }
 */
    }

//    public static void log(boolean message) {
//        print(decorate(message));
//    }

//    public static void log(Object message) {
//        print(decorate(message));
//    }

    public static void flush() {
        logger.flush();
//        flushInteger();
//        flushString();
    }

/*
    private static void startStringAccumulation(String message) {
        stringCounter = 1;
        stringAccumulator = message;
        stringAccumulationMode = true;
    }

    private static void flushInteger() {
        if (integerAccumulationMode) {
            print(decorate(integerAccumulator));
            integerAccumulationMode = false;
            integerAccumulator = 0;
        }
    }

    private static void flushString() {
        if (stringAccumulationMode) {
            if (stringCounter > 1) {
                print(decorate(stringAccumulator + " (x" + stringCounter + ")"));
            } else {
                print(decorate(stringAccumulator));
            }
            stringAccumulationMode = false;
            stringAccumulator = null;
            stringCounter = 0;
        }
    }
 */
}

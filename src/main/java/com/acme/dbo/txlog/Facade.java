package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.Printer.ConsolePrinter.print;

public class Facade {
    private static int integerAccumulator = 0;
    private static String stringAccumulator = null;
    private static int stringCounter = 0;
    private static boolean integerAccumulationMode = false;
    private static boolean stringAccumulationMode = false;


    public static void log(int message) {
        if (stringAccumulationMode) {
            flush();
        }
        if (message > Integer.MAX_VALUE - integerAccumulator) {
            printDecoratedIntegerAndDisableAccumulator();
            print(decorate(message));
        } else {
            integerAccumulator += message;
            integerAccumulationMode = true;
        }
    }

    public static void log(byte message) {
        if (stringAccumulationMode) {
            flush();
        }
        if (integerAccumulationMode) {
            printDecoratedIntegerAndDisableAccumulator();
        }
        print(decorate(message));
//        print(decorate(message));
    }

    public static void log(char message) {
        print(decorate(message));
    }

    public static void log(String message) {
        if (integerAccumulationMode) {
            flush();
        }

        if (stringAccumulationMode == false) {
            stringAccumulator = message;
            stringAccumulationMode = true;
            stringCounter++;
        } else {
            if (message != null) {
                if (message.equals(stringAccumulator)) {
                    stringCounter++;
                } else {
                    flush();
                    stringCounter = 1;
                    stringAccumulator = message;
                    stringAccumulationMode=true;
                }
            }
        }

//        print(decorate(message));
    }

    public static void log(boolean message) {
        print(decorate(message));
    }

    public static void log(Object message) {
        print(decorate(message));
    }

    public static void flush() {
        printDecoratedIntegerAndDisableAccumulator();
        printDecoratedStringAndDisableAccumulator();
    }

    private static void printDecoratedIntegerAndDisableAccumulator() {
        if (integerAccumulationMode) {
            print(decorate(integerAccumulator));
            integerAccumulationMode = false;
            integerAccumulator = 0;
        }
    }

    private static void printDecoratedStringAndDisableAccumulator() {
        if (stringAccumulationMode) {
            if (stringCounter > 1) {
                print(decorate(stringAccumulator + " (x" + stringCounter + ")"));
            } else {
                print(decorate(stringAccumulator));
            }
            stringAccumulationMode = false;
            stringAccumulator = null;
            stringCounter=0;
        }
    }

}

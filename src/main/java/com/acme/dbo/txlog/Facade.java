package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.Printer.ConsolePrinter.print;

public class Facade {
    private static int aggregationSum = 0;
    private static boolean aggregationMode = false;

    public static void log(int message) {
        if (message > Integer.MAX_VALUE - aggregationSum) {
            printDecoratedAggregationAndDisableAggregationMode();
            print(decorate(message));
        } else {
            aggregationSum += message;
            aggregationMode = true;
        }
    }

    public static void log(byte message) {
        if (message > Byte.MAX_VALUE - aggregationSum) {
            printDecoratedAggregationAndDisableAggregationMode();
            print(decorate(message));
        } else {
            aggregationSum += message;
            aggregationMode = true;
        }

//        print(decorate(message));
    }

    public static void log(char message) {
        print(decorate(message));
    }
    public static void log(String message) {
        if (aggregationMode) {
            printDecoratedAggregationAndDisableAggregationMode();
        }
        print(decorate(message));
    }

    public static void log(boolean message) {
        print(decorate(message));
    }

    public static void log(Object message) {
        print(decorate(message));
    }

    public static void flush() {
        printDecoratedAggregationAndDisableAggregationMode();
    }

    private static void printDecoratedAggregationAndDisableAggregationMode() {
        print(decorate(aggregationSum));
        aggregationMode = false;
        aggregationSum = 0;
    }

}

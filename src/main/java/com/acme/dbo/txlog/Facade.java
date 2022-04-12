package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.Decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.Printer.ConsolePrinter.print;

public class Facade {
    public static void log(int message) {
        print(decorate(message));
    }

    public static void log(byte message) {
        print(decorate(message));
    }

    public static void log(char message) {
        print(decorate(message));
    }

    public static void log(String message) {
        print(decorate(message));
    }

    public static void log(boolean message) {
        print(decorate(message));
    }

    public static void log(Object message) {
        print(decorate(message));
    }

}

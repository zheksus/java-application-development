package com.acme.dbo.txlog.Decorator;

public class PrefixDecorator {

    public static final String MESSAGE_PREFIX = "primitive: ";
    public static final String CHAR_MESSAGE_PREFIX = "char: ";
    public static final String STRING_MESSAGE_PREFIX = "string: ";
    public static final String OBJECT_MESSAGE_PREFIX = "reference: ";

    public static String decorate(int message) {
        return MESSAGE_PREFIX + message;
    }

    public static String decorate(char message) {
        return CHAR_MESSAGE_PREFIX + message;
    }

    public static String decorate(String message) {
        return STRING_MESSAGE_PREFIX + message;
    }

    public static String decorate(boolean message) {
        return MESSAGE_PREFIX + message;
    }

    public static String decorate(Object message) {
        return OBJECT_MESSAGE_PREFIX + message;
    }

}

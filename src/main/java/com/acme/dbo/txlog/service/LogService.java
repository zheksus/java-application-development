package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;

import static com.acme.dbo.txlog.decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;
import static com.acme.dbo.txlog.service.AccumulationMode.*;

public class LogService {
    private AccumulationMode mode = NONE;
    private int integerAccumulator = 0;
    private String stringAccumulator = "";
    private int stringCounter = 0;

    public LogService() {
    }

    public void log(IntMessage message) {
        if (mode == STRING_ACCUMULATION) {
            flushString();
        }
        mode = INTEGER_ACCUMULATION;
        integerAccumulator += message.getValue();
    }

    private void flushString() {
        if (stringCounter > 1) {
            print(decorate(stringAccumulator + " (x" + stringCounter + ")"));
        } else {
            print(decorate(stringAccumulator));
        }
        stringAccumulator = null;
        stringCounter = 0;
    }

    public void flush() {
        if (mode == INTEGER_ACCUMULATION) {
            flushInteger();
        } else if (mode == STRING_ACCUMULATION) {
            flushString();
        }
    }

    private void startStringAccumulation(String message) {
        stringCounter = 1;
        stringAccumulator = message;
        mode = STRING_ACCUMULATION;
    }

    private void flushInteger() {
        print(decorate(integerAccumulator));
        integerAccumulator = 0;
    }


    public void log(StringMessage message) {
        if (message == null)
            return;

        if (mode == INTEGER_ACCUMULATION) {
            flushInteger();
            startStringAccumulation(message.getValue());
        } else if (mode == NONE) {
            startStringAccumulation(message.getValue());
        } else {
            if (message.getValue().equals(stringAccumulator)) {
                stringCounter++;
            } else {
                flush();
                startStringAccumulation(message.getValue());
            }
        }
    }
}

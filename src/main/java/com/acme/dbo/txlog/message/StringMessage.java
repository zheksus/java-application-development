package com.acme.dbo.txlog.message;

import jdk.nashorn.internal.ir.annotations.Immutable;

public class StringMessage implements AbstractMessage {
    ///// Try to implement immutable!!!!!
    @Immutable
    private final String data;

    @Immutable
    private final int counter;

    public StringMessage(String message) {
        this.data = message;
        this.counter = 1;
    }

    public StringMessage(String message, int counter) {
        this.data = message;
        this.counter = counter;
    }

    @Override
    public AbstractMessage accumulate(AbstractMessage message) {
        return new StringMessage(data, counter + 1);
    }

    @Override
    public boolean isSame(AbstractMessage message) {
        if ((message instanceof StringMessage) && (((StringMessage) message).data.equals(data))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String decorate() {
        if (counter > 1)
            return "string: " + data + " (x" + counter + ")";
        else
            return "string: " + data;

    }
}

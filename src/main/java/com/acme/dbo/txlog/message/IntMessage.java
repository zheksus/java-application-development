package com.acme.dbo.txlog.message;

public class IntMessage extends PrefixDecoratedMessage {

    private final int accumulatedInt;

    public IntMessage(int message) {
        super("primitive: ");
        this.accumulatedInt = message;
    }

    @Override
    public boolean isSame(Message message) {
        return (message instanceof IntMessage);
    }

    @Override
    public IntMessage accumulate(Message message) {
        return new IntMessage(accumulatedInt + ((IntMessage)message).accumulatedInt);
    }

    @Override
    public String decorate() {
        return decorate(String.valueOf(accumulatedInt));
    }

}

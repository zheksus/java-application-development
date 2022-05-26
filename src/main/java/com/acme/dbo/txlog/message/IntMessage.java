package com.acme.dbo.txlog.message;

public class IntMessage extends PrefixDecoratedMessage {

    private final int accumulatedInt;

    public IntMessage(int message) {
        super("primitive: ");
        this.accumulatedInt = message;
    }

    @Override
    public boolean isSame(AbstractMessage message) {
        if (message instanceof IntMessage)
            return true;
        else
            return false;
    }

    @Override
    public IntMessage accumulate(AbstractMessage message) {
        return new IntMessage(accumulatedInt + ((IntMessage)message).accumulatedInt);
    }

    @Override
    public String decorate() {
        return decorate(String.valueOf(accumulatedInt));
    }

}

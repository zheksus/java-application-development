package com.acme.dbo.txlog.message;

public class IntMessage implements AbstractMessage {
/* TODO: Implement Prefix through inheritance

 */

    private final int accumulatedInt;

    public IntMessage(int message) {
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
        return "primitive: " + accumulatedInt;
    }

}

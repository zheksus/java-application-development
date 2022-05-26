package com.acme.dbo.txlog.message;

public class StringMessage extends PrefixDecoratedMessage {

    private final String data;
    private final int counter;

    public StringMessage(String message) {
        super("string: ");
        this.data = message;
        this.counter = 1;
    }

    public StringMessage(String message, int counter) {
        super("string: ");
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
            return decorate(data + " (x" + counter + ")");
        else
            return decorate(data);

    }
}

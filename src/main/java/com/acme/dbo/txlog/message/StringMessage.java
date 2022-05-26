package com.acme.dbo.txlog.message;

public class StringMessage extends PrefixDecoratedMessage {

    private final String data;
    private final int counter;

    public StringMessage(String message) {
        this(message, 1);
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
        String str = data;
        if (counter > 1)
            str += " (x" + counter + ")";
        return decorate(str);
    }
}

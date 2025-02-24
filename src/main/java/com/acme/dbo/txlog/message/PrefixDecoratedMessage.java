package com.acme.dbo.txlog.message;

public abstract class PrefixDecoratedMessage implements Message {
    private final String prefix;

    public PrefixDecoratedMessage(String prefix) {
        this.prefix = prefix;
    }

    protected String decorate(String message) {
        return prefix + message;
    }
}

package com.acme.dbo.txlog.message;

public class DefaultMessage implements Message {
    @Override
    public Message accumulate(Message msg) {
        return msg;
    }

    @Override
    public boolean isSame(Message message) {
        return true;
    }

    @Override
    public String decorate() {
        return null;
    }
}

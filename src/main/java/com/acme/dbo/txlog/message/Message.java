package com.acme.dbo.txlog.message;

public interface Message {
    Message accumulate(Message message);
    boolean isSame(Message message);
    String decorate();
}

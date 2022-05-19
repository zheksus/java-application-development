package com.acme.dbo.txlog.message;

public class StringMessage {
    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}

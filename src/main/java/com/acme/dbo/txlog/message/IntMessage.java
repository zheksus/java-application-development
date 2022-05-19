package com.acme.dbo.txlog.message;

public class IntMessage {
    private int message;

    public IntMessage(int message) {
        this.message=message;
    }

    public int getValue() {
        return message;
    }
}

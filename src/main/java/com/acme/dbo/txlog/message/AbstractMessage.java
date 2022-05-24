package com.acme.dbo.txlog.message;

public interface AbstractMessage {
    AbstractMessage accumulate(AbstractMessage message);
    boolean isSame(AbstractMessage message);
    String decorate();
}

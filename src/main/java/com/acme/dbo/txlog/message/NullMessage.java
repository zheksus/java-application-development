package com.acme.dbo.txlog.message;

import com.sun.xml.internal.bind.v2.model.annotation.AbstractInlineAnnotationReaderImpl;

public class NullMessage implements AbstractMessage {

    @Override
    public AbstractMessage accumulate(AbstractMessage msg) {
        return msg;
    }

    @Override
    public boolean isSame(AbstractMessage message) {
        return true;
    }

    @Override
    public String decorate() {
        return null;
    }
}

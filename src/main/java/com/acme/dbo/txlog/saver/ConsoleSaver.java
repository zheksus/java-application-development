package com.acme.dbo.txlog.saver;

public class ConsoleSaver implements Saver {
    public void save(String message) throws SaverMessageIsNullException {
        if (message == null) {
            throw new SaverMessageIsNullException("No message specified");
        }
        System.out.print(message + "\n");
    }
}

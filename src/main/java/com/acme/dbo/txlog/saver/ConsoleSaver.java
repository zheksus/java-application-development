package com.acme.dbo.txlog.saver;

public class ConsoleSaver implements AbstractSaver{
    public void save(String message) {
        System.out.print(message + "\n");
    }
}

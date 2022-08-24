package com.db.database;

public abstract class Connector {

    public  abstract void connect();
    public abstract void disconnect();
    public abstract boolean insert();

}

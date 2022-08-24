package com.db.database;

public class NoSQLConnector extends Connector {


    @Override
    public void connect() {
        System.out.println("NoSQL is connected");
    }

    @Override
    public void disconnect() {
        System.out.println("NoSQL is connected");
    }

    @Override
    public boolean insert() {
        return false;
    }
}

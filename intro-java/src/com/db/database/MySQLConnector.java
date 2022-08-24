package com.db.database;

public class MySQLConnector extends Connector {
    @Override
    public void connect() {
        System.out.println("MySQL is connected");
    }

    @Override
    public void disconnect() {
        System.out.println("MySQL is disconnected");

    }

    @Override
    public boolean insert() {
        limit();
        return true;
    }


    private void limit() {

    }
}

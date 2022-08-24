package com.db.database;

public class DatabaseConnect {

    Connector connector;

    public DatabaseConnect(Connector connector) {
        this.connector = connector;
    }

    public static void main(String args[]) {
        Connector connector = new MySQLConnector();
        DatabaseConnect databaseConnect = new DatabaseConnect(connector);
        databaseConnect.connector.connect();
        databaseConnect.connector.disconnect();
    }

}

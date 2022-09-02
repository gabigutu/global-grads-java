import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBConnect {

    private static DBConnect instance = null;
    private Connection connection = null;

    public static DBConnect getInstance()  {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }

    private DBConnect() {
        this.connect();
    }

    private void connect() {
        String connectionString = "jdbc:mysql://localhost:3306/amazon";
        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("Successfully connected");
        } catch (SQLException exception) {
            System.err.println("Cannot connect to MySQL");
        }
    }

    public ResultSet selectRow(String tableName, HashMap<String, String> whereClauses) throws SQLException {
        Statement ps = connection.createStatement();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT * FROM ").append(tableName).append(" WHERE 1");
        for (Map.Entry<String, String> entry : whereClauses.entrySet()) {
            sqlQuery.append(" AND " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Trying to execute query: " + sqlQuery.toString());
        ResultSet rs = ps.executeQuery(sqlQuery.toString());
        return rs;
    }
    public int updateRow(String tableName, HashMap<String, String> whereClauses, String column, String set) throws SQLException {
        Statement ps = connection.createStatement();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("UPDATE ").append(tableName).append(" SET ").append(column).append(" = ").append("\"" + set + "\"").append(" WHERE 1");
        for (Map.Entry<String, String> entry : whereClauses.entrySet()) {
            sqlQuery.append(" AND " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Trying to execute query: " + sqlQuery.toString());
        int rs = ps.executeUpdate(sqlQuery.toString());
        return rs;
    }
    public boolean insertRowCustomer(String tableName, HashMap<String, String> whereClauses,
                                 String username, String last_name, String fist_name, String phone, String address, String city,
                                 String postalCode, String country) throws SQLException {
        Statement ps = connection.createStatement();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO ").append(tableName).append("(username,last_name,fist_name,phone,address,city,postalCode,country) VALUES")
                .append("(\"" + username + "\",")
                .append("\"" + last_name + "\",")
                .append("\"" + fist_name + "\",")
                .append("\"" + phone + "\",")
                .append("\"" + address + "\",")
                .append("\"" + city + "\",")
                .append("\"" + postalCode + "\",")
                .append("\"" + country + "\")");
        for (Map.Entry<String, String> entry : whereClauses.entrySet()) {
            sqlQuery.append(" AND " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Trying to execute query: " + sqlQuery.toString());
        boolean rs = ps.execute(sqlQuery.toString());
        return rs;
    }
    public boolean deleteRow(String tableName, HashMap<String, String> whereClauses) throws SQLException {
        Statement ps = connection.createStatement();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("DELETE FROM ").append(tableName).append(" WHERE 1");
        for (Map.Entry<String, String> entry : whereClauses.entrySet()) {
            sqlQuery.append(" AND " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Trying to execute query: " + sqlQuery.toString());
        boolean rs = ps.execute(sqlQuery.toString());
        return rs;
    }

}

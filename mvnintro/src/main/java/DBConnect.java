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
        String connectionString = "jdbc:mysql://localhost:3306/db_tech_school";
        String username = "root";
        String password = "D@t@tables";

        try {
            connection = DriverManager.getConnection(connectionString, username, password);
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




}

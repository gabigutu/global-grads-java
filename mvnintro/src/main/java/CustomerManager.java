import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@PrimaryKeyColumn(columnName = "customer_id")
@DatabaseTable(tableName = "customers", tableColumn = "phone")
public class CustomerManager extends TableManager {

    private String primaryKeyColumnName;

    public CustomerManager() {
        super();
        try {
            readAnnotations();
        } catch (TableNameNotSpecifiedException e) {
            System.err.println("Table not specified: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void readAnnotations() throws TableNameNotSpecifiedException {
        super.readAnnotations();
        Class thisClass = this.getClass();
        PrimaryKeyColumn primaryKeyAnnotation = (PrimaryKeyColumn) thisClass.getAnnotation(PrimaryKeyColumn.class);
        if (primaryKeyAnnotation != null) {
            primaryKeyColumnName = primaryKeyAnnotation.columnName();
        }
    }

    public Customer queryCustomer(ResultSet rs) throws SQLException {
        while(rs.next()) {
            return new Customer(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("postal_code"),
                    rs.getString("country")
            );
        }
        return null;
    }

    public Customer selectById(DBConnect dbConnect, int id) throws SQLException {
        Map<String, String> whereClauses = new HashMap<>();
        whereClauses.put("id", String.valueOf(id));
//        whereClauses.put("id", (new Integer(id)).toString());
//        whereClauses.put("id", Integer.valueOf(id).toString());
        return this.select(dbConnect, whereClauses);
    }

    public Customer select(DBConnect dbConnnect, Map<String, String> whereClauses) throws SQLException {
        ResultSet rs = dbConnnect.selectRow(tableName, whereClauses);
        Customer customer = queryCustomer(rs);
        return customer;
    }
    public ResultSet selectAll(DBConnect dbConnnect) throws SQLException {
        Map<String, String> whereClauses = new HashMap<>();
        return dbConnnect.selectRow(tableName,whereClauses);
    }

    public boolean deleteById(DBConnect dbConnect, int id) throws SQLException {
        Map<String, String> whereClauses = new HashMap<>();
        whereClauses.put("id", String.valueOf(id));
        return dbConnect.deleteRow(tableName, whereClauses);
    }
    public int updateById(DBConnect dbConnect, int id) throws SQLException {
        Map<String, String> whereClauses = new HashMap<>();
        whereClauses.put("id", String.valueOf(id));
        return dbConnect.updateRow(tableName, whereClauses, tableColumn, "0751111111");
    }

}

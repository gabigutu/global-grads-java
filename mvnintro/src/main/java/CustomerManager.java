import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerManager {

    public Customer queryCustomer(ResultSet rs) throws SQLException {
        while(rs.next()) {
            return new Customer(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("last_name"),
                    rs.getString("fist_name"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("postalCode"),
                    rs.getString("country")
            );
        }
        return null;
    }

}

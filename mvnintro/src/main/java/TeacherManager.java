import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherManager {

    public Teacher queryTeacher(ResultSet rs) throws SQLException {
        while(rs.next()) {
            return new Teacher(
                    rs.getString("customer_id"), // join customer
                    rs.getDate("payment_date"),
                    rs.getFloat("amount")
            );
        }
        return null;
    }

}

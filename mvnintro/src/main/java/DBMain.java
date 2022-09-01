import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DBMain {

    public static void main(String args[]) {
        DBConnect dbConnnect = DBConnect.getInstance();
        TeacherManager teacherManager = new TeacherManager();
        try {
            HashMap<String, String> whereClauses = new HashMap<>();
            whereClauses.put("customer_id", "2");
            whereClauses.put("amount", "77.0");
            ResultSet rs = dbConnnect.selectRow("payments", whereClauses);
            Teacher teacher = teacherManager.queryTeacher(rs);
            System.out.println(teacher);
        } catch (SQLException exception) {
            System.err.println("Select exception: " + exception.getMessage());
        }
    }
}

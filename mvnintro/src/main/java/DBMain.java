import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBMain {

    public static void main(String args[]) {
        List<Customer> customers = new ArrayList<>();
        DBConnect dbConnnect = DBConnect.getInstance();
        CustomerManager customerManager = new CustomerManager();
        try {
            HashMap<String, String> whereClauses = new HashMap<>();
 //           whereClauses.put(" ", " ");
 //           whereClauses.put("amount", "77.0");
//            ResultSet rs = dbConnnect.selectRow("customers", whereClauses);
//            Customer customer = customerManager.queryCustomer(rs);
            Customer customer = customerManager.select(dbConnnect, whereClauses);
            customers.add(customer);
//            while(customer != null){
//                customer = customerManager.queryCustomer(rs);
//                customers.add(customer);
//                System.out.println(customer);
//            }
            System.out.println(customer);
        } catch (SQLException exception) {
            System.err.println("Select exception: " + exception.getMessage());
        }
        try {
            HashMap<String, String> whereClauses = new HashMap<>();
                       whereClauses.put("id", "2");
            //           whereClauses.put("amount", "77.0");
            dbConnnect.updateRow("customers", whereClauses,"phone", "0732222222");
        } catch (SQLException exception) {
            System.err.println("Select exception: " + exception.getMessage());
        }
        try {
        HashMap<String, String> whereClauses = new HashMap<>();
       // whereClauses.put("id", "2");
        //           whereClauses.put("amount", "77.0");
        dbConnnect.insertRowCustomer("customers", whereClauses,
                "Andrei97",
                "Popescu",
                "Andrei",
                "0755323123",
                "Str.Libertatii",
                "Bucuresti",
                "342000",
                "Romania");
    } catch (SQLException exception) {
        System.err.println("Select exception: " + exception.getMessage());
    }
        try {
            HashMap<String, String> whereClauses = new HashMap<>();
             whereClauses.put("id", "10");
            //           whereClauses.put("amount", "77.0");
            dbConnnect.deleteRow("customers", whereClauses);
        } catch (SQLException exception) {
            System.err.println("Select exception: " + exception.getMessage());
        }

    }
}

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import org.apache.log4j.PropertyConfigurator;
import spark.Request;
import spark.Spark;

public class DBMain {

    public static void main(String args[]) {

//        Logger logger = Logger.getLogger("CustomerLogger");
//        logger.log(Level.WARNING, "Application started");
        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        DBConnect dbConnnect = DBConnect.getInstance();
        CustomerManager customerManager = new CustomerManager();
        Gson gson = new Gson();

        Spark.get("/api/customer/:id", (request, response) -> {
            int customerId = intFromReuqestParam(request, "id");
            if (customerId == 0) {
                return null;
            }
//            System.out.println("No of params: " + request.params().size());
            System.out.println("Customer id = " + customerId);
//            System.out.println(request);
//            System.out.println(response);
            Customer customer = customerManager.selectById(dbConnnect, customerId);
            if (customer == null) {
                return "{}";
            }
            String customerStr = gson.toJson(customer);
            System.out.println("Customer as JSON = " + customerStr);
            return customerStr;
        });
        Spark.delete("/api/customer/:id", (request, respones) -> {
            int customerId = intFromReuqestParam(request, "id");
            if (customerId == 0) {
                return null;
            }
            boolean deleted = customerManager.deleteById(dbConnnect, customerId);
            if (!deleted) {
                System.err.println("Customer with id = " + customerId + " was already deleted");
            }
            return "{}";
        });
        Spark.get("/api/maps/:lat-:long", (request, respones) -> {
            int lat = intFromReuqestParam(request, "lat");
            int _long = intFromReuqestParam(request, "long");
            return "{" +
                    "lat:" + lat + ", " +
                    "long:" + _long +
                    "}";
        });
        // spark.update customerId
        // spark.get all customer
        // spark.delete existent customer (on cascade delete) {}
        // spark.delete non-existent customer {}
        // spark.get maps (lang, long) fix
    }

    static int intFromReuqestParam(Request request, String paramName) {
        try {
            return Integer.parseInt(request.params(":" + paramName));
        } catch(NumberFormatException exception) {
            System.err.println("ID error: " + exception.getClass().getName() + " " + exception.getMessage());
            return 0;
        }
    }

    public static void exampleQuries() {
        List<Customer> customers = new ArrayList<>();
        DBConnect dbConnnect = DBConnect.getInstance();
        CustomerManager customerManager = new CustomerManager();
        TeacherManager teacherManager = new TeacherManager();
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
            dbConnnect.updateRow("customers", whereClauses, "phone", "0732222222");
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

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo_csdl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class App {
      

    public static void main(String[] args) {
        Properties properties = new Properties();
        String url = "jdbc:mysql://localhost:3306/demobanhang";
        // String user = properties.getProperty("db.user");
        // String password = properties.getProperty("db.password");
        String user = "";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
            // Perform database operations here
            Statement st = connection.createStatement();
            String sqlqueryString = "select * from sanpham";
            ResultSet res = st.executeQuery(sqlqueryString);
            while(res.next()){
                int id = res.getInt("id");
                String tenSanPham = res.getNString("tenSanPham");
                String mota = res.getNString("mota");
                StringBuilder inketqua = new StringBuilder();
                inketqua.append(id).append("\t").append(tenSanPham).append("\t").append(mota);
                System.out.println(inketqua.toString());
                            
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

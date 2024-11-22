package vn.architectual_3layer.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTemplate <T>{
 
  String nameDatabase;
  public final void save(T entity) {

   Connection connection = openConnection(nameDatabase);
   insertData(entity,connection);
   closeConnection(connection);
 }
  public DbTemplate(String nameDatabase) {
    this.nameDatabase = nameDatabase;
  }
  public final List<T> query(Class<T> clazz, String nameDatabase) {
    Connection connection = openConnection(nameDatabase);
    List<T> list = selectAllData(clazz,connection);
    closeConnection(connection);
    return list;
  }


  protected Connection openConnection(String nameDatabase) {
    Connection con = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      String connectionURL = "jdbc:mysql://localhost:3306/"+nameDatabase;
      con = DriverManager.getConnection(connectionURL, "root", "123");
      System.out.println("Connection successful!");
    } catch (ClassNotFoundException e) {
      System.out.println("MySQL Driver not found!");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("Connection failed!");
      e.printStackTrace();
    }
    return con;
  }

  
  protected void insertData(T entity, Connection connection) {
    String tableName = entity.getClass().getSimpleName();
    StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
    StringBuilder values = new StringBuilder("VALUES (");

    try {
      Field[] fields = entity.getClass().getDeclaredFields();
      int fieldCount = 0; 
      for (int i = 0; i < fields.length; i++) {
        fields[i].setAccessible(true);
        if (!fields[i].getName().equalsIgnoreCase("id")) { 
          sql.append(fields[i].getName());
          values.append("?");

          fieldCount++; 

          if (i < fields.length - 1) {
            sql.append(", ");
            values.append(", ");
          }
        }
      }

      if (sql.charAt(sql.length() - 2) == ',') {
        sql.delete(sql.length() - 2, sql.length());
        values.delete(values.length() - 2, values.length());
      }

      sql.append(") ").append(values).append(")");

      //  PreparedStatement
      try (PreparedStatement pstmt = connection.prepareStatement(sql.toString())) {
        int paramIndex = 1;
        for (Field field : fields) {
          if (!field.getName().equalsIgnoreCase("id")) { // Bỏ qua trường 'id'
            pstmt.setObject(paramIndex++, field.get(entity));
          }
        }

        pstmt.executeUpdate();
        System.out.println("Thêm thành công");
      }
    } catch (IllegalAccessException | SQLException e) {
      e.printStackTrace();
    }
  }

  protected List<T> selectAllData(Class<T> clazz, Connection connection) {
    String tableName = clazz.getSimpleName();
    String sql = "SELECT * FROM " + tableName;
    List<T> list = new ArrayList<>();
    try (PreparedStatement pstmt = connection.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

      Field[] fields = clazz.getDeclaredFields();
      while (rs.next()) {
        T entity = clazz.getDeclaredConstructor().newInstance();
        for (Field field : fields) {
          field.setAccessible(true);
          String columnName = field.getName().toLowerCase(); 
          field.set(entity, rs.getObject(columnName));
        }

       
        list.add(entity);
      }
    } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchMethodException |
             InvocationTargetException e) {
      e.printStackTrace();
    }
    return list;
  }

  protected void closeConnection(Connection con) {
    if (con != null) {
      try {
        con.close();
        System.out.println("Connection closed!");
      } catch (SQLException e) {
        System.out.println("Failed to close connection!");
        e.printStackTrace();
      }
    }
  }

}

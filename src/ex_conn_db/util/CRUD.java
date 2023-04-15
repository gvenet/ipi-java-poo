package util;
import java.sql.*;

public class CRUD {

  Connection conn;
  Statement st;

  public CRUD() {
    try {
      conn = this.getConnection();
      this.st = conn.createStatement();
      this.st.executeUpdate(
        "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,name varchar(30));"
      );
      st = conn.createStatement();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void create(String name) {
    try {
      this.st.executeUpdate(
          "insert into users (name ) values ('" + name + "')");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void update(int id, String name) {
    try {
      this.st.executeUpdate(
          "update users set name ='" + name + "' where id = '" + id + "'");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void delete(int id) {
    try {
      this.st.executeUpdate(
          "delete from users where id = " + id);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void read() {
    try {
      ResultSet rs = this.st.executeQuery("SELECT id,name FROM users");
      ResultSetMetaData rsmd = rs.getMetaData();
      int numColumns = rsmd.getColumnCount();
      while (rs.next()) {
        for (int i = 1; i <= numColumns; i++) {
          System.out.print(rs.getString(i) + " ");
        }
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void close() {
    try {
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private Connection getConnection() throws Exception {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/connexion_db";
    String username = "gvenet";
    String password = "gvenet";
    Class.forName(driver);
    return DriverManager.getConnection(url, username, password);
  }
}

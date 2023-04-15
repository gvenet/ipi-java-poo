import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Main {
  public static void main(String[] args) throws Exception {
    Connection conn = getConnection();
    Statement st = conn.createStatement();
    // st.executeUpdate("drop table survey;");
    st.executeUpdate("create table survey (id int,name varchar(30));");
    st.executeUpdate("insert into survey (id,name ) values (1,'nameValue')");

    st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM survey");

    ResultSetMetaData rsMetaData = rs.getMetaData();

    int numberOfColumns = rsMetaData.getColumnCount();
    System.out.println("resultSet MetaData column Count=" + numberOfColumns);

    st.close();
    conn.close();
  }

  private static Connection getConnection() throws Exception {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/connexion_db";
    String username = "gvenet";
    String password = "gvenet";
    Class.forName(driver);
    return DriverManager.getConnection(url, username, password);
    // return DriverManager.getConnection("jdbc:mysql://localhost:3306/connexion_db?user=root&password=root");
  }
}
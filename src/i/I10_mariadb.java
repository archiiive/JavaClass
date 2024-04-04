package i;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class I10_mariadb {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      try {
         Class.forName("org.mariadb.jdbc.Driver");
         conn = DriverManager.getConnection(
               "jdbc:mariadb://localhost:3306/testdb",
               "root",
               "root1234");//password
         System.out.println(conn);
         System.out.println("DB 접속 성공");
      } catch (ClassNotFoundException e) {
         // TODO: handle exception
         System.out.println("드라이버 로드 실패");
      } catch (SQLException sqle) {
         // TODO: handle exception
         System.out.println("SQL연동 실패");
         System.out.println(sqle.getMessage());
      }
   }

}


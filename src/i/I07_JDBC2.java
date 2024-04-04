package i;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner; // Scanner 클래스 import

public class I07_JDBC2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root1234");
            System.out.println("db연동됨");
            stmt = conn.createStatement();

            System.out.print("검색 방법을 선택하세요 (1: id, 2: 이름): ");
            int consoleNum = scanner.nextInt(); // 사용자 입력 받기

            if (consoleNum == 1) {
                System.out.print("id 값을 입력하세요: ");
                int id = scanner.nextInt();
                String sql = "SELECT * FROM persons WHERE id = " + id;
                rs = stmt.executeQuery(sql);

                if (!rs.next()) {
                    System.out.println("결과가 없습니다.");
                } else {
                    do {
                        int personId = rs.getInt("id");
                        String firstName = rs.getString("firstname");
                        String lastName = rs.getString("lastname");
                        int age = rs.getInt("age");
                        String city = rs.getString("city");
                        System.out.printf("id: %d, 성: %s, 이름: %s, 나이: %d, 도시: %s\n", 
                              personId, firstName, lastName, age, city);
                    } while (rs.next());
                }
            } else if (consoleNum == 2) {
                System.out.print("이름의 일부를 입력하세요: ");
                String insertName = scanner.next();
                String sql = "select * from persons where firstname like '%" 
                + insertName + "%' or lastname like '%" + insertName + "%'";
                rs = stmt.executeQuery(sql);

                if (!rs.next()) {
                    System.out.println("결과가 없습니다.");
                } else {
                    do {
                        int personId = rs.getInt("id");
                        String firstName = rs.getString("firstname");
                        String lastName = rs.getString("lastname");
                        int age = rs.getInt("age");
                        String city = rs.getString("city");
                        System.out.printf("id: %d, 성: %s, 이름: %s, 나이: %d, 도시: %s\n", 
                              personId, firstName, lastName, age, city);
                    } while (rs.next());
                }
            } else {
                System.out.println("잘못된 선택입니다.");
            }
            	//scan.close;
        } catch (ClassNotFoundException ce) {
            System.out.println("드라이버 연동 실패");
        } catch (SQLException sqle) {
            System.out.println("SQL 연동 실패");
            System.out.println(sqle.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
                scanner.close(); // Scanner 객체 닫기
            } catch (Exception e) {
                // 예외 처리
            }
        }
        
        
//        System.out.println("입력받기");
//        int scann = scan.nextInt();
//        //sql작성
//        String sql1 = "select * from persons where id = "+inputId;
//        rs= stmt.executeQuery(sql1);
//        if(rs.next()) {
//        	System.out.printf("id: %d, 성: %s, 이름: %s, 나이: %d, 도시: %s\\n",
//        			+ rsgetInt("id"),rs.getString("lastname")rs.getString("firstname"),
//        			rs.getInt("age"),rs.getString("city"));
//        }else {
//        	System.out.println("입력한id가 없습니다.");
//        }
//        	
// 		       	
//        	
//        	
//        }
//      
        
        //이름을 통한 내용을 출력 - 단 이름에 일부를 입력해도 출력해야합니다.
//        System.out.println("이름 입력을 통한 내용 출력 문제");
//       System.out.println("검색할 이름을 입력학세요");
//       
//       //sql구문
//       Stirng sql2 = "select * from persons where firstname like '%'"+searchName+"%'";
//       
//       //sql실행
//       rs = stmt.executeQuery(sql2);
//       
//       while(rs.next()) {
//    	   int id = rs.getInt("id");
//    	   String firstName = rs.getString("firstname");
//           String lastName = rs.getString("lastname");
//           int age = rs.getInt("age");
//           String city = rs.getString("city");
//           System.out.printf("id: %d, 성: %s, 이름: %s, 나이: %d, 도시: %s\n", 
//                 personId, firstName, lastName, age, city);
//       }
        
        
        
        
    }
}
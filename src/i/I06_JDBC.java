package i;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class I06_JDBC {

	public static void main(String[] args) {
		//JDBC 연동 테스트
		
		//데이터베이스 연결객체가 필요함(connection class)
		Connection conn = null;
		
		//checkedException : SqlEception
		
		try {
			//1.드라이브 로드
			//MySQL 6.xx 버전이전:com.mysql.jdbc.Driver
			//MySQL 6.xx 버전이후 :com.mysql.cj.jdbc.Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.Connection 객체 생성 - DriverManager
			//Mysql 6.x미만인경우 : jbdc:mysql://hostname:protnum:/Dbname
			//Mysql 6.xx 이후인경우 : jbdc:mysql://hostname:protnum:/Dbname ? serverTime=UTC
			// seoul utc :Asia/seoul
			conn =DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testdb?serverTimezone=Asia/Seoul"
					, "root", "!qwe123");
				System.out.println(conn);
				System.out.println("DB접속성공");
				//Insert, Update, Delete =  executeUpdate()
				//3. Statment 객체생성 createStatement
				Statement stmt = conn.createStatement();
				
				//4. SQL작성
				//String sql1 = "insert into Persons (firstname, lastname, age, city)"
					//	+ "values('jdbcTest','testuser13',24,'Seoul')";
				String sql2 = "update persons set firstname ='순신', lastname='이' "
						+ "where id = 14";
				String sql3 ="delete from persons where id = '14'";
				//5. Statement 객체를 통해서 작성된 sql을 실행
				int result = stmt.executeUpdate(sql3);
				//성공시 : 1
				//실패시 : 0 
				if(result != 0) {
					System.out.println("SQL 성공");
				}else {
					System.out.println("SQL 실패");
				}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("드라이버 로드 실패");
		} catch (SQLException sqle) {
			// TODO: handle exception
			System.out.println("SQL 연동오류");
			System.out.println(sqle.getMessage());
		}finally {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		

	}

}

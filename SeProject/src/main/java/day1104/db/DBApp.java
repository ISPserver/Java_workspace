/*DB연동 순서
 * 1) 드라이버 로드(자바에서 DB를 연동시켜주는 라이브러리 jar)
 * 2) 접속 시도
 * 3) 쿼리문 수행
 * 4) DB접속을 끊어야 함
 * */
package day1104.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBApp {
	public static void main(String[] args) {
		try {
			//1) 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); //로드하고 싶은 클래스 경로 String으로 명시
			System.out.println("드라이버 로드 성공");
			
			//2) 접속 시도
			String str="jdbc:oracle:thin:@localhost:1521:XE";//접속 문자열
			Connection con=null;
			//접속이 성공되면, con이 반환되므로 따라서 null이면 접속 실패
			con = DriverManager.getConnection(str,"user1104","user1104");
			if(con==null) {
				System.out.println("접속실패");
			}else {
				System.out.println("접속성공");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("지정한 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

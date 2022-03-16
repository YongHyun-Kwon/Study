package stetment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Statement.execute();를 사용한 쿼리문의 실행.
 * 
 * @author user
 */
public class CreateTable {

	public CreateTable() throws SQLException {
		// 1. 드라이버 로딩

		Connection con = null;
		Statement stmt = null;

		try {
			// 2. Connection 얻기
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String id = "scott";
			String pass = "tiger";
			con = DriverManager.getConnection(url, id, pass);
			// 3. 쿼리문생성객체 얻기
			stmt = con.createStatement();

			// 4. 쿼리수행 후 결과 얻기
			String createQuery = "create table test(num int, name varchar(30),input_date datetime default now())";
			stmt.execute(createQuery); // 쿼리실행결과를 받을 수 있으면 true, 받을 수 없으면 false가 리턴
			// 쿼리의 실행이 정상적이라면 조회된 결과가 없어 false가 리턴되고 쿼리의 실행이 실패하면
			// 예외가 발생한다.
			System.out.println("테이블 생성 성공 " + stmt.getQueryTimeout());

		} finally {
			// 5. 연결 끊기
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
	} // createTable

	public static void main(String[] args) {

		try {
			new CreateTable();
		} catch (SQLException se) {
			System.err.println("테이블 생성 실패");
			se.printStackTrace();
		}

	}
}

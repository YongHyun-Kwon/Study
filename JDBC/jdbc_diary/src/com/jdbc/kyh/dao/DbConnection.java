package com.jdbc.kyh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton Pattern을 도입한 클래스 Connection 얻기, 끊기
 */
public class DbConnection {

	private static DbConnection dc;

	/**
	 * 클래스 외부에서 객체화 하는 것을 막는다.
	 */
	private DbConnection() {

	} // DbConnection

	public static DbConnection getInstance() {

		if (dc == null) {
			dc = new DbConnection();
		} // end if

		return dc;

	} // getInstance

	public Connection getConn() throws SQLException {
		Connection con = null;

		// 1. 커넥션 얻기
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);
		
		return con;
	} // getConn
	
	public void close(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		
		if( rs != null ) {
			rs.close();
		} // end if
		
		if( stmt != null ) {
			stmt.close();
		} // end if
		
		if( con != null ) {
			con.close();
		} // end if
		
	} // close

} // class

package com.jdbc.kyh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton Pattern�� ������ Ŭ���� Connection ���, ����
 */
public class DbConnection {

	private static DbConnection dc;

	/**
	 * Ŭ���� �ܺο��� ��üȭ �ϴ� ���� ���´�.
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

		// 1. Ŀ�ؼ� ���
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

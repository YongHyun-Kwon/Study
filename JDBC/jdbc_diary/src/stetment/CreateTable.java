package stetment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Statement.execute();�� ����� �������� ����.
 * 
 * @author user
 */
public class CreateTable {

	public CreateTable() throws SQLException {
		// 1. ����̹� �ε�

		Connection con = null;
		Statement stmt = null;

		try {
			// 2. Connection ���
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String id = "scott";
			String pass = "tiger";
			con = DriverManager.getConnection(url, id, pass);
			// 3. ������������ü ���
			stmt = con.createStatement();

			// 4. �������� �� ��� ���
			String createQuery = "create table test(num int, name varchar(30),input_date datetime default now())";
			stmt.execute(createQuery); // ������������ ���� �� ������ true, ���� �� ������ false�� ����
			// ������ ������ �������̶�� ��ȸ�� ����� ���� false�� ���ϵǰ� ������ ������ �����ϸ�
			// ���ܰ� �߻��Ѵ�.
			System.out.println("���̺� ���� ���� " + stmt.getQueryTimeout());

		} finally {
			// 5. ���� ����
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
			System.err.println("���̺� ���� ����");
			se.printStackTrace();
		}

	}
}

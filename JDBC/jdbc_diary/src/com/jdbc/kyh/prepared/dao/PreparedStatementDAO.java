package com.jdbc.kyh.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.kyh.dao.DbConnection;
import com.jdbc.kyh.prepared.vo.CpEmp1VO;

public class PreparedStatementDAO {

	public PreparedStatementDAO() {
	} // PreparedStatementDAO

	/**
	 * �����ȣ�� �������� �̿��Ѵ�.
	 * 
	 * @param ceVO
	 * @throws SQLException
	 */
	public void insertCpEmp1(CpEmp1VO ceVO) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		DbConnection dc = DbConnection.getInstance();
		try {
			// 1. ����̹� �ε�
			// 2. Ŀ�ؼ� ���
			conn = dc.getConn();
			// 3. �������� �־� ������������ü ���
			String insertCpEmp = "insert into cp_emp1(empno, ename, job, sal, comm) "
					+ "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertCpEmp);
			// 1. ���ε� ������ �� ����
			pstmt.setInt(1, ceVO.getEmpno()); // ó�� ���ε� ������ ������ ��� ��ȣ�� �ִ´�.
			pstmt.setString(2, ceVO.getEname()); // �ι�° ���ε� ������ ���ڿ��� ����̸��� �ִ´�.
			pstmt.setString(3, ceVO.getJob()); // ����° ���ε� ������ ���ڿ��� ������ �ִ´�.
			pstmt.setInt(4, ceVO.getSal()); // �׹�° ���ε� ������ ������ ������ �ִ´�.
			pstmt.setDouble(5, ceVO.getComm()); // �ټ���° ���ε� ������ �Ǽ��� ���ʽ��� �ִ´�.

			// 5. �������� �� ��� ���
			pstmt.executeUpdate();
		} finally {
			// 6. �������
			dc.close(null, pstmt, conn);
		} // end finally

	} // insertCpEmp1

	/**
	 * �����ȣ�� �ش��ϴ� ����� ����, ����, ���ʽ��� ����
	 * 
	 * @param ceVO
	 * @return
	 * @throws SQLException
	 */
	public int updateCpEmp1(CpEmp1VO ceVO) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		DbConnection dc = DbConnection.getInstance();
		try {
			// 1. ����̹��ε�
			// 2. Ŀ�ؼ� ���
			con = dc.getConn();
			// 3. �������� �־� ������ ���ఴü ���
			StringBuilder updateCpEmp1 = new StringBuilder();
			updateCpEmp1.append("	update	cp_emp1				").append("	set	job=?, sal=?, comm=?	") // ���ε庯������
																											// ���ڿ� ������
																											// '�� �������
																											// �ʴ´�.
					.append("	where	empno = ? 			");

			pstmt = con.prepareStatement(updateCpEmp1.toString());
			// 1. ���ε庯���� �� �Ҵ�
			pstmt.setString(1, ceVO.getJob());
			pstmt.setInt(2, ceVO.getSal());
			pstmt.setDouble(3, ceVO.getComm());
			pstmt.setInt(1, ceVO.getEmpno());

			// 5. �������� �� ��� ���
			cnt = pstmt.executeUpdate();
		} finally {
			// 6. ���� ����
			dc.close(null, pstmt, con);
		} // end finally

		return cnt;

	} // updateCpEmp1

	/**
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	/**
	 * �����ȣ�� �Է¹޾� �Էµ� �����ȣ�� �ش��ϴ� ��� ��� ����.
	 * 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public int deleteCpEmp1(int empno) throws SQLException {

		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		DbConnection dc = DbConnection.getInstance(); // singleton���� DB�� ü����
		try {
			// 1. ����̹� �ε�
			// 2. ���ؼ� ���
			con = dc.getConn();
			// 3. �������� �־� ������ ��ü ���
			String deleteCpEmp1 = "delete from cp_emp1 where empno=?";
			pstmt = con.prepareStatement(deleteCpEmp1);
			// 1. ���ε庯���� �� �Ҵ�
			pstmt.setInt(1, empno);
			// 5. ���� ���� �� ��� ���
			cnt = pstmt.executeUpdate();
		} finally {
			// 6. ���� ����
			dc.close(null, pstmt, con);
		}

		return cnt;

	} // deleteCpEmp1

	public CpEmp1VO selectOneCpEmp1(int empno) throws SQLException {

		CpEmp1VO ceVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dc = DbConnection.getInstance();

		try {
			// 1. ����̹��ε�
			// 2. Ŀ�ؼ� ���
			con = dc.getConn();
			// 3. ������ ���� ��ü ���
			StringBuilder selectCpEmp1 = new StringBuilder();
			selectCpEmp1.append("	select	ename, sal, comm, job").append("	from	cp_emp1  ")
					.append("	where	empno = ?");

			pstmt = con.prepareStatement(selectCpEmp1.toString());
			// 1. ���ε� ���� �� �Ҵ�
			pstmt.setInt(1, empno);
			// 5. ���� ���� �� ��� ���
			rs = pstmt.executeQuery();

			if (rs.next()) { // ��ȸ�� ���ڵ� ����.
				ceVO = new CpEmp1VO(); // ��ȸ�� �÷� ���� �����ϱ� ���ؼ� VO����
//				ceVO.setEmpno(empno); // �Ű�����(parameter) ���� VO����/
				// �÷���
				ceVO.setEname(rs.getString("ename"));
				ceVO.setSal(rs.getInt("sal"));
				ceVO.setComm(rs.getDouble("comm"));
				ceVO.setJob(rs.getString("job"));
				// �÷��� �ΉH�� ���. ��ȸ���� ù��° �÷����� 1���� �ε����� ������. -> �������� ���� �ʴ�.-> �������� �ʴ´�.
//				ceVO.setEname(rs.getString(1));
//				ceVO.setSal(rs.getInt(2));
//				ceVO.setComm(rs.getDouble(3));
//				ceVO.setJob(rs.getString(1));

			} // end if
		} finally {
			// 6. ���� ����
			dc.close(rs, pstmt, con);
		}

		return ceVO;

	} // selectOneCpEmp1

	public List<CpEmp1VO> selectAllCpEmp1() throws SQLException {
		List<CpEmp1VO> list = new ArrayList<CpEmp1VO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dc = DbConnection.getInstance();

		try {
			// 1. ����̹� �ε�
			// 2. ���ؼ� ���
			con = dc.getConn();
			// 3. ������ ���� ��ü ���
			String selectCpEmp1 = "select empno, ename, job, hiredate, sal, comm from cp_emp1";
			pstmt = con.prepareStatement(selectCpEmp1);
			// 1. ���� ���� �� ��� ���
			rs = pstmt.executeQuery();

			CpEmp1VO ceVO = null;
			while (rs.next()) { // ��ȸ�� ���ڵ尡 �����ϸ�
				// �÷��� ���� �ϳ��� VO�� ����
				ceVO = new CpEmp1VO();
				ceVO.setEmpno(rs.getInt("empno"));
				ceVO.setEname(rs.getString("ename"));
				ceVO.setJob(rs.getString("job"));
				ceVO.setHiredate(rs.getDate("hiredate"));
				ceVO.setSal(rs.getInt("sal"));
				ceVO.setComm(rs.getDouble("comm"));

				// ���� �̸��� VO�� ������ �����ϱ� ���� List�� �߰�(ceVO��ü�� ���� ���������ڵ常 �����Ѵ�.)
				list.add(ceVO); // ���� ��ȸ�� ���ڵ��� ���� ����� �� �ֵ��� list�� �߰�
			} // end while

		} finally {
			// 5. ���� ����
			dc.close(rs, pstmt, con);
		} // end finally
		return list;
	} // selectAllCpEmp1

} // class

package com.jdbc.kyh.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.kyh.dao.DbConnection;
import com.jdbc.kyh.prepared.vo.ColumnVO;


/**
 * ���Ӱ����� ���̺� ���θ� ��ȸ, �Էµ� ���̺��� �÷� ������ ��ȸ
 * 
 * @author user
 *
 */
public class TableInfoDAO {

	private static TableInfoDAO tDAO;
	
	private TableInfoDAO() {
		
	} // TableInfoDAO
	
	public static TableInfoDAO getInstance() {
		
		if(tDAO == null) {
			tDAO = new TableInfoDAO();
		} // end if
		return tDAO;
	}
	
	public List<String> selectAllTable() throws SQLException {
		
		List<String> listTab = new ArrayList<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConnection dc = DbConnection.getInstance();
		
		try {
		// 1. ����̹��ε�
		// 2. Ŀ�ؼǾ��
			con = dc.getConn();
		// 3. ������������ü ���
			String selectTabl = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'jdbc'";
			pstmt = con.prepareStatement(selectTabl);
		// 4. ���ε庯�� �� ����
		// 5. ���� ���� �� ��� ���
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // ����� �ִ���
				
				listTab.add(rs.getString("table_name"));
				
			} // end while
			
		} finally {
			// 6. ���� ����
			dc.close(rs, pstmt, con);
		} // end finally
		return listTab;
		
	} // selectAllTable
	
	public List<ColumnVO> selectTableColumn(String tname) throws SQLException {
		
		List<ColumnVO> list = new ArrayList<ColumnVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConnection dc = DbConnection.getInstance();
		try {
		// 1. ����̹� �ε�
		// 2. Ŀ�ؼ� ���
			con = dc.getConn();
		// 3. �������� ��ü ���
			StringBuilder selectColumn = new StringBuilder();
			selectColumn
			.append("	select column_name, column_type											 ")
			.append("	from information_schema.columns													     ")
			.append("	where table_schema='jdbc' and table_name = ?;										 ");
			
			pstmt = con.prepareStatement(selectColumn.toString());
			// 4. ���ε� ���� �� ����
			pstmt.setString(1, tname);
		// 5. ���� ������ ��� ���
			rs = pstmt.executeQuery();
			
			// ��ȸ�� ���ڵ带 VO�� ���� ( �÷���� VO�ν��Ͻ��������� �޶� ��)
			
			ColumnVO cVO = null;
			
			while(rs.next()) {
				
				cVO = new ColumnVO();
				cVO.setColumnName(rs.getString("column_name"));
				cVO.setColumnType(rs.getString("column_type"));
				
				list.add(cVO);
				
			} // end while
			
		} finally {
			// 6. ���� ����
			dc.close(rs, pstmt, con);
		}
		return list;
	} // end finally
	
}
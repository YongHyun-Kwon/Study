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
 * 접속계정의 테이블 정로를 조회, 입력된 테이블의 컬럼 정보를 조회
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
		// 1. 드라이버로딩
		// 2. 커넥션얻기
			con = dc.getConn();
		// 3. 쿼리문생성객체 얻기
			String selectTabl = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'jdbc'";
			pstmt = con.prepareStatement(selectTabl);
		// 4. 바인드변수 값 설정
		// 5. 쿼리 수행 후 결과 얻기
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 결과가 있는지
				
				listTab.add(rs.getString("table_name"));
				
			} // end while
			
		} finally {
			// 6. 연결 끊기
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
		// 1. 드라이버 로딩
		// 2. 커넥션 얻기
			con = dc.getConn();
		// 3. 쿼리생성 객체 얻기
			StringBuilder selectColumn = new StringBuilder();
			selectColumn
			.append("	select column_name, column_type											 ")
			.append("	from information_schema.columns													     ")
			.append("	where table_schema='jdbc' and table_name = ?;										 ");
			
			pstmt = con.prepareStatement(selectColumn.toString());
			// 4. 바인드 변수 값 설정
			pstmt.setString(1, tname);
		// 5. 쿼리 수행후 결과 얻기
			rs = pstmt.executeQuery();
			
			// 조회된 레코드를 VO에 저장 ( 컬럼명과 VO인스턴스변수명은 달라도 됨)
			
			ColumnVO cVO = null;
			
			while(rs.next()) {
				
				cVO = new ColumnVO();
				cVO.setColumnName(rs.getString("column_name"));
				cVO.setColumnType(rs.getString("column_type"));
				
				list.add(cVO);
				
			} // end while
			
		} finally {
			// 6. 연결 끊기
			dc.close(rs, pstmt, con);
		}
		return list;
	} // end finally
	
}
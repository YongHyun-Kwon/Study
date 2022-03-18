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
	 * 사원번호는 시퀀스를 이용한다.
	 * 
	 * @param ceVO
	 * @throws SQLException
	 */
	public void insertCpEmp1(CpEmp1VO ceVO) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		DbConnection dc = DbConnection.getInstance();
		try {
			// 1. 드라이버 로딩
			// 2. 커넥션 얻기
			conn = dc.getConn();
			// 3. 쿼리문을 넣어 쿼리문생성객체 얻기
			String insertCpEmp = "insert into cp_emp1(empno, ename, job, sal, comm) "
					+ "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertCpEmp);
			// 1. 바인드 변수에 값 설정
			pstmt.setInt(1, ceVO.getEmpno()); // 처음 바인드 변수에 정수로 사원 번호를 넣는다.
			pstmt.setString(2, ceVO.getEname()); // 두번째 바인드 변수에 문자열로 사원이름을 넣는다.
			pstmt.setString(3, ceVO.getJob()); // 세번째 바인드 변수에 문자열로 직무를 넣는다.
			pstmt.setInt(4, ceVO.getSal()); // 네번째 바인드 변수에 정수로 연봉을 넣는다.
			pstmt.setDouble(5, ceVO.getComm()); // 다섯번째 바인드 변수에 실수로 보너스를 넣는다.

			// 5. 쿼리수행 후 결과 얻기
			pstmt.executeUpdate();
		} finally {
			// 6. 연결끊기
			dc.close(null, pstmt, conn);
		} // end finally

	} // insertCpEmp1

	/**
	 * 사원번호에 해당하는 사원의 직무, 연봉, 보너스를 변경
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
			// 1. 드라이버로딩
			// 2. 커넥션 얻기
			con = dc.getConn();
			// 3. 쿼리문을 넣어 쿼리문 실행객체 얻기
			StringBuilder updateCpEmp1 = new StringBuilder();
			updateCpEmp1.append("	update	cp_emp1				").append("	set	job=?, sal=?, comm=?	") // 바인드변수에는
																											// 문자열 일지라도
																											// '를 사용하지
																											// 않는다.
					.append("	where	empno = ? 			");

			pstmt = con.prepareStatement(updateCpEmp1.toString());
			// 1. 바인드변수에 값 할당
			pstmt.setString(1, ceVO.getJob());
			pstmt.setInt(2, ceVO.getSal());
			pstmt.setDouble(3, ceVO.getComm());
			pstmt.setInt(1, ceVO.getEmpno());

			// 5. 쿼리수행 후 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 6. 연결 끊기
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
	 * 사원번호를 입력받아 입력된 사원번호에 해당하는 모든 사원 삭제.
	 * 
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public int deleteCpEmp1(int empno) throws SQLException {

		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		DbConnection dc = DbConnection.getInstance(); // singleton으로 DB객 체얻음
		try {
			// 1. 드라이버 로딩
			// 2. 컨넥션 얻기
			con = dc.getConn();
			// 3. 쿼리문을 넣어 쿼리문 객체 얻기
			String deleteCpEmp1 = "delete from cp_emp1 where empno=?";
			pstmt = con.prepareStatement(deleteCpEmp1);
			// 1. 바인드변수에 값 할당
			pstmt.setInt(1, empno);
			// 5. 쿼리 수행 후 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 6. 연결 끊기
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
			// 1. 드라이버로딩
			// 2. 커넥션 얻기
			con = dc.getConn();
			// 3. 쿼리문 생성 객체 얻기
			StringBuilder selectCpEmp1 = new StringBuilder();
			selectCpEmp1.append("	select	ename, sal, comm, job").append("	from	cp_emp1  ")
					.append("	where	empno = ?");

			pstmt = con.prepareStatement(selectCpEmp1.toString());
			// 1. 바인드 변수 값 할당
			pstmt.setInt(1, empno);
			// 5. 쿼리 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			if (rs.next()) { // 조회된 레코드 있음.
				ceVO = new CpEmp1VO(); // 조회된 컬럼 값을 저장하기 위해서 VO생성
//				ceVO.setEmpno(empno); // 매개변수(parameter) 값을 VO설정/
				// 컬럼명
				ceVO.setEname(rs.getString("ename"));
				ceVO.setSal(rs.getInt("sal"));
				ceVO.setComm(rs.getDouble("comm"));
				ceVO.setJob(rs.getString("job"));
				// 컬럼의 인덳를 사용. 조회퀄의 첫번째 컬럼부터 1번의 인덱스를 가진다. -> 가독성이 좋지 않다.-> 권장하지 않는다.
//				ceVO.setEname(rs.getString(1));
//				ceVO.setSal(rs.getInt(2));
//				ceVO.setComm(rs.getDouble(3));
//				ceVO.setJob(rs.getString(1));

			} // end if
		} finally {
			// 6. 연결 끊기
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
			// 1. 드라이버 로딩
			// 2. 컨넥션 얻기
			con = dc.getConn();
			// 3. 쿼리문 생성 객체 얻기
			String selectCpEmp1 = "select empno, ename, job, hiredate, sal, comm from cp_emp1";
			pstmt = con.prepareStatement(selectCpEmp1);
			// 1. 쿼리 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			CpEmp1VO ceVO = null;
			while (rs.next()) { // 조회된 레코드가 존재하면
				// 컬럼의 값을 하나의 VO에 저장
				ceVO = new CpEmp1VO();
				ceVO.setEmpno(rs.getInt("empno"));
				ceVO.setEname(rs.getString("ename"));
				ceVO.setJob(rs.getString("job"));
				ceVO.setHiredate(rs.getDate("hiredate"));
				ceVO.setSal(rs.getInt("sal"));
				ceVO.setComm(rs.getDouble("comm"));

				// 같은 이름의 VO를 여러개 관리하기 위해 List에 추가(ceVO객체는 가장 마지막레코드만 저장한다.)
				list.add(ceVO); // 이전 조회된 레코드의 값을 사용할 수 있도록 list에 추가
			} // end while

		} finally {
			// 5. 연결 끊기
			dc.close(rs, pstmt, con);
		} // end finally
		return list;
	} // selectAllCpEmp1

} // class

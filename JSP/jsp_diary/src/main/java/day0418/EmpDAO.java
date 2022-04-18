package day0418;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	public List<EmpVO> selectAllEmp() throws SQLException {

		Connection con = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			String query = "select empno, ename, job, sal, hiredate from emp order by hiredate";
			pstmt = con.prepareStatement(query);

			rs = pstmt.executeQuery();

			EmpVO eVO = null;

			while (rs.next()) {
				eVO = new EmpVO();

				eVO.setEmpno(rs.getInt("empno"));
				eVO.setEname(rs.getString("ename"));
				eVO.setJob(rs.getString("job"));
				eVO.setSal(rs.getInt("sal"));
				eVO.setHiredate(rs.getDate("hiredate"));

				list.add(eVO);
			}
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		return list;
	}

}
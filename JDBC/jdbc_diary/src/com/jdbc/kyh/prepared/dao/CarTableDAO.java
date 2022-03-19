package com.jdbc.kyh.prepared.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.kyh.dao.DbConnection;
import com.jdbc.kyh.prepared.vo.SelectCarInfoVO;
import com.jdbc.kyh.prepared.vo.SelectCarModelVO;

/**
 * DAO(Data Access Object) : DB�۾� ���� method ���� ����ϴ� �������� �־ �����Ѵ�.
 * 
 * @author user
 */
public class CarTableDAO {

	public CarTableDAO() {
	}

	/**
	 * DBMS�� ������ ��ü�� ��ȯ�ϴ� ��.
	 * 
	 * @return Connection
	 * @throws SQLException
	 */

	public List<SelectCarModelVO> selectCarList() throws SQLException {
		List<SelectCarModelVO> list = new ArrayList<SelectCarModelVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		DbConnection dc = DbConnection.getInstance();

		try {
			// 1.
			// 2.
			con = dc.getConn();
			// 3.
			stmt = con.createStatement();
			// 4.
			StringBuilder selectCarModel = new StringBuilder();

			selectCarModel.append("	select	model").append("	from car_maker	");

			rs = stmt.executeQuery(selectCarModel.toString());

			SelectCarModelVO scmVO = null;
			while (rs.next()) { // ���ڵ尡 �����ϸ�
				// �÷����� �ϳ��� VO�� �ִ´�.
				scmVO = new SelectCarModelVO();
				scmVO.setModel(rs.getString("model"));

				list.add(scmVO);
			} // end while

		} finally {
			// 5. �������
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return list;

	} // selectCarList

	public List<SelectCarInfoVO> selectCarInfo(String model) throws SQLException {

		List<SelectCarInfoVO> list = new ArrayList<SelectCarInfoVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		DbConnection dc = DbConnection.getInstance();
		try {
			// 1.
			// 2.
			con = dc.getConn();
			// 3.
			stmt = con.createStatement();
			// 4.
			StringBuilder selectCarInfo = new StringBuilder();

			selectCarInfo.append("	select	car_year, price, cc, car_option").append("	from jdbc.car_model	")
					.append("   where  model=").append(model);

			rs = stmt.executeQuery(selectCarInfo.toString());

			SelectCarInfoVO sciVO = null;
			while (rs.next()) { // ���ڵ尡 �����ϸ�
				// �÷����� �ϳ��� VO�� �ִ´�.
				sciVO = new SelectCarInfoVO();
				sciVO.setCar_year(rs.getString("car_year"));// number -> int
				sciVO.setPrice(rs.getInt("price"));
				sciVO.setCc(rs.getInt("cc"));
				sciVO.setOption(rs.getString("car_option"));
				// ���ڵ� �ϳ��� ���� VO�� List�� �߰�
				list.add(sciVO);

			} // end while

		} finally {
			// 5. �������
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return list;
	} // selectCarInfo

} // class
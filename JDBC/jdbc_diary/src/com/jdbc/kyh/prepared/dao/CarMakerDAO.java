package com.jdbc.kyh.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.kyh.dao.DbConnection;
import com.jdbc.kyh.prepared.vo.SelectCarMakerInfoVO;


public class CarMakerDAO {

	private static CarMakerDAO cmDAO;

	public static CarMakerDAO getInstance() {

		if (cmDAO == null) {
			cmDAO = new CarMakerDAO();
		}

		return cmDAO;
	}

	public List<SelectCarMakerInfoVO> selectCarMakerInfo(String maker) throws SQLException {

		List<SelectCarMakerInfoVO> list = new ArrayList<SelectCarMakerInfoVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dc = DbConnection.getInstance();
		try {
			// 1.
			// 2.
			con = dc.getConn();
			// 3.
			// 4.
			StringBuilder selectCarMakerInfo = new StringBuilder();

			selectCarMakerInfo
					.append("	select cc.country, cc.maker, cma.model, cmo.car_year, cmo.price, coalesce(cmo.car_option,'옵션없음') car_option	")
					.append("	from jdbc.car_country cc														")
					.append("	inner join jdbc.car_maker cma														")
					.append("	on cma.maker = cc.maker															")
					.append("	inner join jdbc.car_model cmo														")
					.append("	on cmo.model = cma.model														")
					.append("	where cma.maker = ?");

			pstmt = con.prepareStatement(selectCarMakerInfo.toString());

			pstmt.setString(1, maker);
			
			rs = pstmt.executeQuery();


			SelectCarMakerInfoVO wscmiVO = null;
			while (rs.next()) { // 레코드가 존재하면
				// 컬럼값을 하나의 VO에 넣는다.
				wscmiVO = new SelectCarMakerInfoVO();
				wscmiVO.setCarCountry(rs.getString("country"));
				wscmiVO.setCarMaker(rs.getString("maker"));
				wscmiVO.setCarModel(rs.getString("model"));
				wscmiVO.setCarYear(rs.getString("car_year"));
				wscmiVO.setPrice(rs.getInt("price"));
				wscmiVO.setCarOption(rs.getString("car_option"));

				list.add(wscmiVO);

			} // end while

		} finally {
			dc.close(rs, pstmt, con);
		} // end finally
		return list;
	} // selectCarInfo
	

}
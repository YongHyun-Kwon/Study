package kr.co.kyhstudy.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.kyhstudy.dao.DIDAO;

/**
 * DAO를 의존성 주입 받아 사용하는 클래스
 * @author user
 */
public class DiService {

	private DIDAO dao;
	
	public DiService(DIDAO dao) {
		this.dao = dao;
	}// DiService
	
	public List<String> searchData() {
		List<String> list = null;
		
		try {
			
			list = dao.getList();
		} catch( SQLException e) {
			e.printStackTrace();
		}// end catch
		
		return list;
	}
	
}

package kr.co.kyhstudy.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.kyhstudy.dao.DIDAO;

/**
 * DAO�� ������ ���� �޾� ����ϴ� Ŭ����
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

package kr.co.kyhstudy.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.dao.DIDAO;
import kr.co.kyhstudy.dao.DIDAO2;

/**
 * DAO를 의존성 주입 받아 사용하는 클래스
 * @author user
 */
@Component("ds2")
public class DiService2 {
	@Autowired(required = false)
	private DIDAO2 dao;
	
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

package day0517.service;

import java.sql.SQLException;
import java.util.List;

import day0517.dao.DAO;

public class ServiceImpl implements Service {

	private DAO dao;
	
	/**
	 * 의존성 주입을 받는 생성자
	 */
	public ServiceImpl(DAO dao) {
		
		this.dao = dao;
		
	}// ServiceImpl
	
	@Override
	public void addMember(String name) {
		
		try {
			dao.insert(name);
			System.out.println("DB table에 추가 성공");
		} catch (SQLException e) {
			System.out.println("DB table에 추가 실패");
			e.printStackTrace();
		}// end catch
		
	}// addMember

	@Override
	public List<String> searchMember() {
		
		List<String> list = null;
		
		try {
			list = dao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}// end catch
		
		return list;
		
	}// searchMember

}// class

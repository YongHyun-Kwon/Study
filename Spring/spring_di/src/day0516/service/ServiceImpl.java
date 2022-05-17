package day0516.service;

import java.sql.SQLException;
import java.util.List;

import day0516.dao.DAO;

public class ServiceImpl implements Service {

	private DAO dao;
	
	/**
	 * ������ ������ �޴� ������
	 */
	public ServiceImpl(DAO dao) {
		
		this.dao = dao;
		
	}// ServiceImpl
	
	@Override
	public void addMember(String name) {
		
		try {
			dao.insert(name);
			System.out.println("DB table�� �߰� ����");
		} catch (SQLException e) {
			System.out.println("DB table�� �߰� ����");
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

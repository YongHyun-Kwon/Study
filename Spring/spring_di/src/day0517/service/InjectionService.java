package day0517.service;

import day0517.dao.DAO;

/**
 * �پ��� ������ ���� ����
 * @author user
 */
public class InjectionService {
	
	private DAO dao;
	
	public InjectionService() {
		
		System.out.println("InjectionService �⺻ ������.");
		
	}// InjectionService
	
	/**
	 * ������ ������ ����
	 * @param dao
	 */
	public InjectionService(DAO dao) {
		
		this.dao = dao;
		System.out.println("������ ������ ����");
		
	}// InjectionService
	
	/**
	 * method������ ������ �⺻�����ڸ� �����ϴ� ��� ���.
	 * @param dao
	 */
	public void setDao(DAO dao) {
		
		this.dao = dao;
		System.out.println("method(property)������ ����");
	
	}// setDao
	
	public DAO getDao() {
		
		return dao;
	
	}// getDao
	
}// class

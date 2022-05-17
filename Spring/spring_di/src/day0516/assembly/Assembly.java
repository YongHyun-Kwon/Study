package day0516.assembly;

import day0516.dao.DAO;
//import day0516.dao.MysqlDAO;
import day0516.dao.OracleDAO;
import day0516.service.Service;
import day0516.service.ServiceImpl;

/**
 * Service�� DAO�� ���踦 �����ϴ� ��
 * Service�� DAO�� �������� �ִ�.
 * @author user
 */
public class Assembly {

	public Service getBean() {

		// 1. ������ ������ Ŭ������ ����
		DAO dao = new OracleDAO();
		//DAO dao = new MysqlDAO();
		// 2. ������ ���Թ��� Ŭ������ �����ϰ�, ������ ���� ����.
		Service service = new ServiceImpl(dao);
		// 3. ������ ���� ���� Ŭ������ ��ȯ
		return service;

	}// getBean

}// class

package day0517.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day0517.dao.DAO;
import day0517.dao.MysqlDAO;
import day0517.dao.OracleDAO;
import day0517.service.Service;
import day0517.service.ServiceImpl;

public class UseSpringContainer {

	public static void main(String[] args) {
		
		// 1. Spring Container ����.( �������Ͽ� �����ϴ� Ŭ������ �����Ѵ�. )
		ApplicationContext ac = new ClassPathXmlApplicationContext("day0517/run/applicationContext.xml");
//		System.out.println(ac);
		// 2. bean ���
		// ������ ������ ��ü ��� - ( ���� �ʿ�� ���� )
		DAO dao = (DAO)ac.getBean(MysqlDAO.class);// singleton
		OracleDAO od = ac.getBean(OracleDAO.class);// prototype -getBean���� ���� �� ���� ����

		DAO dao1 = (DAO)ac.getBean(MysqlDAO.class);
		OracleDAO od1 = ac.getBean(OracleDAO.class);
		
		System.out.println("dao ��ü �ּ� : " + dao);
		System.out.println("dao1 ��ü �ּ� : " + dao1);

		System.out.println("od ��ü �ּ� : " + od);
		System.out.println("od1 ��ü �ּ� : " + od1);
		
		// ������ ���Թ��� ��ü ���
		Service service = ac.getBean(ServiceImpl.class);
		// ���� ó�� method ȣ��
		service.addMember("�ǿ���");
		System.out.println(service.searchMember());
		
		//ApplicationContext�� ����� �������� �޸� ������ �������� �ݴ´�.
		((ClassPathXmlApplicationContext)ac).close();
		
		
	}// main

}// class

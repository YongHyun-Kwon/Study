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
		
		// 1. Spring Container 생성.( 설정파일에 존재하는 클래스를 생성한다. )
		ApplicationContext ac = new ClassPathXmlApplicationContext("day0517/run/applicationContext.xml");
//		System.out.println(ac);
		// 2. bean 얻기
		// 의존성 주입할 객체 얻기 - ( 얻을 필요는 없음 )
		DAO dao = (DAO)ac.getBean(MysqlDAO.class);// singleton
		OracleDAO od = ac.getBean(OracleDAO.class);// prototype -getBean으로 얻을 떄 마다 생성

		DAO dao1 = (DAO)ac.getBean(MysqlDAO.class);
		OracleDAO od1 = ac.getBean(OracleDAO.class);
		
		System.out.println("dao 객체 주소 : " + dao);
		System.out.println("dao1 객체 주소 : " + dao1);

		System.out.println("od 객체 주소 : " + od);
		System.out.println("od1 객체 주소 : " + od1);
		
		// 의존성 주입받은 객체 얻기
		Service service = ac.getBean(ServiceImpl.class);
		// 업무 처리 method 호출
		service.addMember("권용현");
		System.out.println(service.searchMember());
		
		//ApplicationContext의 사용이 끝났으면 메모리 누수를 막기위해 닫는다.
		((ClassPathXmlApplicationContext)ac).close();
		
		
	}// main

}// class

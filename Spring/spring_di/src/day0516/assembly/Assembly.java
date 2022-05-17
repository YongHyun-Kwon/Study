package day0516.assembly;

import day0516.dao.DAO;
//import day0516.dao.MysqlDAO;
import day0516.dao.OracleDAO;
import day0516.service.Service;
import day0516.service.ServiceImpl;

/**
 * Service와 DAO의 관계를 설정하는 일
 * Service는 DAO에 의존성이 있다.
 * @author user
 */
public class Assembly {

	public Service getBean() {

		// 1. 의존성 주입할 클래스를 생성
		DAO dao = new OracleDAO();
		//DAO dao = new MysqlDAO();
		// 2. 의존성 주입받을 클래스를 생성하고, 의존성 주입 수행.
		Service service = new ServiceImpl(dao);
		// 3. 의존성 주입 받은 클래스를 반환
		return service;

	}// getBean

}// class

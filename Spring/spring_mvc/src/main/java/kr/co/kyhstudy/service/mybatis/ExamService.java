package kr.co.kyhstudy.service.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.dao.mybatis.ExamDAO;

@Component
public class ExamService {

	@Autowired(required = false)
	private ExamDAO eDAO;

	public String scsr(int deptno) {

		String dname = "";

		try {
			
			dname = eDAO.scsr(deptno);
			
		} catch (PersistenceException pe) {
			
			pe.printStackTrace();
			
		} // end catch

		return dname;

	}// scsr

}

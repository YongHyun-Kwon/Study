package kr.co.kyhstudy.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.dao.mybatis.ExamDAO0526;
import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.domain.mybatis.JoinDomain;
import kr.co.kyhstudy.domain.mybatis.ModelDomain;
import kr.co.kyhstudy.vo.BoardVO;

@Component
public class ExamService0526 {

	@Autowired(required = false)
	private ExamDAO0526 eDAO; // Servuce에서 DAO를 의존성 주입받는다.

	public List<String> searchCountry() {
		
		List<String> list = null;
		
		try {
			list = eDAO.selectCountry();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;
		
	}// subquery

	public List<JoinDomain> join(String country) {
		
		List<JoinDomain> list = null;
		
		try {
			list = eDAO.join(country);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;
		
	}// join
	
	public List<JoinDomain> subqueryJoin(String country) {
		
		List<JoinDomain> list = null;
		
		try {
			list = eDAO.subqueryJoin(country);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;
		
	}// join

	public List<EmpDomain> dynamicTable(String tabName) {
		
		List<EmpDomain> list = null;
		
		try {
			list = eDAO.dynamicTab(tabName);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;
		
	}// dynamicTable
	
	public List<EmpDomain> dynamicIf(String job) {
		
		List<EmpDomain> list = null;
		
		try {
			list = eDAO.dynamicIf(job);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;
		
	}// dynamicIf
	
	public String[] jobList() {
		
		String[] job = {"SALESMAN", "MANAGER", "ANALYST", "PRESIDENT", "CLERK" };
		
		return job;
		
	}// jobList

}// class

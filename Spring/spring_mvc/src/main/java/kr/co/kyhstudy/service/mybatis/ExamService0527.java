package kr.co.kyhstudy.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.dao.mybatis.ExamDAO0527;
import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.vo.DynamicVO;
import kr.co.kyhstudy.vo.EmpVO;

@Component
public class ExamService0527 {

	@Autowired(required = false)
	private ExamDAO0527 eDAO; // Servuce에서 DAO를 의존성 주입받는다.

	public List<EmpDomain> dynamicChoose(DynamicVO dVO) {

		List<EmpDomain> list = null;

		try {
			list = eDAO.dynamicChoose(dVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;

	}// dynamicIf
	
	public List<EmpDomain> dynamicTrim(DynamicVO dVO) {
		
		List<EmpDomain> list = null;
		
		try {
			list = eDAO.dynamicTrim(dVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;
		
	}// dynamicTrim

	public boolean dynamicSet(EmpVO eVO){
	      boolean flag = false;
	      try {
	         flag =eDAO.dynamicSet(eVO) == 1; 
	      }catch (PersistenceException e) {
	         e.printStackTrace();
	      }
	      
	      return flag;
	   }

}// class

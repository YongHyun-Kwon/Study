package kr.co.kyhstudy.service.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.dao.mybatis.ExamDAO0530;
import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.vo.DynamicVO;
import kr.co.kyhstudy.vo.EmpVO;
import kr.co.kyhstudy.vo.ForeachVO;
import kr.co.kyhstudy.vo.InsertVO;

@Component
public class ExamService0530 {

	@Autowired(required = false)
	private ExamDAO0530 eDAO; // Servuce에서 DAO를 의존성 주입받는다.

	public List<EmpDomain> searchDynamicForeach(ForeachVO fVO) {

		List<EmpDomain> list = null;

		// MyBatis에서 사용하기 위해 Map에 입력값을 넣ㄴㄴ다.
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("deptno", fVO.getDeptno());
		List<String> listJob = new ArrayList<String>();

		if (fVO.getJob() != null) {
			for (String job : fVO.getJob()) {
				listJob.add(job);
			} // end for
		}
		// map.put("MyBatis에서 사용할 이름", 값);
		map.put("deptno", fVO.getDeptno());
		map.put("listJob", listJob);
		map.put("arrJob", fVO.getJob());

		try {
			list = eDAO.selectForeach(map);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return list;

	}// searchDynamicForeach

	public void addProcedure(InsertVO iVO) {

		try {
			eDAO.insertProcedure(iVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

	}// addProcedure
	
	public void modifyProcedure(InsertVO iVO) {
		
		try {
			eDAO.updateProcedure(iVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		
	}// modifyProcedure
	
	public void removeProcedure(InsertVO iVO) {
		
		try {
			eDAO.deleteProcedure(iVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		
	}// modifyProcedure

}// class

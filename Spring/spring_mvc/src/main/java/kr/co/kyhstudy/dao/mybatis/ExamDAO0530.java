package kr.co.kyhstudy.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.vo.ForeachVO;
import kr.co.kyhstudy.vo.InsertVO;

@Component
public class ExamDAO0530 {

	public List<EmpDomain> selectForeach(Map<String, Object> map) throws PersistenceException {

		List<EmpDomain> list = null;

		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		list = ss.selectList("kr.co.sist.dao.exam6.dynamicForeach", map);

		if (ss != null) {
			ss.close();
		}

		return list;

	}// selectForeach

	public void insertProcedure(InsertVO iVO) throws PersistenceException {

		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		ss.selectOne("kr.co.sist.dao.exam6.insertProc", iVO);

		if (ss != null) {
			ss.close();
		} // end if

	}// insertProcedure

	public void updateProcedure(InsertVO iVO) throws PersistenceException {

		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		ss.selectOne("kr.co.sist.dao.exam6.updateProc", iVO);

		if (ss != null) {
			ss.close();
		} // end if

	}// updateProcedure
	
	public void deleteProcedure(InsertVO iVO) throws PersistenceException {
		
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		ss.selectOne("kr.co.sist.dao.exam6.deleteProc", iVO);
		
		if (ss != null) {
			ss.close();
		} // end if
		
	}// updateProcedure

}// class

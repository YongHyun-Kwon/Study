package kr.co.kyhstudy.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.vo.DynamicVO;
import kr.co.kyhstudy.vo.EmpVO;

@Component
public class ExamDAO0527 {

	public List<EmpDomain> dynamicChoose(DynamicVO dVO) throws PersistenceException {

		List<EmpDomain> list = null;

		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		list = ss.selectList("kr.co.sist.exam5.choose", dVO);

		if (ss != null) {

			ss.close();

		} // end if

		return list;

	}// dynamicChoose

	public List<EmpDomain> dynamicTrim(DynamicVO dVO) throws PersistenceException {

		List<EmpDomain> list = null;

		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		list = ss.selectList("kr.co.sist.exam5.trim", dVO);

		if (ss != null) {

			ss.close();

		} // end if

		return list;

	}// dynamicTrim

	public int dynamicSet(EmpVO eVO) throws PersistenceException {
		int rowCnt = 0;

		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		rowCnt = ss.update("kr.co.sist.exam5.set", eVO);
		
		if (rowCnt == 1)
			ss.commit();
		
		if (ss != null)
			ss.close(); 

		return rowCnt;

	}
}// class

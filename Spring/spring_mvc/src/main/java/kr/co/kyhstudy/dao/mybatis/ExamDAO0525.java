package kr.co.kyhstudy.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.domain.mybatis.ModelDomain;
import kr.co.kyhstudy.vo.BoardVO;

@Component
public class ExamDAO0525 {

	public List<EmpDomain> greaterThan(int sal) throws PersistenceException {

		List<EmpDomain> list = null;

		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("kr.co.sist.exam3.greaterThan", sal);

		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if

		return list;

	}// greaterThan

	public List<ModelDomain> like(String option) throws PersistenceException {

		List<ModelDomain> list = null;

		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("kr.co.sist.exam3.like", option);

		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if

		return list;

	}// like

	public int selectTotalCount(BoardVO bVO) {

		int totalCnt = 0;

		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		// Äõ¸®¹® ½ÇÇà
		totalCnt = ss.selectOne("kr.co.sist.exam3.carCnt", bVO);

		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if

		return totalCnt;

	}// selectTotalCount

	public List<ModelDomain> subquery(BoardVO bVO) throws PersistenceException {

		List<ModelDomain> list = null;

		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("kr.co.sist.exam3.subquery", bVO);

		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if

		return list;

	}// like

	public List<EmpDomain> union() throws PersistenceException {

		List<EmpDomain> list = null;

		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("kr.co.sist.exam3.union");

		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if

		return list;

	}// union

}// subquery

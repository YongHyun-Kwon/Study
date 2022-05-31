package kr.co.kyhstudy.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.domain.mybatis.EmpDomain;

@Component
public class ExamDAO0524 {
	
	public List<String> scmr(int deptno) throws PersistenceException {
		
		List<String> list = null;
		
		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("scmr", deptno);
		
		// MyBatis Handler ´Ý±â
		if( ss != null ) { ss.close(); }// end if
		
		return list;
		
	}// scmr
	
	public EmpDomain mcsr(int empno) throws PersistenceException {
		
		EmpDomain ed = null;
		
		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		// Äõ¸®¹® ½ÇÇà
		ed = ss.selectOne("mcsr", empno);
		
		// Mybatis Handler ´Ý±â
		if( ss != null ) { ss.close(); }// end if
		
		return ed;
		
	}// mcsr
	
	public List<EmpDomain> mcmr(int deptno) throws PersistenceException {
		
		List<EmpDomain> list = null;
		
		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("mcmr", deptno);
		
		// Mybatis Handler ´Ý±â
		if( ss != null ) { ss.close(); }// end if
		
		return list;
		
	}// mcsr
	
	public List<EmpDomain> lessThan(int sal) throws PersistenceException {
		
		List<EmpDomain> list = null;
		
		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("lessThan", sal);
		
		// Mybatis Handler ´Ý±â
		if( ss != null ) { ss.close(); }// end if
		
		return list;
		
	}// mcsr
	
}//class

package kr.co.kyhstudy.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.domain.mybatis.JoinDomain;

@Component
public class ExamDAO0526 {


	public List<JoinDomain> join(String country) throws PersistenceException {

		List<JoinDomain> list = null;

		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("kr.co.sist.exam4.join",country);

		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if

		return list;

	}// join
	
	public List<String> selectCountry() throws PersistenceException {
		
		List<String> list = null;
		
		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("kr.co.sist.exam4.selectCountry");
		
		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if
		
		return list;
		
	}// selectCountry
	
	public List<JoinDomain> subqueryJoin(String country) throws PersistenceException {

		List<JoinDomain> list = null;

		// MyBatis Handler ¾ò±â
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();

		// Äõ¸®¹® ½ÇÇà
		list = ss.selectList("kr.co.sist.exam4.subqueryjoin",country);

		// Mybatis Handler ´Ý±â
		if (ss != null) {
			ss.close();
		} // end if

		return list;

	}// subqueryJoin
	
	public List<EmpDomain> dynamicTab( String tabName ) throws PersistenceException {
		
		List<EmpDomain> list = null;
		
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		list = ss.selectList("kr.co.sist.exam4.dynamicTab", tabName);
		
		if( ss!= null ) {
			
			ss.close();
			
		}
		
		return list;
		
	}// dynamicTab
	
	public List<EmpDomain> dynamicIf(String job) throws PersistenceException {
		
		List<EmpDomain> list = null;
		
		SqlSession ss = MyBatisFramework.getInstance().getMyBatisHandler();
		
		list = ss.selectList("kr.co.sist.exam4.dynamicIf", job);
		
		if( ss!= null ) {
			
			ss.close();
			
		}
		
		return list;
		
	}// dynamicTab
	
}

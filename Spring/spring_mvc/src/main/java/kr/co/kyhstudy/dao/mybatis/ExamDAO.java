package kr.co.kyhstudy.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class ExamDAO {

	/**
	 * �÷��ϳ��� �� �ϳ� ��ȸ
	 * @param deptno �μ����� ��ȸ�� �μ� ��ȣ
	 * @return ��ȸ�� �μ���
	 * @throws PersistenceException
	 */
	public String scsr(int deptno) throws PersistenceException {
		
		String dname = "";
		
		SqlSession ss = MyBatisFramwork.getInstance().getMyBatisHandler();
		
		dname = ss.selectOne("kr.co.sist.dao.scsr", deptno);
		
		return dname;
		
	}// scsr
	
}// class

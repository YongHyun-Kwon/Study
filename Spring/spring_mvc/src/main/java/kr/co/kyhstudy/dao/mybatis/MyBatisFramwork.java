package kr.co.kyhstudy.dao.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Framwork�� �����ϰ� MyBatis Handler�� ��ȯ
 * @author user
 */
public class MyBatisFramwork {
	
	private static MyBatisFramwork mbf;
	private static SqlSessionFactory ssf;
	
	private MyBatisFramwork() {
		
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		
	}// MyBatisFramwork
	
	public static MyBatisFramwork getInstance() {
		
		if(mbf == null) {
			
			mbf = new MyBatisFramwork();
			
		}// end if 
		
		return mbf;
		
	}// getInstance

	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		
		if (ssf == null) {

			Reader reader = null;

			try {
				
				// 1. ��Ʈ���� ����ؼ� �������� ����.
				reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis/SqlMapConfig.xml");
				
				// 2. ��Ʈ���� �Է��Ͽ� MyBatis Framework ����
				ssf = new SqlSessionFactoryBuilder().build(reader);

			} finally {
				
				if (reader != null) {
					
					reader.close();
					
				}// end if
				
			}// end finally

		} // end if
		
		return ssf;
		
	}// getSqlSessionFactory
	
	/**
	 * Handler ���
	 * 
	 * @return
	 */
	public SqlSession getMyBatisHandler() {

		SqlSession ss = null;

		try {
			
			ss = getSqlSessionFactory().openSession();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} // end catch

		return ss;

	}// getMyBatisHandler

}// class

package kr.co.kyh.dao.exam;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.kyh.dao.sub.UseMyBatis;
import kr.co.kyh.domain.CpEmp4Domain;
import kr.co.kyh.domain.MyTabDomain;
import kr.co.kyh.vo.MyTabVO;


/**
 * MyBatis Handler�� ����Ͽ� DB�۾� ����.
 * 
 * @author user
 */
public class MyTabDAO {

	public int inserMyTab(MyTabVO mtVO) throws PersistenceException {
		int cnt = 0;

		// MyBatis Handler ���
		UseMyBatis umb = UseMyBatis.getInstance();
		SqlSession ss = umb.getSqlSession();

		// Mapper���� XML�� Parsing�Ͽ� �������� ������ ����� ��´�.
		cnt = ss.insert("insertMyTab", mtVO);
		// �������� ������ �� ���� 1�̶��
		if (cnt == 1) { // transaction�� �Ϸ�

			ss.commit();

		} // end if

		// MyBatis Handler �ݱ�
		ss.close();

		return cnt;
	}// inserMyTab

	public int updateMyTab(MyTabVO mtVO) throws PersistenceException {

		int cnt = 0;

		// MyBatis Handler ����
		SqlSession ss = null;
		try {
			ss = UseMyBatis.getInstance().getSqlSession();
			cnt = ss.update("kr.co.sist.dao.examMapper.updateMyTab", mtVO);
			if (cnt == 1) {
				ss.commit();
			}
		} finally {
			// MyBatis Handler �ݱ�
			if (ss != null) {
				ss.close();
			}
		} // end finally
		return cnt;

	}// updateMyTab

	public int deleteMyTab(String id) throws PersistenceException {

		int cnt = 0;

		// MyBatis Handler ���
		SqlSession ss = null;

		try {
			// XML�� parsing�Ͽ� �������� ���� �ϰ� ��� �ޱ�
			ss = UseMyBatis.getInstance().getSqlSession();
			cnt = ss.delete("kr.co.sist.dao.examMapper.deleteMyTab", id);

			if (cnt == 1) {
				ss.commit();
			} // end if

			// MyBatis Handler �ݱ�
		} finally {
			if (ss != null) {
				ss.close();
			}
		} // emd finally
		return cnt;

	}// deleteMyTab

	public MyTabDomain selectOneMyTab(MyTabVO mtVO) throws PersistenceException {

		MyTabDomain mtd = null;
		// MyBatis Handler ���
		SqlSession ss = UseMyBatis.getInstance().getSqlSession();
		// ������ ã�� ����.

		mtd = ss.selectOne("kr.co.sist.dao.examMapper.selectMyTab", mtVO);
		// ���� ����
		if (ss != null) {
			ss.close();
		} // end if

		return mtd;

	}// selectOneMyTab

	public List<CpEmp4Domain> selectCpEmp4(String job) throws PersistenceException {

		List<CpEmp4Domain> list = null;

		// MyBatis Handler ���
		SqlSession ss = UseMyBatis.getInstance().getSqlSession();
		
		// ������ ����
		list = ss.selectList("kr.co.sist.dao.examMapper.selectCpEmp4", job);
	
		// �ݱ�
		if( ss != null ) {
			ss.close();
		}
		
		return list;
	}// selectCpEmp4

}

package kr.co.kyhstudy.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.kyhstudy.dao.mybatis.ExamDAO0525;
import kr.co.kyhstudy.domain.mybatis.EmpDomain;
import kr.co.kyhstudy.domain.mybatis.ModelDomain;
import kr.co.kyhstudy.vo.BoardVO;

@Component
public class ExamService0525 {

	@Autowired(required = false)
	private ExamDAO0525 eDAO; // Servuce���� DAO�� ������ ���Թ޴´�.

	public List<EmpDomain> lessThan(int sal) {

		List<EmpDomain> list = null;

		try {
			list = eDAO.greaterThan(sal);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;

	}// lessThan

	public List<ModelDomain> like(String option) {

		List<ModelDomain> list = null;

		try {
			list = eDAO.like(option);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;

	}// like

	public int searchTotalCount(BoardVO bVO) {

		int cnt = 0;

		try {
			setKeyword(bVO);
			cnt = eDAO.selectTotalCount(bVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return cnt;

	}// searchTotalCount

	/**
	 * ��ȭ�鿡 ������ �������� ��
	 * 
	 * @return
	 */
	public int pageScale() {

		int pageScale = 10;

		return pageScale;

	}// pageScale

	/**
	 * ��� �Խù��� �����ֱ� ���� ������ ��( �� ������ �� )
	 * 
	 * @param totalCnt
	 * @param pageScale
	 * @return
	 */
	public int pageCnt(int totalCnt, int pageScale) {

		int pageCnt = 0;

		pageCnt = (int) Math.ceil((double) totalCnt / pageScale);

//		pageCnt = totalCnt/pageScale;
//		if( totalCnt % pageScale != 0) {
//			pageCnt++;
//		}// end if

		return pageCnt;

	}

	/**
	 * ���۹�ȣ ���ϱ�
	 * 
	 * @param currentPage - ���� ������ ��ȣ
	 * @param pageScale   - �� ȭ�鿡 ������ ������ ��
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {

		int startNum = 1;

		startNum = currentPage * pageScale - pageScale + 1;

		return startNum;
	}// startNum

	/**
	 * ����ȣ ���ϱ�
	 * 
	 * @param startNum
	 * @param pageScale
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum = 0;
		endNum = startNum + pageScale - 1;
		return endNum;
	}// endNum

	public void setKeyword(BoardVO bVO) {

		// �˻� Ű����� field�� ���� ����
		if (!"".equals(bVO.getKeyword())) {

			String field = "car_option";

			if ("1".equals(bVO.getField()) || "model".equals(bVO.getField())) {

				field = "model";

			} // end if
			bVO.setField(field);

		} // end if

	}// setKeyword

	public List<ModelDomain> subquery(BoardVO bVO) {

		List<ModelDomain> list = null;

		try {
			setKeyword(bVO);
			list = eDAO.subquery(bVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;

	}// subquery

	public List<EmpDomain> union() {

		List<EmpDomain> list = null;

		try {
			list = eDAO.union();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch
		return list;

	}// subquery

}// class

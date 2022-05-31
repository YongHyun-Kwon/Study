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
	private ExamDAO0525 eDAO; // Servuce에서 DAO를 의존성 주입받는다.

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
	 * 한화면에 보여줄 페이지의 수
	 * 
	 * @return
	 */
	public int pageScale() {

		int pageScale = 10;

		return pageScale;

	}// pageScale

	/**
	 * 모든 게시물을 보여주기 위한 페이지 수( 총 페이지 수 )
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
	 * 시작번호 구하기
	 * 
	 * @param currentPage - 현재 페이지 번호
	 * @param pageScale   - 한 화면에 보여줄 페이지 수
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {

		int startNum = 1;

		startNum = currentPage * pageScale - pageScale + 1;

		return startNum;
	}// startNum

	/**
	 * 끝번호 구하기
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

		// 검색 키워드와 field에 대한 설정
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

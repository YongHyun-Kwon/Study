package kr.co.kyh.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.kyh.dao.exam.MyTabDAO;
import kr.co.kyh.domain.CpEmp4Domain;
import kr.co.kyh.domain.MyTabDomain;
import kr.co.kyh.vo.MyTabVO;


public class ExamService {

	public String addMyTab(MyTabVO mtVO) {

		String msg = mtVO.getId() + "추가 실패";

		MyTabDAO mtDAO = new MyTabDAO();
		try {
			int cnt = mtDAO.inserMyTab(mtVO);

			if (cnt == 1) {
				msg = mtVO.getId() + "추가 성공";
			}
		} catch (PersistenceException pe) {
			msg = mtVO.getId() + "추가 실패 - DB문제 발생";
			pe.printStackTrace();
		}

		return msg;

	}// addMyTab

	public String modifyMyTab(MyTabVO mtVO) {

		String msg = "아이디나 이메일을 확인하세요";

		MyTabDAO mtDAO = new MyTabDAO();

		try {
			int cnt = mtDAO.updateMyTab(mtVO);

			if (cnt == 1) {
				msg = mtVO.getId() + "변경되었습니다.";
			}
		} catch (PersistenceException pe) {
			msg = mtVO.getId() + "변경 실패 - DB문제 발생";
			pe.printStackTrace();
		}

		return msg;

	}// modifyMyTab

	public String removeTyTab(String id) {

		String msg = id + "는 존재하지 않습니다.";

		MyTabDAO mtDAO = new MyTabDAO();

		try {
			int cnt = mtDAO.deleteMyTab(id);

			if (cnt == 1) {
				msg = id + "삭제되었습니다.";
			}
		} catch (PersistenceException pe) {
			msg = "삭제 실패 - DB문제 발생";
			pe.printStackTrace();
		}

		return msg;

	}// modifyMyTab

	public MyTabDomain searchOneMyTab(MyTabVO mtVO) {

		MyTabDomain mtd = null;

		MyTabDAO mtDAO = new MyTabDAO();
		try {
			mtd = mtDAO.selectOneMyTab(mtVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return mtd;
	}// searchOneMyTab

	public List<CpEmp4Domain> searchCpEmp4(String job) {

		List<CpEmp4Domain> list = null;

		MyTabDAO mtDAO = new MyTabDAO();
		try {
			list = mtDAO.selectCpEmp4(job);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} // end catch

		return list;
	}// searchCpEmp4

}// ExamService

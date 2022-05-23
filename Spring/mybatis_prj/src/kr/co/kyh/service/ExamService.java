package kr.co.kyh.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.kyh.dao.exam.MyTabDAO;
import kr.co.kyh.domain.CpEmp4Domain;
import kr.co.kyh.domain.MyTabDomain;
import kr.co.kyh.vo.MyTabVO;


public class ExamService {

	public String addMyTab(MyTabVO mtVO) {

		String msg = mtVO.getId() + "�߰� ����";

		MyTabDAO mtDAO = new MyTabDAO();
		try {
			int cnt = mtDAO.inserMyTab(mtVO);

			if (cnt == 1) {
				msg = mtVO.getId() + "�߰� ����";
			}
		} catch (PersistenceException pe) {
			msg = mtVO.getId() + "�߰� ���� - DB���� �߻�";
			pe.printStackTrace();
		}

		return msg;

	}// addMyTab

	public String modifyMyTab(MyTabVO mtVO) {

		String msg = "���̵� �̸����� Ȯ���ϼ���";

		MyTabDAO mtDAO = new MyTabDAO();

		try {
			int cnt = mtDAO.updateMyTab(mtVO);

			if (cnt == 1) {
				msg = mtVO.getId() + "����Ǿ����ϴ�.";
			}
		} catch (PersistenceException pe) {
			msg = mtVO.getId() + "���� ���� - DB���� �߻�";
			pe.printStackTrace();
		}

		return msg;

	}// modifyMyTab

	public String removeTyTab(String id) {

		String msg = id + "�� �������� �ʽ��ϴ�.";

		MyTabDAO mtDAO = new MyTabDAO();

		try {
			int cnt = mtDAO.deleteMyTab(id);

			if (cnt == 1) {
				msg = id + "�����Ǿ����ϴ�.";
			}
		} catch (PersistenceException pe) {
			msg = "���� ���� - DB���� �߻�";
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

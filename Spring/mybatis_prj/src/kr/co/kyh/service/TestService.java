package kr.co.kyh.service;

import java.io.IOException;

import kr.co.kyh.dao.TestDAO;
import kr.co.kyh.vo.CpEmp4VO;


public class TestService {

	public String addEmp(CpEmp4VO ceVO) {
		
		String msg = "추가실패";
		
		TestDAO tDAO = new TestDAO();
		
		try {
			
			int cnt = tDAO.insert(ceVO);
			
			if(cnt == 1) {
				msg = "추가성공";
			}// end if
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}// end catch
		
		return msg;
		
	}// addEmp
	
}// class

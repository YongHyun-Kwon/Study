package kr.co.kyh.run;

import java.util.List;

import kr.co.kyh.domain.CpEmp4Domain;
import kr.co.kyh.service.ExamService;


public class ExamRun {

	public static void main(String[] args) {
		
		ExamService es = new ExamService();
		
//		MyTabVO mtVO = new MyTabVO();
//		
//		mtVO.setId("kim");
//		mtVO.setName("������");
//		mtVO.setAge(20);
//		mtVO.setEmail("kim@test.com");
//		
//		System.out.println(es.addMyTab(mtVO));
//		System.out.println(es.modifyMyTab(mtVO));
//		System.out.println(es.removeTyTab("kim1"));

//      -- ���� ��ȸ		
//		MyTabVO mtVO = new MyTabVO();
//		
//		mtVO.setId("kim");//pk
//		mtVO.setName("������");
//		
//		MyTabDomain mtd = es.searchOneMyTab(mtVO);
//		System.out.println("��ȸ��� : " + mtd);

//      -- ������ ��ȸ
		String job="������";
		List<CpEmp4Domain> list = es.searchCpEmp4(job);
		System.out.println("list");
	}// main

}// class

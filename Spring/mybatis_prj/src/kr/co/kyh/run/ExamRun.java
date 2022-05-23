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
//		mtVO.setName("김진영");
//		mtVO.setAge(20);
//		mtVO.setEmail("kim@test.com");
//		
//		System.out.println(es.addMyTab(mtVO));
//		System.out.println(es.modifyMyTab(mtVO));
//		System.out.println(es.removeTyTab("kim1"));

//      -- 한행 조회		
//		MyTabVO mtVO = new MyTabVO();
//		
//		mtVO.setId("kim");//pk
//		mtVO.setName("김진영");
//		
//		MyTabDomain mtd = es.searchOneMyTab(mtVO);
//		System.out.println("조회결과 : " + mtd);

//      -- 여러행 조회
		String job="개발자";
		List<CpEmp4Domain> list = es.searchCpEmp4(job);
		System.out.println("list");
	}// main

}// class

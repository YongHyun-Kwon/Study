package kr.co.kyhstudy.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.kyhstudy.dao.DIDAO;
import kr.co.kyhstudy.service.DiService;

@Controller
public class DiController {

	@RequestMapping(value="/day0518/di.do", method = RequestMethod.GET)
	public String requestDi(Model model) {
		
		// DAO를 의존성 주입 받는 서비스 사용.
		// 1. Spring Container 생성
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/controller/applicationContext.xml");
		
		// 2. bean얻기
		DiService ds = ac.getBean("ds", DiService.class);
		
		// 3. Srping Container 닫기
		((ClassPathXmlApplicationContext)ac).close();
		
		List<String> list = ds.searchData();
		model.addAttribute("data",list);
		
		return "day0518/di";
		
	}// requestDi
	
}// class

package kr.co.kyhstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.kyhstudy.dao.DIDAO;
import kr.co.kyhstudy.service.DiService;
import kr.co.kyhstudy.service.DiService2;

@Controller
public class DiController2 {
	
	@Autowired(required = false)
	private DiService2 ds2;

	@RequestMapping(value="/day0518/di2.do", method = RequestMethod.GET)
	public String requestDi(Model model) {
		
		// DAO를 의존성 주입 받는 서비스 사용.
		List<String> list = ds2.searchData();
		model.addAttribute("data",list);
		
		return "day0518/di";
		
	}// requestDi
	
}// class

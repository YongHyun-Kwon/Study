package kr.co.kyhstudy.day0510;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {

	@RequestMapping(value="/hello.do",method = RequestMethod.GET)
	public String hello() {
		
		return "hello_spring";
	
	}// hello
}


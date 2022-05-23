package kr.co.kyhstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MoveController {

	@RequestMapping(value = "/day0512/do_move.do", method = GET )
	public String doMove() {
		System.out.println("do�� ���û ������");
		//return "../index.dp"; // ViewResolver�� ���� => WEB-INF/views/../index.do.jsp
		return "redirect:../index.do"; // ViewResolver�� ���� ����
		
	}// doMove
	
	@RequestMapping(value = "/day0512/jsp_move.do", method = GET )
	public String jspMove() {
		System.out.println("jsp�� ���û ������");
		//return "../index.dp"; // ViewResolver�� ���� => WEB-INF/views/../index.do.jsp
		return "redirect:http://localhost/spring_mvc/jsp_result.jsp"; // ViewResolver�� ���� ����
		
	}// doMove

	@RequestMapping(value = "/day0512/forward_a.do", method = GET )
	public String doDirectMove() {
		System.out.println("do�� ���� ��û ������");
		return "forward:forward_b.do"; // ViewResolver�� ���� ����
	}// doDirectMove
	
	@RequestMapping(value = "/day0512/forward_b.do", method = GET )
	public String doDirectMoveB() {
		System.out.println("����");
		return "day0512/forward_b_result"; // ViewResolver�� ����� �̵�
	}// doMove
	
}// class

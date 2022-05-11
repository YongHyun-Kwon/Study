package kr.co.kyhstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


//annotation�� �����Ǿ� �־�� HendlerMapper�� class�� ã�� �� �ִ�. (component-scan)
@Controller
public class MethodController {
	@RequestMapping(value="/get.do",method = GET)
	public String getMethod() {
		// .jsp�� �پ ȣ�����ش�.
		return "get_result";
		
	}// getMethod
	
	@RequestMapping(value="/post.do",method = POST)
	public String postMethod() {
		
		return "post_result";
		
	}// postMethod
	
	@RequestMapping(value="/multi.do",method = { POST, GET })
	public String getPostMethod() {
		System.out.println("/multi.do��û");
		return "multi_result";
		
	}// getPostMethod
	
	@RequestMapping(value={"/a.do","/b.do","/c.do"}, method = { GET, POST } )
	public String multiRequest() {
		
		return "multi_request";
		
	} // multiRequest
	
	/**
	 * �پ��� ��û URL�� �ϳ��� method���� ó��
	 * @return VIew Page ��
	 */
	@RequestMapping(value="/sub_result.do",method = { POST, GET })
	public String resultMethod() {
		
		// return "sub_result"; // /WEB-INF/views/sub_result.jsp
		// views�� ���� ��ΰ� ������ ������ ���� ��θ� ����Ͽ� JSP�� ��û�ǵ��� ó��.
		return "day0510/sub_result"; // /WEB-INF/views/day0510/sub_result.jsp
		
	}// resultMethod
	
	/**
	 * ��û URL�� ���� JSP���� ���ٸ� method�� ��ȯ���� void�� ������ �� �ִ�. 
	 */
	@RequestMapping(value = "/void_return.do", method = GET)
	public void voidReturn() {
		System.out.println("void_return.do ȣ��");
	}// voidReturn
}

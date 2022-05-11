package kr.co.kyhstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kyhstudy.vo.ParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestController {

	@RequestMapping( value = "request_info.do", method = GET)
	public String reqInfo( HttpServletRequest request ) {
		
		String ip = request.getRemoteAddr();
		System.out.println("접속자 IP " + ip);
		System.out.println("요청방식 " + request.getMethod());
		System.out.println("요청 URL " + request.getRequestURL());
		System.out.println("요청 URI " + request.getRequestURI());

		Enumeration<String> en = request.getHeaderNames();

		String headerName="";
		while( en.hasMoreElements() ) {
			
			headerName = en.nextElement();
			System.out.println(headerName + ":" + request.getHeader( headerName ));
			
		}// end while
		
		if("211.63.89.133".equals(ip)) {
			
			System.out.println("강산접속");
			
		}// end if
		
		return "day0511/req_info";
		
	}// reqInfo
	
	/**
	 * HttpServletRequest를 사용한 Web Parameter 처리
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/use_request.do", method = GET)
	public String useRequest(HttpServletRequest request) {
		
		request.setAttribute("msg", "use_request.do");
		
		// 이름 유일
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		// 이름 중복
		String[] lang = request.getParameterValues("lang");
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("언어 : ");
		
		if( lang != null) {
			
			for( String temp : lang ) {
				
				System.out.println(temp);
				
			}// end for
			
		}// end if
		
		return "day0511/use_request";

	}// useRequest
	
	/**
	 * 단일형으로 웹 파라메터 받기<br/>
	 * 웹 파라메터 명과 method 파라메터명이 반드시 같아야 한다.
	 * @param name
	 * @param age
	 * @param lang
	 * @return
	 */
	@RequestMapping("single_param.do")
	//public String useSingleParam(String name, String age, String[] lang, Model model) {
	public String useSingleParam(String name, @RequestParam(defaultValue = "0") int age, String[] lang, Model model) {
		// web parameter은 문자열로만 전달되지만 매개변수의 데이터형을 기본형으로 선언하면
		// Spring Framework에서 형변환을 수행하여 입력해준다.
		
		model.addAttribute("msg", "/single_param.do");
		
		System.out.println("단일형 데이터형으로 매개변수 처리");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age + " / " + (2022-age+1));
		System.out.println("언어 : ");
		
		if( lang != null) {
			
			for( String temp : lang ) {
				
				System.out.println(temp);
				
			}// end for
			
		}// end if
		
		return "day0511/use_request";
		
	}// useSingleParam
	
	@RequestMapping(value = "/vo_param.do", method = { GET, POST } )
	public String paramVO(HttpServletRequest request, ParamVO pVO, Model model ) {
		
		// POST방식의 한글 처리
		model.addAttribute("msg", "/vo_param.do");
		try {
			pVO.setName(URLDecoder.decode(pVO.getName(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println(pVO);
		return "day0511/use_request";
		
	}
	
}// class
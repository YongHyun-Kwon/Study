package kr.co.kyhstudy.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.kyhstudy.service.DataService;

/**
 * session ���.
 * 
 * @author user
 */
@Controller
@SessionAttributes({ "sesName", "sesAge" })
public class SessionController {

	@RequestMapping(value = "/day0512/session.do", method = RequestMethod.GET)
	public String useSession(HttpSession session) {

		System.out.println(session);
		// ���ǿ� �� ����
		session.setAttribute("name", "������");
		DataService ds = new DataService();
		session.setAttribute("data", ds.searchData());

		System.out.println(session.getAttribute("name"));
		return "day0512/use_session";

	}// useSession

	@RequestMapping(value = "day0513/set_session.do", method = RequestMethod.GET)
	public String setSessionValue(Model model) {

		// model�� @SessionAttribute�� ���� �̸����� ���� ����.
		model.addAttribute("sesName", "���μ�");
		model.addAttribute("sesAge", "20");

		return "day0513/set_session";

	}// setSessionValue

	/**
	 * ���ǿ� ������ �� �ޱ�
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "day0513/get_session.do", method = RequestMethod.GET)
	public String getSessionValue(HttpSession session) {

		String sesName = (String) session.getAttribute("sesName");
		String url = "day0513/get_session";

		if (sesName == null) {
			url = "redirect:http://localhost/spring_mvc/index.do";
		} else {

			System.out.println(sesName);
			System.out.println(session.getAttribute("sesAge"));

		} // end else

		return url;

	}// getSessionValue

	@RequestMapping(value = "day0513/remove_session.do", method = RequestMethod.GET)
	public String removeSession(SessionStatus ss) {

		System.out.println("������ : " + ss.isComplete());

		ss.setComplete();

		System.out.println("���� �� : " + ss.isComplete());

		return "day0513/remove_session";
	}// removeSession
//	public String removeSession(HttpSession session) { //HttpSesssion���� ���� ������ �� ����.
//		
//		session.removeAttribute("sesName");
//		session.removeAttribute("sesAge");
//		
//		System.out.println("���� ����");
//		System.out.println("�̸�" + session.getAttribute("sesName"));
//		System.out.println("����" + session.getAttribute("sesAge"));
//		
//		return "day0513/remove_session";
//		
//	}// removeSession

	@RequestMapping(value = "/day0513/add_cookie.do", method = RequestMethod.GET)
	public String addCookie(HttpServletResponse response) {

		// ��Ű ����
		Cookie cookie = new Cookie("name", "�׽�Ʈ");
		Cookie cookie2 = new Cookie("addr", "�����");

		// ���� �ð� ����
		cookie.setMaxAge(60 * 60 * 1);
		cookie2.setMaxAge(60 * 60 * 1);

		// ��Ű �ɱ�
		response.addCookie(cookie);
		response.addCookie(cookie2);

		return "day0513/add_cookie";

	}// addCookie

	@RequestMapping(value = "day0513/get_cookie.do", method = RequestMethod.GET)
	public String getCookieValue(@CookieValue(value = "name", defaultValue = "����") String name,
			@CookieValue(value = "addr", defaultValue = "�ּ� ���� ") String addr) {

		System.out.println("name ��Ű �� : " + name);
		System.out.println("addr ��Ű �� : " + addr);

		return "day0513/get_cookie";

	}// getCookieValue
	
	@RequestMapping(value = "/day0513/remove_cookie.do", method = RequestMethod.GET)
	public String removeCookie(HttpServletResponse response) {

		// ��Ű ����
		Cookie cookie = new Cookie("name", "");
		Cookie cookie2 = new Cookie("addr", "");

		// ���� �ð� ����
		cookie.setMaxAge(0);
		cookie2.setMaxAge(0);

		// ��Ű �ɱ�
		response.addCookie(cookie);
		response.addCookie(cookie2);

		return "day0513/get_cookie";

	}// addCookie

}// class

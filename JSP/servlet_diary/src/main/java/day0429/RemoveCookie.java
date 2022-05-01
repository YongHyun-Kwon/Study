package day0429;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveCookie
 */
@SuppressWarnings("serial")
public class RemoveCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��Ű ����
		// 1. �����Ϸ��� �̸��� ��Ű ����
		Cookie nameCookie = new Cookie("cookieName", "");
		Cookie ageCookie = new Cookie("cookieAge", "");

		// 2. �ٷ� ������ �� �ֵ��� �����ð��� 0���� ����.
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);
		
		// 3. ��Ű �ɱ�
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		// ��Ű �б����� ���������� �̵�
		response.sendRedirect("http://localhost/servlet_prj/read_cookie");

	}

}

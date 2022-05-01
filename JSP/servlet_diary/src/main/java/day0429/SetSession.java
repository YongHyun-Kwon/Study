package day0429;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
// 1. HttpServlet ���
public class SetSession extends HttpServlet {
       // 2. ��û����� ó���� �� �ִ� method�� Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ �ʿ䰡 �ִٸ�. �������� �����ϰ� ��½�Ʈ���� ��´�.
		// 3. ����ó��
		String param = request.getParameter("param");
		
		if( param == null ) {
			param = "����ȣ��";
		} // end if
		
		// S_1. ���Ǿ��
		HttpSession session = request.getSession();
		// S_2. interval ���� ( web.xml)
		session.setMaxInactiveInterval(60* 2);
		// s_3. ���ǿ� �� �Ҵ� -> �Ҵ�� ���� � ������������ ����� �� �ִ�.
		session.setAttribute("paramData", param);
		
		// 4.�������̵�
		RequestDispatcher rd = request.getRequestDispatcher("day0429/session_view.jsp");
		rd.forward(request, response);
	} // service

} // class

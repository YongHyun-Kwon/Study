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
public class RemoveSession extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// ������ ����
		// 1. ���Ǿ��
		HttpSession session = request.getSession();
		// 2. ���� �� ����
		session.removeAttribute("paramData");
		// 3. �������̵�
		
		RequestDispatcher rd = request.getRequestDispatcher("day0429/remove_view.jsp");
		rd.forward(request, response);
	}

}

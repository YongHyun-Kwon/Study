package day0428;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������ó���� ����
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class DataProcess extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] url = { "daum.net", "naver.com", "google.com", "nate.com", "youtube.com" };

		TestVO tv = new TestVO("������", "�����е� ������ ������Ʈ �������ּ���.");
		//scope��ü������(�̵����������� ����� �� �ֵ��� request�� session�� ���)
		request.setAttribute("site_url", url);
		request.setAttribute("vo", tv);
		
		//�̵��� ������ uri ����
		// http://localhost/servlet_prj/day0428/view.jsp
		RequestDispatcher rd = request.getRequestDispatcher("day0428/data_view.jsp");
		// �̵�
		rd.forward(request, response);
	}

}

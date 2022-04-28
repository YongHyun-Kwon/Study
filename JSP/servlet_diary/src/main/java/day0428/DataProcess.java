package day0428;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 데이터처리를 수행
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class DataProcess extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] url = { "daum.net", "naver.com", "google.com", "nate.com", "youtube.com" };

		TestVO tv = new TestVO("김진영", "조원분들 열심히 프로젝트 수행해주세요.");
		//scope객체에저장(이동페이지에서 사용할 수 있도록 request나 session을 사용)
		request.setAttribute("site_url", url);
		request.setAttribute("vo", tv);
		
		//이동할 페이지 uri 설정
		// http://localhost/servlet_prj/day0428/view.jsp
		RequestDispatcher rd = request.getRequestDispatcher("day0428/data_view.jsp");
		// 이동
		rd.forward(request, response);
	}

}

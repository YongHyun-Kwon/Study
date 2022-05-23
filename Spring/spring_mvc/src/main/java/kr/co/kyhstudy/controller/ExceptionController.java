package kr.co.kyhstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ExceptionController {

	/**
	 * Controller�� ��û method���� ���ܰ� �߻��ϸ� D.S���� ���ܸ� ��´�.
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "day0516/use_exception.do", method = GET)
	public String useMethod() throws Exception {

		// Service�� ������� �� ���ܰ� �߻��Ѵٴ� ����
		if (new Random().nextBoolean()) {
			throw new Exception("Service���� �߻��� ����");
		} // end if

		return "day0516/success";

	}// useMethod

	// SQLException�� throws �ϴ� ���ܸ� ó���ϴ� Handler

	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlExceptionHandler(SQLException se) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("err/err500");
		mav.addObject("err_msg", se.getMessage());

		return mav;

	}// sqlExceptionHandler

	@ExceptionHandler(Exception.class)
	// ��ȯ���� ModelAndView �Ű������� ExceptionHandler�� ���ǵ� ����ó�� ��ü
	public ModelAndView exceptionHandler(Exception exception, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Enumeration<String> en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		} // end while

		// exception.printStackTrace();

		// ���ܰ� �߻����� �� ������ View ��������
		mav.setViewName("err/err500");
		mav.addObject("err_msg", exception.getMessage());
		mav.addObject("err_user-agent", request.getHeader("user-agent"));
		mav.addObject("referer", request.getHeader("referer"));

		return mav;
	}// exceptionHandler

}// class

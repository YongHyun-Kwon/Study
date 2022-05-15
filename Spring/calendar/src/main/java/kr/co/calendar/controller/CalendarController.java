package kr.co.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Calendar;

@Controller
public class CalendarController {

	@RequestMapping(value = {"/index.do","/calendar.do"}, method = { GET, POST })
	public String main(Model model, @RequestParam(defaultValue = "-1") int param_month,
			@RequestParam(defaultValue = "-1") int param_year) {
		
		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_MONTH);
		
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		// 월이 입력되면
		if( param_month != -1 ) {
			// 현재월에 없는 일자가 설정되면 다음달 1일로 설정된다.
			cal.set(Calendar.MONTH, param_month-1); // 월은 0베이스이기 때문에 사람의 월보다 1적게 설정
		}// end if

		// 년이 입력되면
		if( param_year != -1 ) {
			cal.set(Calendar.YEAR, param_year); // 년은 1베이스기 때문에 사람의 년으로 그대로 설정
		}// end if
		
		model.addAttribute("cal", cal);
		model.addAttribute("today", today);
		
		return "index";
		
	}// main
	
}// class
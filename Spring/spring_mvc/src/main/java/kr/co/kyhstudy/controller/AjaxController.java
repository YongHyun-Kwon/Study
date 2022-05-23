package kr.co.kyhstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kyhstudy.service.AjaxService;

@Controller
public class AjaxController {

	@RequestMapping(value = "day0513/ajax.do", method = RequestMethod.GET)
	public String ajax(Model model) {

		AjaxService ajs = new AjaxService();

		model.addAttribute("data", ajs.createJSON());

		return "day0513/ajax_result";

	}// ajax

	@ResponseBody
	@RequestMapping(value = "day0516/ajax.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String ajax1(Model model) {

		AjaxService ajs = new AjaxService();
		// @ResponseBody�� ���ǵǸ� View ���������� �ƴ� JSON�� return �Ǿ���Ѵ�.

		return ajs.createJSON();

	}// ajax

}

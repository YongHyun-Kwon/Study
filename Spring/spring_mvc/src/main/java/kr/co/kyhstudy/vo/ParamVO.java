package kr.co.kyhstudy.vo;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Web Parameter값을 받기위해 생성된 VO
 * HTML Form Control명과 VO의 instance 변수명이 반드시 같아야한다. 
 * @author user
 */
public class ParamVO {

	private String name;
	private int age;
	private String[] lang;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(@RequestParam(defaultValue = "0") int age) {
		this.age = age;
	}

	public String[] getLang() {
		return lang;
	}

	public void setLang(String[] lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "ParamVO [name=" + name + ", age=" + age + ", lang=" + Arrays.toString(lang) + "]";
	}

}// class

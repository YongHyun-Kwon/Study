package day0517.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day0517.service.InjectionService;
import day0517.service.InjectionService2;

/**
 * 다양한 의존성 주입
 * @author user
 */
public class InjectionTest {

	public static void main(String[] args) {
		
		// 1. Spring Container 생성
		ApplicationContext ac = new ClassPathXmlApplicationContext("day0517/run/applicationContext2.xml");
		
		// 생성자 의존성 주입받은 객체(bean) 얻기
		InjectionService is = ac.getBean("is",InjectionService.class);
		System.out.println("의존성 주입 받은 객체 : " + is.getDao());
		System.out.println("--------------------------------");
		
		//method의존성 주입 받은 객체(bean) 얻기
		InjectionService is2 = ac.getBean("is2",InjectionService.class);
		System.out.println("method 의존성 주입 받은 객체 : " + is2.getDao());
		
		//문자열을 의존성 주입 받은 객체
		InjectionService2 strInjection = ac.getBean(InjectionService2.class);
		System.out.println("문자열 의존성 주입 받은 결과 : " + strInjection.getName());
		
		//Spring Container 종료
		((ClassPathXmlApplicationContext)ac).close();
		
	}

}

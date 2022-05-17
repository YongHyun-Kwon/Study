package day0517.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day0517.service.InjectionService;
import day0517.service.InjectionService2;

/**
 * �پ��� ������ ����
 * @author user
 */
public class InjectionTest {

	public static void main(String[] args) {
		
		// 1. Spring Container ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("day0517/run/applicationContext2.xml");
		
		// ������ ������ ���Թ��� ��ü(bean) ���
		InjectionService is = ac.getBean("is",InjectionService.class);
		System.out.println("������ ���� ���� ��ü : " + is.getDao());
		System.out.println("--------------------------------");
		
		//method������ ���� ���� ��ü(bean) ���
		InjectionService is2 = ac.getBean("is2",InjectionService.class);
		System.out.println("method ������ ���� ���� ��ü : " + is2.getDao());
		
		//���ڿ��� ������ ���� ���� ��ü
		InjectionService2 strInjection = ac.getBean(InjectionService2.class);
		System.out.println("���ڿ� ������ ���� ���� ��� : " + strInjection.getName());
		
		//Spring Container ����
		((ClassPathXmlApplicationContext)ac).close();
		
	}

}

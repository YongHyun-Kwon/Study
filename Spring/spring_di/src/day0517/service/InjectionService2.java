package day0517.service;

public class InjectionService2 {

	private String name;
	
	public InjectionService2(String name) {
		
		this.name = name;
		System.out.println("���ڿ��� ������ ���� �޴� ������");
		
	}// InjectionService2
	
	public String getName() {
		
		return name;
		
	}// getName
	
}// class

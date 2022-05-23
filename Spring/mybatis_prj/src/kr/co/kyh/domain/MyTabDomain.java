package kr.co.kyh.domain;

/**
 * MyBatis���� ��ȸ ����� �����ϱ� ���� ����� VO => Domain
 * 
 * @author user
 */
public class MyTabDomain {

	private String name, email, input_Date;
	private int age;

	public MyTabDomain() {
		System.out.println("MyTabDomain �� MyBatis Framework���� ����");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInput_Date() {
		return input_Date;
	}

	public void setInput_Date(String input_Date) {
		this.input_Date = input_Date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyTabDomain [name=" + name + ", email=" + email + ", input_Date=" + input_Date + ", age=" + age + "]";
	}

}


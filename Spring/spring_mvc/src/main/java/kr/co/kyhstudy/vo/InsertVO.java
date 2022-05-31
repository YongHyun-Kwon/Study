package kr.co.kyhstudy.vo;

public class InsertVO {

	private int num, age, row_cnt;
	private String name, email, errmsg;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRow_cnt() {
		return row_cnt;
	}

	public void setRow_cnt(int row_cnt) {
		this.row_cnt = row_cnt;
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

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "InsertVO [num=" + num + ", age=" + age + ", row_cnt=" + row_cnt + ", name=" + name + ", email=" + email
				+ ", errmsg=" + errmsg + "]";
	}

}// inserVO

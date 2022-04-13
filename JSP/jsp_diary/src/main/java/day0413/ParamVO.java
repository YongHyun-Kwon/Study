package day0413;

import java.util.Arrays;

/**
 * web parameter�� �ޱ� ���� VO
 * HTML Form Control name �Ӽ��� �̸��� instance variable�� �̸��� �ݵ�� ���ƾ��Ѵ�.
 * @author user
 */
public class ParamVO {
	private String text, password, hid, date, file, ta, gender, domain, flag;
	private String[] loc;
	private int age;
	
	public ParamVO() {
		System.out.println("ParamVO�� �⺻������");
	} // ParamVO
	
	
	public ParamVO(String text, String password, String hid, String date, String file, String ta, String gender,
			String domain, String flag, String[] loc, int age) {
		System.out.println("ParamVO�� �����ε��� ������");
		this.text = text;
		this.password = password;
		this.hid = hid;
		this.date = date;
		this.file = file;
		this.ta = ta;
		this.gender = gender;
		this.domain = domain;
		this.flag = flag;
		this.loc = loc;
		this.age = age;
	} // ParamVO



	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getTa() {
		return ta;
	}
	public void setTa(String ta) {
		this.ta = ta;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String[] getLoc() {
		return loc;
	}
	public void setLoc(String[] loc) {
		this.loc = loc;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ParameterVO [text=" + text + ", password=" + password + ", hid=" + hid + ", date=" + date + ", file="
				+ file + ", ta=" + ta + ", gender=" + gender + ", domain=" + domain + ", flag=" + flag + ", loc="
				+ Arrays.toString(loc) + ", age=" + age + "]";
	}
	
}
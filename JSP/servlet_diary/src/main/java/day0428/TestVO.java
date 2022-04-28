package day0428;

public class TestVO {
	private String name, msg;

	public TestVO() {
		// TODO Auto-generated constructor stub
	}

	public TestVO(String name, String msg) {
		this.name = name;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "TestVO [name=" + name + ", msg=" + msg + "]";
	}

}

package kr.co.kyhstudy.vo;

import org.springframework.web.bind.annotation.RequestParam;

public class DynamicVO {

	private int empno, deptno;
	private String job;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(@RequestParam(defaultValue = "0") int empno) {
		this.empno = empno;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(@RequestParam(defaultValue = "0") int deptno) {
		this.deptno = deptno;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "DynamicVO [empno=" + empno + ", deptno=" + deptno + ", job=" + job + "]";
	}

}

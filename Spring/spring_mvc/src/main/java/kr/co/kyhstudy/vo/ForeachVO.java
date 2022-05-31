package kr.co.kyhstudy.vo;

import java.util.Arrays;

public class ForeachVO {

	private int deptno;

	private String[] job;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String[] getJob() {
		return job;
	}

	public void setJob(String[] job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "ForeachVO [deptno=" + deptno + ", job=" + Arrays.toString(job) + "]";
	}

}

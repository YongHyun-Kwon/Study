package com.jdbc.kyh.prepared.vo;

import java.sql.Date;

public class CpEmp1VO {
	private int empno, sal;
	private String ename, job;
	private double comm;
	private Date hiredate;

	public CpEmp1VO() {
	} // CpEmp1VO

	public CpEmp1VO(int empno, int sal, String ename, String job, double comm, Date hiredate) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.comm = comm;
		this.hiredate = hiredate;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "CpEmp1VO [empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", job=" + job + ", comm=" + comm
				+ ", hiredate=" + hiredate + "]";
	}

} // class

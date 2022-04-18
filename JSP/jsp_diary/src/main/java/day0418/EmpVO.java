package day0418;

import java.sql.Date;

public class EmpVO {

	private int empno, sal, mgr, deptno;
	private double comm;
	private String ename, job;
	private Date hiredate;

	public EmpVO() {
		// TODO Auto-generated constructor stub
	}

	public EmpVO(int empno, int sal, int mgr, int deptno, double comm, String ename, String job, Date hiredate) {
		this.empno = empno;
		this.sal = sal;
		this.mgr = mgr;
		this.deptno = deptno;
		this.comm = comm;
		this.ename = ename;
		this.job = job;
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

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
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

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

}

package kr.co.kyh.domain;

public class CpEmp4Domain {

	private int empno, sal, comm;
	private String ename, job;

	public CpEmp4Domain() {
		System.out.println("CpEmp4Domain°´Ã¼ »ý¼º");
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

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
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

	@Override
	public String toString() {
		return "CpEmp4Domain [empno=" + empno + ", sal=" + sal + ", comm=" + comm + ", ename=" + ename + ", job=" + job
				+ "]";
	}

}// CpEmp4Domain

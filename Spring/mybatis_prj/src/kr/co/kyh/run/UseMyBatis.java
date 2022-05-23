package kr.co.kyh.run;

import kr.co.kyh.service.TestService;
import kr.co.kyh.vo.CpEmp4VO;

/**
 * MyBatis Framwork 사용
 * @author user
 */
public class UseMyBatis {

	public static void main(String[] args) {
		
		CpEmp4VO cp = new CpEmp4VO(10, 3300,  100, "강현모", "개발자");
		
		TestService ts = new TestService();
		
		System.out.println(ts.addEmp(cp));
		
	}// main
	
}// class

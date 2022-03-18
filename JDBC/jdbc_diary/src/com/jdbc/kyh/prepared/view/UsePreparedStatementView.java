package com.jdbc.kyh.prepared.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.jdbc.kyh.prepared.dao.PreparedStatementDAO;
import com.jdbc.kyh.prepared.vo.CpEmp1VO;


/**
 * 업무로직을 처리하면서 필요에따라 DB작업을 사용하는 클래스.<br>
 * XxxService 클래스의 method명은 업무의 용어로 작성한다. ( 절대 쿼리를 method명으로 설정하지않는다.)
 * 
 * @author user
 */
public class UsePreparedStatementView {

	public static final String ADD = "1";
	public static final String MODIFY = "2";
	public static final String REMOVE = "3";
	public static final String SEARCH_ONE = "4";
	public static final String SEARCH_ALL = "5";
	public static final String EXIT = "6";

	private PreparedStatementDAO psDAO;

	public UsePreparedStatementView() {
		psDAO = new PreparedStatementDAO();
	}// UsePreparedStatementView

	public void addCpEmp1() {
		String tempData = JOptionPane.showInputDialog("추가할 사원정보 \",\"로 구분입력\n사원번호,사원명,직무,연봉,보너스");
		String[] data = tempData.split(",");

		if (data.length != 5) { // 비정상적인 입력상황
			JOptionPane.showMessageDialog(null, "입력데이터의 갯수가 맞지 않습니다.");
			return; // early return;
		} // end if

		// 위 if의 조건에 맞지 않을 때 상황코드( else 에대한 코드 )
		// 정상적인 입력상황
		// 1.값에 대한 가공. 문자열=> 변환
		try {
			// 분할된 값을
			int empno = Integer.parseInt(data[0]);
			String ename = data[1];
			String job = data[2];
			int sal = Integer.parseInt(data[3]);
			double comm = Double.parseDouble(data[4]);

			// VO에 넣고
			CpEmp1VO ceVO = new CpEmp1VO();
			ceVO.setEmpno(empno);
			ceVO.setEname(ename);
			ceVO.setJob(job);
			ceVO.setSal(sal);
			ceVO.setComm(comm);

			// DAO에 전달
			psDAO.insertCpEmp1(ceVO);

			JOptionPane.showMessageDialog(null, ceVO.getEname() + " 사원정보를 추가하였습니다.");
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "사원추가작업에 문제가 발생하였습니다.");
			se.printStackTrace();
			// 다양한 예외상황처리,
			int errCode = se.getErrorCode();
			String sqlErrMsg = "";
			switch (errCode) {
			case 1062: // ERROR 1062
				sqlErrMsg = "같은 사원 번호가 이미 존재합니다.";
				break;
			case 1064: // ERROR 1064
				sqlErrMsg = "쿼리문이 잘못 되었습니다.";
				break;
			case 1264: // ERROR 1264 - 숫자값이 정해진 크기보다 큰 경우
				sqlErrMsg = "사원번호는 숫자 4자리까지, 연봉 5자리, 보너스 5자리 입니다.";
				break;
			case 22001: // ERROR 문자열 값이 정해진 크기보다 큰 경우
				sqlErrMsg = "사원명은 영어10자 한글은 3자이내 이어야하고, 직무는 영어 9자 한글 3자 이내 이어야합니다.";
				break;
			}// end switch

			JOptionPane.showMessageDialog(null, sqlErrMsg);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호,연봉,보너스는 숫자이어야합니다.");
		} // end catch

	}// addCpEmp1

	public void modifyCpEmp1() {
		String tempData = JOptionPane
				.showInputDialog("수정할 사원정보 \",\"로 구분입력\n사원번호,직무,연봉,보너스\n사원번호에 일치하는 사원의 직무,연봉,보너스를 변경합니다.");
		String[] data = tempData.split(",");

		if (data.length != 1) { // 비정상적인 입력상황
			JOptionPane.showMessageDialog(null, "입력데이터의 갯수가 맞지 않습니다. 입력값은 1개 이어야합니다.");
			return; // early return;
		} // end if

		// 정상적인 입력상황
		try {
			// 1. 데이터의 가공
			int empno = Integer.parseInt(data[0]);
			String job = data[1];
			int sal = Integer.parseInt(data[2]);
			double comm = Double.parseDouble(data[3]);

			// 처리된 데이터를 VO에 저장
			CpEmp1VO ceVO = new CpEmp1VO();
			ceVO.setEmpno(empno);
			ceVO.setJob(job);
			ceVO.setSal(sal);
			ceVO.setComm(comm);

			String msg = empno + "번 사원은 존재하지 않습니다.";
			// 3. DB작업 후 결과 얻기
			int cnt = psDAO.updateCpEmp1(ceVO); // 업데이트 작업 후 변경된 행의 갯수 얻기

			if (cnt == 1) {
				msg = empno + "번 사원정보가 변경되었습니다.";
			} // end if

			JOptionPane.showMessageDialog(null, msg);

		} catch (SQLException se) {
			se.printStackTrace();
			// 다양한 예외상황처리,
			int errCode = se.getErrorCode();
			String sqlErrMsg = "";
			switch (errCode) {
			case 1064: // ERROR 1064
				sqlErrMsg = "쿼리문이 잘못 되었습니다.";
				break;
			case 1264: // ERROR 1264 - 숫자값이 정해진 크기보다 큰 경우
				sqlErrMsg = "사원번호는 숫자 4자리까지, 연봉 5자리, 보너스 5자리 입니다.";
				break;
			case 22001: // ERROR 문자열 값이 정해진 크기보다 큰 경우
				sqlErrMsg = "사원명은 영어10자 한글은 3자이내 이어야하고, 직무는 영어 9자 한글 3자 이내 이어야합니다.";
				break;
			}// end switch

			JOptionPane.showMessageDialog(null, sqlErrMsg);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호,연봉,보너스는 숫자이어야합니다.");
		} // end catch

	}// modifyCpEmp1

	public void removeCpEmp1() {
		String tempData = JOptionPane.showInputDialog(" 삭제할 사원번호 입력해주세요.");

		try {
			// 입력값 처리
			int empno = Integer.parseInt(tempData);

			// DB작업 수행 - 삭제된 행의 수를 얻는 다.
			int cnt = psDAO.deleteCpEmp1(empno);

			String msg = empno + "번 사원은 존재하지 않습니다.";
			if (cnt == 1) {
				msg = empno + "번 사원정보가 삭제되었습니다.";
			} // end if

			JOptionPane.showMessageDialog(null, msg);

		} catch (SQLException se) {
			se.printStackTrace();

			// 다양한 예외상황처리,
			int errCode = se.getErrorCode();
			String sqlErrMsg = "";

			switch (errCode) {
			case 1064: // ERROR 1064
				sqlErrMsg = "쿼리문이 잘못 되었습니다.";
				break;
			}// end switch

			JOptionPane.showMessageDialog(null, sqlErrMsg);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자로만 구성됩니다.");
		}

	}// removeCpEmp1

	public void searchOneCpEmp1() {
		String tempData = JOptionPane.showInputDialog(" 조회할 사원번호 입력해주세요.");

		try {
			// 입력값 처리
			int empno = Integer.parseInt(tempData);
			// DB작업

			CpEmp1VO ceVO = psDAO.selectOneCpEmp1(empno); // 사원번호에 대한 사원 하나 조회

			StringBuilder empOutputData = new StringBuilder();
			empOutputData.append(empno).append("번 사원정보 조회 결과\n");

			if (ceVO == null) {// 사원번호로 조회한 결과가 없음.
				empOutputData.append("조회된 사원이 없습니다. 사원번호를 확인해주세요.");
			} else {
				empOutputData.append("사원명 : ").append(ceVO.getEname()).append("\n");
				empOutputData.append("연봉 : ").append(ceVO.getSal()).append("\n");
				empOutputData.append("보너스 : ").append(ceVO.getComm()).append("\n");
				empOutputData.append("직무 : ").append(ceVO.getJob());
			} // end else

			JOptionPane.showMessageDialog(null, new JTextArea(empOutputData.toString(), 10, 50));

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "사원정보를 조회할 수 없습니다.");
			se.printStackTrace();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자이어야합니다.");
		} // end catch

	}// searchOneCpEmp1

	public void searchAllCpEmp1() {
		try {
			// 모든 레코드를 조회한다.
			List<CpEmp1VO> empList = psDAO.selectAllCpEmp1();

			StringBuilder outputData = new StringBuilder();
			outputData.append("전체사원 조회\n");
			outputData.append("사원번호\t사원명\t직무\t연봉\t보너스\t입사일\n");

			// 조회된 결과가 없을 때 보여줄 내용
			if (empList.isEmpty()) {
				outputData.append("조회된 사원정보가 없습니다.");
			} // end if

			// 리스트를 반복시켜 모든 정보를 출력한다.
			// 날짜처리
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (CpEmp1VO cevo : empList) {
				outputData.append(cevo.getEmpno()).append("\t").append(cevo.getEname()).append("\t")
						.append(cevo.getJob()).append("\t").append(cevo.getSal()).append("\t").append(cevo.getComm())
						.append("\t").append(sdf.format(cevo.getHiredate())).append("\n");
			} // end for
			outputData.append(empList.size()).append("명 조회");

			JTextArea jta = new JTextArea(outputData.toString(), 15, 60);
			JScrollPane jsp = new JScrollPane(jta);
			jsp.setBorder(new TitledBorder("전체사원 정보 조회"));

			JOptionPane.showMessageDialog(null, jsp);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "전체 사원 조회 중 문제 발생.");
			e.printStackTrace();
		} // end catch

	}// searchAllCpEmp1

	public void menu() {

		boolean exitFlag = false;
		String inputMenu = "";

		try {
			do {
				inputMenu = JOptionPane
						.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3. 사원삭제 4. 사원조회 5.모든사원조회 6.종료\n번호를 입력하세요.");

				switch (inputMenu) {
				case ADD:
					addCpEmp1();
					break;
				case MODIFY:
					modifyCpEmp1();
					break;
				case REMOVE:
					removeCpEmp1();
					break;
				case SEARCH_ONE:
					searchOneCpEmp1();
					break;
				case SEARCH_ALL:
					searchAllCpEmp1();
					break;
				case EXIT:
					exitFlag = true;
					break;
				}// end switch

			} while (!exitFlag);
		} catch (NullPointerException npe) {
			// 사용자가 취소나, x를 누른 경우
			npe.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(null, "프로그램이 종료되었습니다.");
		} // catch

	}// menu

	public static void main(String[] args) {
		new UsePreparedStatementView().menu();
	}// main

}// class

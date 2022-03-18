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
 * ���������� ó���ϸ鼭 �ʿ信���� DB�۾��� ����ϴ� Ŭ����.<br>
 * XxxService Ŭ������ method���� ������ ���� �ۼ��Ѵ�. ( ���� ������ method������ ���������ʴ´�.)
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
		String tempData = JOptionPane.showInputDialog("�߰��� ������� \",\"�� �����Է�\n�����ȣ,�����,����,����,���ʽ�");
		String[] data = tempData.split(",");

		if (data.length != 5) { // ���������� �Է»�Ȳ
			JOptionPane.showMessageDialog(null, "�Էµ������� ������ ���� �ʽ��ϴ�.");
			return; // early return;
		} // end if

		// �� if�� ���ǿ� ���� ���� �� ��Ȳ�ڵ�( else ������ �ڵ� )
		// �������� �Է»�Ȳ
		// 1.���� ���� ����. ���ڿ�=> ��ȯ
		try {
			// ���ҵ� ����
			int empno = Integer.parseInt(data[0]);
			String ename = data[1];
			String job = data[2];
			int sal = Integer.parseInt(data[3]);
			double comm = Double.parseDouble(data[4]);

			// VO�� �ְ�
			CpEmp1VO ceVO = new CpEmp1VO();
			ceVO.setEmpno(empno);
			ceVO.setEname(ename);
			ceVO.setJob(job);
			ceVO.setSal(sal);
			ceVO.setComm(comm);

			// DAO�� ����
			psDAO.insertCpEmp1(ceVO);

			JOptionPane.showMessageDialog(null, ceVO.getEname() + " ��������� �߰��Ͽ����ϴ�.");
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "����߰��۾��� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
			// �پ��� ���ܻ�Ȳó��,
			int errCode = se.getErrorCode();
			String sqlErrMsg = "";
			switch (errCode) {
			case 1062: // ERROR 1062
				sqlErrMsg = "���� ��� ��ȣ�� �̹� �����մϴ�.";
				break;
			case 1064: // ERROR 1064
				sqlErrMsg = "�������� �߸� �Ǿ����ϴ�.";
				break;
			case 1264: // ERROR 1264 - ���ڰ��� ������ ũ�⺸�� ū ���
				sqlErrMsg = "�����ȣ�� ���� 4�ڸ�����, ���� 5�ڸ�, ���ʽ� 5�ڸ� �Դϴ�.";
				break;
			case 22001: // ERROR ���ڿ� ���� ������ ũ�⺸�� ū ���
				sqlErrMsg = "������� ����10�� �ѱ��� 3���̳� �̾���ϰ�, ������ ���� 9�� �ѱ� 3�� �̳� �̾���մϴ�.";
				break;
			}// end switch

			JOptionPane.showMessageDialog(null, sqlErrMsg);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ,����,���ʽ��� �����̾���մϴ�.");
		} // end catch

	}// addCpEmp1

	public void modifyCpEmp1() {
		String tempData = JOptionPane
				.showInputDialog("������ ������� \",\"�� �����Է�\n�����ȣ,����,����,���ʽ�\n�����ȣ�� ��ġ�ϴ� ����� ����,����,���ʽ��� �����մϴ�.");
		String[] data = tempData.split(",");

		if (data.length != 1) { // ���������� �Է»�Ȳ
			JOptionPane.showMessageDialog(null, "�Էµ������� ������ ���� �ʽ��ϴ�. �Է°��� 1�� �̾���մϴ�.");
			return; // early return;
		} // end if

		// �������� �Է»�Ȳ
		try {
			// 1. �������� ����
			int empno = Integer.parseInt(data[0]);
			String job = data[1];
			int sal = Integer.parseInt(data[2]);
			double comm = Double.parseDouble(data[3]);

			// ó���� �����͸� VO�� ����
			CpEmp1VO ceVO = new CpEmp1VO();
			ceVO.setEmpno(empno);
			ceVO.setJob(job);
			ceVO.setSal(sal);
			ceVO.setComm(comm);

			String msg = empno + "�� ����� �������� �ʽ��ϴ�.";
			// 3. DB�۾� �� ��� ���
			int cnt = psDAO.updateCpEmp1(ceVO); // ������Ʈ �۾� �� ����� ���� ���� ���

			if (cnt == 1) {
				msg = empno + "�� ��������� ����Ǿ����ϴ�.";
			} // end if

			JOptionPane.showMessageDialog(null, msg);

		} catch (SQLException se) {
			se.printStackTrace();
			// �پ��� ���ܻ�Ȳó��,
			int errCode = se.getErrorCode();
			String sqlErrMsg = "";
			switch (errCode) {
			case 1064: // ERROR 1064
				sqlErrMsg = "�������� �߸� �Ǿ����ϴ�.";
				break;
			case 1264: // ERROR 1264 - ���ڰ��� ������ ũ�⺸�� ū ���
				sqlErrMsg = "�����ȣ�� ���� 4�ڸ�����, ���� 5�ڸ�, ���ʽ� 5�ڸ� �Դϴ�.";
				break;
			case 22001: // ERROR ���ڿ� ���� ������ ũ�⺸�� ū ���
				sqlErrMsg = "������� ����10�� �ѱ��� 3���̳� �̾���ϰ�, ������ ���� 9�� �ѱ� 3�� �̳� �̾���մϴ�.";
				break;
			}// end switch

			JOptionPane.showMessageDialog(null, sqlErrMsg);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ,����,���ʽ��� �����̾���մϴ�.");
		} // end catch

	}// modifyCpEmp1

	public void removeCpEmp1() {
		String tempData = JOptionPane.showInputDialog(" ������ �����ȣ �Է����ּ���.");

		try {
			// �Է°� ó��
			int empno = Integer.parseInt(tempData);

			// DB�۾� ���� - ������ ���� ���� ��� ��.
			int cnt = psDAO.deleteCpEmp1(empno);

			String msg = empno + "�� ����� �������� �ʽ��ϴ�.";
			if (cnt == 1) {
				msg = empno + "�� ��������� �����Ǿ����ϴ�.";
			} // end if

			JOptionPane.showMessageDialog(null, msg);

		} catch (SQLException se) {
			se.printStackTrace();

			// �پ��� ���ܻ�Ȳó��,
			int errCode = se.getErrorCode();
			String sqlErrMsg = "";

			switch (errCode) {
			case 1064: // ERROR 1064
				sqlErrMsg = "�������� �߸� �Ǿ����ϴ�.";
				break;
			}// end switch

			JOptionPane.showMessageDialog(null, sqlErrMsg);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� ���ڷθ� �����˴ϴ�.");
		}

	}// removeCpEmp1

	public void searchOneCpEmp1() {
		String tempData = JOptionPane.showInputDialog(" ��ȸ�� �����ȣ �Է����ּ���.");

		try {
			// �Է°� ó��
			int empno = Integer.parseInt(tempData);
			// DB�۾�

			CpEmp1VO ceVO = psDAO.selectOneCpEmp1(empno); // �����ȣ�� ���� ��� �ϳ� ��ȸ

			StringBuilder empOutputData = new StringBuilder();
			empOutputData.append(empno).append("�� ������� ��ȸ ���\n");

			if (ceVO == null) {// �����ȣ�� ��ȸ�� ����� ����.
				empOutputData.append("��ȸ�� ����� �����ϴ�. �����ȣ�� Ȯ�����ּ���.");
			} else {
				empOutputData.append("����� : ").append(ceVO.getEname()).append("\n");
				empOutputData.append("���� : ").append(ceVO.getSal()).append("\n");
				empOutputData.append("���ʽ� : ").append(ceVO.getComm()).append("\n");
				empOutputData.append("���� : ").append(ceVO.getJob());
			} // end else

			JOptionPane.showMessageDialog(null, new JTextArea(empOutputData.toString(), 10, 50));

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "��������� ��ȸ�� �� �����ϴ�.");
			se.printStackTrace();
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾���մϴ�.");
		} // end catch

	}// searchOneCpEmp1

	public void searchAllCpEmp1() {
		try {
			// ��� ���ڵ带 ��ȸ�Ѵ�.
			List<CpEmp1VO> empList = psDAO.selectAllCpEmp1();

			StringBuilder outputData = new StringBuilder();
			outputData.append("��ü��� ��ȸ\n");
			outputData.append("�����ȣ\t�����\t����\t����\t���ʽ�\t�Ի���\n");

			// ��ȸ�� ����� ���� �� ������ ����
			if (empList.isEmpty()) {
				outputData.append("��ȸ�� ��������� �����ϴ�.");
			} // end if

			// ����Ʈ�� �ݺ����� ��� ������ ����Ѵ�.
			// ��¥ó��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (CpEmp1VO cevo : empList) {
				outputData.append(cevo.getEmpno()).append("\t").append(cevo.getEname()).append("\t")
						.append(cevo.getJob()).append("\t").append(cevo.getSal()).append("\t").append(cevo.getComm())
						.append("\t").append(sdf.format(cevo.getHiredate())).append("\n");
			} // end for
			outputData.append(empList.size()).append("�� ��ȸ");

			JTextArea jta = new JTextArea(outputData.toString(), 15, 60);
			JScrollPane jsp = new JScrollPane(jta);
			jsp.setBorder(new TitledBorder("��ü��� ���� ��ȸ"));

			JOptionPane.showMessageDialog(null, jsp);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "��ü ��� ��ȸ �� ���� �߻�.");
			e.printStackTrace();
		} // end catch

	}// searchAllCpEmp1

	public void menu() {

		boolean exitFlag = false;
		String inputMenu = "";

		try {
			do {
				inputMenu = JOptionPane
						.showInputDialog("�޴�����\n1.����߰� 2.������� 3. ������� 4. �����ȸ 5.�������ȸ 6.����\n��ȣ�� �Է��ϼ���.");

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
			// ����ڰ� ��ҳ�, x�� ���� ���
			npe.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(null, "���α׷��� ����Ǿ����ϴ�.");
		} // catch

	}// menu

	public static void main(String[] args) {
		new UsePreparedStatementView().menu();
	}// main

}// class

package com.jdbc.kyh.prepared.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.jdbc.kyh.prepared.dao.CarTableDAO;
import com.jdbc.kyh.prepared.vo.SelectCarInfoVO;
import com.jdbc.kyh.prepared.vo.SelectCarModelVO;

/**
 * ���������� ó���ϸ鼭 �ʿ信 ���� DB �۾��� ����ϴ� Ŭ����. <br>
 * xxxService Ŭ������ method���� ������ ���� �ۼ��Ѵ�. ( ���� ������ method������ �������� �ʴ´�. )
 * 
 * @author user
 */
@SuppressWarnings("serial")
public class CarTableView extends JFrame implements ActionListener {

	private JTextField jtfModel;
	private JButton jbtnInput, jbtnList;
	private JTextArea jta;

	private CarTableDAO ctDAO;

	public CarTableView() {
		super("���� ��ȸ");
		ctDAO = new CarTableDAO();

	} // UseStatementDAOService

	public void searchCarList() {

		try {
			List<SelectCarModelVO> carList = ctDAO.selectCarList();

			StringBuilder outputDate = new StringBuilder();
			outputDate.append("������ ��ȸ\n");
			outputDate.append("���� ��\n");

			// ��ȸ�� ����� ���� �� ������ ����
			if (carList.isEmpty()) {

				outputDate.append("��ȸ�� ���������� �����ϴ�.");

			} // end if

			// ����Ʈ�� �ݺ����� ��� ������ ����Ѵ�.
			for (SelectCarModelVO wscmVO : carList) {

				outputDate.append(wscmVO.getModel()).append("\n");
			} // end for

			JOptionPane.showMessageDialog(null, outputDate);

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "���� �� ��ȸ �� ���� �߻�.");
			se.printStackTrace();
		}

	} // searchCarList

	public String searchCarInfo() {
		// ��� ���ڵ带 ��ȸ�Ѵ�.

		String model = jtfModel.getText();
		String sqlModel = "'" + model + "'";
		StringBuilder outputDate = null;
		try {
			List<SelectCarInfoVO> carList = ctDAO.selectCarInfo(sqlModel);

			outputDate = new StringBuilder();
			outputDate.append(sqlModel.replace("'", "")).append(" ���� ���� ��ȸ\n");
			outputDate.append("���\t����\t��ⷮ\t�ɼ�\n");

			// ��ȸ�� ����� ���� �� ������ ����
			if (carList.isEmpty()) {

				outputDate.append("��ȸ�� ���� ������ �����ϴ�.\n");

			} // end if

			// ����Ʈ�� �ݺ����� ��� ������ ����Ѵ�.
			for (SelectCarInfoVO wsciVO : carList) {
				outputDate.append(wsciVO.getCar_year()).append("\t").append(wsciVO.getPrice()).append("\t")
						.append(wsciVO.getCc()).append("\t").append(wsciVO.getOption()).append("\n");
			} // end for

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "�Է� ���� ��ȸ �� ���� �߻�.");
			se.printStackTrace();
		} // end catch
		return outputDate.toString();

	} // searchCarInfo

	public void menu() {

		jtfModel = new JTextField(10);
		jbtnInput = new JButton("�˻�");
		jbtnList = new JButton("�������");

		jta = new JTextArea(20, 60);
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("�Է����� ���� ��ȸ"));

		setLayout(new FlowLayout());

		add(new JLabel("�𵨸�"));
		add(jtfModel);
		add(jbtnInput);
		add(jbtnList);
		add(jsp);

		// �̺�Ʈ ���
		jtfModel.addActionListener(this);
		jbtnInput.addActionListener(this);
		jbtnList.addActionListener(this);

		setBounds(100, 100, 800, 500);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// ������ ����� ��񿬰��� ���� ����
				dispose();
			}

		});

	} // menu

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jtfModel || ae.getSource() == jbtnInput) {

			if (jtfModel.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��ȸ�� ���� ���� �Է����ּ���.");
				return;
			}

			jta.append(searchCarInfo());
			jtfModel.setText("");

		} // end if
		if (ae.getSource() == jbtnList) {
			searchCarList();
		} // end if

	} // actionPerformed

	public static void main(String[] args) {
		new CarTableView().menu();
	} // main

} // class
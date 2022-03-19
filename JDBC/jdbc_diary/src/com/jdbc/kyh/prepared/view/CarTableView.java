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
 * 업무로직을 처리하면서 필요에 따라 DB 작업을 사용하는 클래스. <br>
 * xxxService 클래스의 method명은 업무의 용어로 작성한다. ( 절대 쿼리를 method명으로 설정하지 않는다. )
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
		super("차량 조회");
		ctDAO = new CarTableDAO();

	} // UseStatementDAOService

	public void searchCarList() {

		try {
			List<SelectCarModelVO> carList = ctDAO.selectCarList();

			StringBuilder outputDate = new StringBuilder();
			outputDate.append("차량모델 조회\n");
			outputDate.append("보유 모델\n");

			// 조회된 결과가 없을 때 보여줄 내용
			if (carList.isEmpty()) {

				outputDate.append("조회된 차량정보가 없습니다.");

			} // end if

			// 리스트를 반복시켜 모든 정보를 출력한다.
			for (SelectCarModelVO wscmVO : carList) {

				outputDate.append(wscmVO.getModel()).append("\n");
			} // end for

			JOptionPane.showMessageDialog(null, outputDate);

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "차량 모델 조회 중 문제 발생.");
			se.printStackTrace();
		}

	} // searchCarList

	public String searchCarInfo() {
		// 모든 레코드를 조회한다.

		String model = jtfModel.getText();
		String sqlModel = "'" + model + "'";
		StringBuilder outputDate = null;
		try {
			List<SelectCarInfoVO> carList = ctDAO.selectCarInfo(sqlModel);

			outputDate = new StringBuilder();
			outputDate.append(sqlModel.replace("'", "")).append(" 차량 정보 조회\n");
			outputDate.append("년식\t가격\t배기량\t옵션\n");

			// 조회된 결과가 없을 때 보여줄 내용
			if (carList.isEmpty()) {

				outputDate.append("조회된 차량 정보가 없습니다.\n");

			} // end if

			// 리스트를 반복시켜 모든 정보를 출력한다.
			for (SelectCarInfoVO wsciVO : carList) {
				outputDate.append(wsciVO.getCar_year()).append("\t").append(wsciVO.getPrice()).append("\t")
						.append(wsciVO.getCc()).append("\t").append(wsciVO.getOption()).append("\n");
			} // end for

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "입력 차량 조회 중 문제 발생.");
			se.printStackTrace();
		} // end catch
		return outputDate.toString();

	} // searchCarInfo

	public void menu() {

		jtfModel = new JTextField(10);
		jbtnInput = new JButton("검색");
		jbtnList = new JButton("차량목록");

		jta = new JTextArea(20, 60);
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("입력차량 정보 조회"));

		setLayout(new FlowLayout());

		add(new JLabel("모델명"));
		add(jtfModel);
		add(jbtnInput);
		add(jbtnList);
		add(jsp);

		// 이벤트 등록
		jtfModel.addActionListener(this);
		jbtnInput.addActionListener(this);
		jbtnList.addActionListener(this);

		setBounds(100, 100, 800, 500);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 윈도우 종료시 디비연결을 끊고 종료
				dispose();
			}

		});

	} // menu

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == jtfModel || ae.getSource() == jbtnInput) {

			if (jtfModel.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "조회할 차량 모델을 입력해주세요.");
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
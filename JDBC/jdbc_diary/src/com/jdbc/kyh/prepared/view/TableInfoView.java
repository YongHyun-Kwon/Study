package com.jdbc.kyh.prepared.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.jdbc.kyh.prepared.dao.TableInfoDAO;
import com.jdbc.kyh.prepared.vo.ColumnVO;


@SuppressWarnings("serial")
public class TableInfoView extends JFrame implements ActionListener {

	private DefaultComboBoxModel<String> dcbmTable;
	private JComboBox<String> jcbTable;
	private JTextArea jtaOuput;

	public TableInfoView() {

		super("테이블 정보 조회");

		dcbmTable = new DefaultComboBoxModel<String>();
		jcbTable = new JComboBox<String>(dcbmTable);
		jtaOuput = new JTextArea();

		JPanel jpanel = new JPanel();
		jpanel.add(new JLabel("테이블명"));
		jpanel.add(jcbTable);

		add("North", jpanel);
		add("Center", jtaOuput);

		jcbTable.addActionListener(this);

		setBounds(100, 100, 500, 600);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // TableInfoView

	@Override
	public void actionPerformed(ActionEvent e) {
		String tname = dcbmTable.getElementAt(jcbTable.getSelectedIndex());

		switch (JOptionPane.showConfirmDialog(this, tname + "테이블의 내용을 검색하겠습니까?")) {
		case JOptionPane.OK_OPTION:
			searchColumnData(tname);
		} // end switch

	}

	private void searchColumnData(String tname) {
		TableInfoDAO tiDAO = TableInfoDAO.getInstance();
		try {
			List<ColumnVO> list = tiDAO.selectTableColumn(tname);
			
			StringBuilder output = new StringBuilder();
			
			output.append("컬럼명\t컬럼타입\n");
			for(ColumnVO cVO : list) {
				output.append(cVO.getColumnName()).append("\t")
				.append(cVO.getColumnType()).append("\n");
			} // end for
			
			jtaOuput.setText(output.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // searchColumnData

	private void searchTableData() {
		TableInfoDAO tiDAO = TableInfoDAO.getInstance();
		try {
			List<String> tableList = tiDAO.selectAllTable();
			for (String tnaem : tableList) {
				dcbmTable.addElement(tnaem);
			} // end for

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch
		dcbmTable.addElement(null);
	} // setTableData

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableInfoView().searchTableData();
	}

}
package com.jdbc.kyh.prepared.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.jdbc.kyh.prepared.dao.CarMakerDAO;
import com.jdbc.kyh.prepared.vo.SelectCarMakerInfoVO;


@SuppressWarnings("serial")
public class UseCarView extends JFrame implements ActionListener {

	String data;

	public UseCarView() {
	}// UseWorkTableView

	public void menu() {

//		boolean exitFlag = false;
		String maker = JOptionPane.showInputDialog(null, "차량 제조사");

		if (maker.equals("")) {
			JOptionPane.showMessageDialog(null, "공백 ㄴㄴ");
		} else {
			searchCarMakerInfo(maker);

			JOptionPane.showMessageDialog(null, new JTextArea(data, 10, 10));

		}

	}// menu

	public void searchCarMakerInfo(String maker) {
		CarMakerDAO cmDAO = CarMakerDAO.getInstance();

		try {
			List<SelectCarMakerInfoVO> list = cmDAO.selectCarMakerInfo(maker);
			StringBuilder output = new StringBuilder();

			output.append("Car Country\tCar Maker\tModel\tCar_year\tPrice\tOption\n");
			SelectCarMakerInfoVO wscmiVO = null;

			for (int i = 0; i < list.size(); i++) {
				wscmiVO = list.get(i);
				output.append(wscmiVO.getCarCountry()).append("\t").append(wscmiVO.getCarMaker()).append("\t")
						.append(wscmiVO.getCarModel()).append("\t").append(wscmiVO.getCarYear()).append("\t")
						.append(wscmiVO.getPrice()).append("\t").append(wscmiVO.getCarOption()).append("\n");
			} // end for

			if (list.isEmpty()) {
				output.append("차량 제조사 정보가 없습니다.");
			}

			data = output.toString();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UseCarView().menu();
	}// main

	@Override
	public void actionPerformed(ActionEvent e) {

	}
	

}// class
package kr.co.kyhstudy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class DIDAO2 {
	
	public List<String> getList() throws SQLException{
		
		List<String> list = new ArrayList<String>();
		
		list.add("�ȳ�1");
		list.add("������1");
		list.add("������1");
		list.add("��������1");
		
		return list;
		
	}// getList

}// class

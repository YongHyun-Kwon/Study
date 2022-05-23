package kr.co.kyhstudy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DIDAO {
	
	public List<String> getList() throws SQLException{
		
		List<String> list = new ArrayList<String>();
		
		list.add("안녕");
		list.add("오늘은");
		list.add("수요일");
		list.add("포항항항");
		
		return list;
		
	}// getList

}// class

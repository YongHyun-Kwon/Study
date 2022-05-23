package kr.co.kyhstudy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class DIDAO2 {
	
	public List<String> getList() throws SQLException{
		
		List<String> list = new ArrayList<String>();
		
		list.add("안녕1");
		list.add("오늘은1");
		list.add("수요일1");
		list.add("포항항항1");
		
		return list;
		
	}// getList

}// class

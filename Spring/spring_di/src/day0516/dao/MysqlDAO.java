package day0516.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 약결합이 되기 위해서 DAO 인터페이스를 구현한다.
 * @author user
 */
public class MysqlDAO implements DAO {

	@Override
	public void insert(String name) throws SQLException {
		
		System.out.println("insert into mysql_tab(name) values('" + name + "')");
		
	}// insert

	@Override
	public List<String> select() throws SQLException {

		List<String> list = new ArrayList<String>();
		
		list.add("MySQL DBMS select");
		list.add("김예진");
		list.add("박설진");
		list.add("서지숙");
		list.add("김진영");
		
		return list;
		
	}// select

}// class

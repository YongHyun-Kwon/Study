package day0516.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ������� �Ǳ� ���ؼ� DAO �������̽��� �����Ѵ�.
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
		list.add("�迹��");
		list.add("�ڼ���");
		list.add("������");
		list.add("������");
		
		return list;
		
	}// select

}// class

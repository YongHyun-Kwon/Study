package com.jdbc.kyh.prepared.vo;

/**
 * �÷��� ������ ������ ������ VO
 * @author user
 */
public class ColumnVO {

	private String columnName, columnType;
	
	public ColumnVO() {
	}

	public ColumnVO(String columnName, String columnType) {
		this.columnName = columnName;
		this.columnType = columnType;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	
	
	
}
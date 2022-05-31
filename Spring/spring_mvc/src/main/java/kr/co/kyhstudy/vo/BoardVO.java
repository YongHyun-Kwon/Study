package kr.co.kyhstudy.vo;

import org.springframework.web.bind.annotation.RequestParam;

public class BoardVO {

	private int startNum, endNum, currentPage;// ���۹�ȣ, ����ȣ, ������������ȣ
	private String field, keyword;// �˻� �ʵ��, �˻�Ű����

	public BoardVO() {
		currentPage = 1;// DispatcherServlet�� subquery�� ��û�ϸ� VO��ü�� �����Ͽ� �Ҵ����ִµ�
		// ���� �������� 1�������� �Ǿ���ϹǷ� �����ڿ��� 1�� �־��ش�.
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(@RequestParam(defaultValue = "1") int currentPage) {
		this.currentPage = currentPage;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "BoardVO [startNum=" + startNum + ", endNum=" + endNum + ", currentPage=" + currentPage + ", field="
				+ field + ", keyword=" + keyword + "]";
	}

}

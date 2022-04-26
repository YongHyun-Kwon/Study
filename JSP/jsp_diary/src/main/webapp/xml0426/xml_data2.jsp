<%@page import="org.jdom2.output.Format"%>
<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%
String[] rssTitle = { "속보", "정치", "경제", "사회", "국제", "문화", "연예", "스포츠", "풀영상", "뉴스랭킹", "뉴스룸", "아침&amp;", "썰전 라이브",
		"정치부회의" };

// XML문서객체 생성
Document doc = new Document();
Element rootNode = new Element("rssTitle");
Element titleNode = null;
// 데이터를 사용하여 자식노드를 생성
for (String title : rssTitle) {
	titleNode = new Element("title");
	titleNode.setText(title);
	// 생성된 자식노드를 부모노드에 배치
	rootNode.addContent(titleNode);
} // end for
// 자식노드를 가진 부모노드를 XML문서객체 배치
doc.addContent(rootNode);
// XML 문서객체 출력
new XMLOutputter(Format.getPrettyFormat()).output(doc, out);
 %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="데이터 처리 페이지"
    %>
<%
// 데이터 처리
String[] names={"정인선","강산","권용현","황성준"}; // 데이터처리 결과
List<String> list = new ArrayList<String>();
list.add("request - HttpServletRequest( RequestFacade )");
list.add("response - HttpServletResponse( ResponseFacade )");
list.add("out - JspWriter");
list.add("session - HttpSession");
// 처리된 데이터를 view로 보내기 위해 scope 객체를 사용
request.setAttribute("names", names);
request.setAttribute("objects", list);
// 1. 이동할 페이지 설정
RequestDispatcher rd = request.getRequestDispatcher("forward_b.jsp");
// 2. 페이지 이동
rd.forward(request, response);
%>
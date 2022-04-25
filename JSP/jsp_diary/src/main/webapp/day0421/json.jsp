<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   trimDirectiveWhitespaces="true"
    %>
    <%
    String name = "권용현";
    String addr = "서울시 강남구 역삼동";
    int age = 25;
    boolean flag =false;
    
    
    // 1. JSONObject 생성
    JSONObject jsonObj = new JSONObject();
    // 2. 값 할당
    jsonObj.put("name", name);
    jsonObj.put("age", age);
    jsonObj.put("addr", addr);
    jsonObj.put("flag", flag);
    jsonObj.put("flag", true); // 같은 이름이 존재하면 기존의 키에 덮어 쓴다.
    %>
	<%= jsonObj.toJSONString() %>
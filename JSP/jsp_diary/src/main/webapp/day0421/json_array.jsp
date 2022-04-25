<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    info="JSON Array 사용"
    %>
 <%
 // 1.JSONArray 생성
 JSONArray ja = new JSONArray();
 
 // 2. JSONObject 생성
 JSONObject jOjb = new JSONObject();
 jOjb.put("name", "권용현");
 jOjb.put("age",20);
 JSONObject jOjb2 = new JSONObject();
 jOjb2.put("name", "전민정");
 jOjb2.put("age",23);
 JSONObject jOjb3 = new JSONObject();
 jOjb3.put("name", "강현모");
 jOjb3.put("age",21);
 
 // 3. JSONArray 추가
 ja.add(jOjb);
 ja.add(jOjb2);
 ja.add(jOjb3);
 %>
<%= ja.toJSONString() %>

<%@page import="kr.co.sist.dao.MemberDAO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

MemberDAO mDAO = MemberDAO.getInstance(); 

String id = request.getParameter("id");

boolean checkID = mDAO.selectId(id);

JSONObject jsonObj = new JSONObject();

jsonObj.put("flag", checkID);

out.println(jsonObj.toJSONString());



%>
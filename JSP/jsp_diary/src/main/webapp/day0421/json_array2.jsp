<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day0406.TestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>

<%
List<TestVO> list= new ArrayList<TestVO>();
list.add(new TestVO("권용현","서울시 강남구 역삼동",24));
list.add(new TestVO("전민정","서울시 강서구 발산동",23));
list.add(new TestVO("강현모","서울시 구로구 개봉동",25));
list.add(new TestVO("서지숙","서울시 동대문구 동대문동",22));


// 위의 리스트를 사용하여 JSONArray 생성 출력
// JSONArray는 name, addr, age 를 가진 JSONObject를 저장한다.
// 1. JSONArray 생성
JSONArray ja = new JSONArray();

// 2. JSONObject 선언
JSONObject jsonObj = null;

// 3. 데이터 만큼 반복시켜
for(TestVO tv : list){
	// JSONObject 생성
	jsonObj = new JSONObject();
	// 값 넣기
	jsonObj.put("name",tv.getName());
	jsonObj.put("addr",tv.getAddr());
	jsonObj.put("age",tv.getAge());
	// 4. JSONArray 할당
	ja.add(jsonObj);
}
%>
<%= ja.toJSONString() %>
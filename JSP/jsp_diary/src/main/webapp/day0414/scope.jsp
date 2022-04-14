<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="scope 사용"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css"
	href="http://localhost/jsp_prj/common/css/main_20220321.css" />
<style type="text/css">
</style>
<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function() {

	}); // ready
</script>
</head>
<body>
	<!-- 객체생성
page : 요청할 때 마다 객체를 생성하고 page 객체에 저장
request : 요청할 때 마다 객체를 생성하고 request 객체에 저장
session : 웹 브라우저마다 하나의 객체만 생성하고 session 객체에 저장
application : 최초접속자에 의해 하나의 객체만 생성하고 application객체에 저장
 -->
	<jsp:useBean id="cVO" class="day0414.CounterVO" scope="application" />
	<!-- setter method 호출 -->
	<jsp:setProperty property="cnt" name="cVO" value="1" />
	<!-- getter method 호출 -->
	당신은 이 페이지에
	<strong> <jsp:getProperty property="cnt" name="cVO" />
	</strong>번째 방분자 입니다.
	<br />

	<%
// id는 객체명으로 변환되므로 JSP code에서 사용할 수 있다.
// cVO.setCnt(1);
%>
	당신은 이 페이지에
	<strong> <%= cVO.getCnt() %>
	</strong>번째 방분자 입니다.
	<br />
	<span title="<%= cVO.getCnt() %>"> 
<%
String cnt = String.valueOf(cVO.getCnt());
char num=' ';
for(int i =0; i < cnt.length(); i++){
	num = cnt.charAt(i);
%>
 <img src="images/num_<%=num%>.png" /> 
 <% } %>
</span>
</body>
</html>
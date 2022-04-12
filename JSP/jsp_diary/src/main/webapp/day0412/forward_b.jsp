<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="처리된 데이터를 받아서 보여주는 일"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.135/jsp_prj/common/css/main_20220321.css"/>
<style type="text/css">

</style>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function() {
	
}); // ready
</script>
</head>
<body>
<img src="../common/images/daum_logo.png"/>
<br/>
<%
	// 이전 페이지에서 처리된 데이터 받기
	String[] names = (String[])request.getAttribute("names");
	List<String> list = (List<String>)request.getAttribute("objects");
	
	if(names == null){ // 처리된 데이터가 없음 
		// 1. 데이터를 처리하는 페이지에 문제 발생, 2.forward_b.jsp를 직접 호출
		response.sendRedirect("forward_a.jsp");
		return;
		
	}

	for(String name : names){
	%>
	<input type="radio" value="<%= name %>" name="name"/><%= name %>
	<%	
	} // end for
%>
<br/>
<table class="table">
	<tr>	
		<th style="width : 50px">번호</th>
		<th style="width : 400px">내장객체</th>
	</tr>
<%
	for(int i = 0; i < list.size(); i++) {
%>
<tr>
	<td><%= i+1 %></td>
	<td><%= list.get(i) %></td>
</tr>
<%		
	}
%>
</table>
</body>
</html>
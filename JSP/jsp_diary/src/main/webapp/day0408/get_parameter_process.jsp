<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/jsp_prj/common/css/main_20220321.css"/>
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
<%
 // POST방식인 경우 한글이 깨지므로 한글처리 수행.
 request.setCharacterEncoding("UTF-8");

 // web parameter 값 받기 (이름이 유일)
 // name 속성의 이름과 getParameter("이름")이 같아야한다.
 String text = request.getParameter("text"); // name = "text"
 String pass = request.getParameter("password"); // name = "password"
 String hid = request.getParameter("hid"); // name="hid"
 String date = request.getParameter("date"); // name="date" HTML5에서 추가된 Form Control
 String file = request.getParameter("file"); // name="file"
 String ta = request.getParameter("ta"); // name="ta" textarea
 String gender = request.getParameter("gender"); // name="gender" radio는 선택된 값 하나만 넘어온다
 String domain = request.getParameter("domain"); // name="domain" <select>
 String flag = request.getParameter("flag"); // name="flag"
 // checkbox는 checked되었을 때 value가 존재하면 value 값이 얻어온다.
 // value가 존재하지 않으면 "on"이 넘어온다.
%>
<ul>
	<li>요청방식 :<strong><%= request.getMethod() %></strong></li>
	<li>text :<strong><%= text %></strong></li>
	<li>password :<strong><%= pass %></strong></li>
	<li>hidden :<strong><%= hid %></strong></li>
	<li>date :<strong><%= date %></strong></li>
	<li>file :<strong><%= file %></strong></li>
	<li>ta :<strong><%= ta.replaceAll("\n", "<br/>") %></strong></li>
	<li><textarea style="width: 400px; height: 100px"><%= ta %></textarea></li>
	<li>radio :<strong><%= gender %></strong></li>
	<li>domain :<strong><%= domain %></strong></li>
	<li>flag :<strong><%= flag %></strong></li>
</ul>
<hr/>
<ul>
	<li>요청방식 :<strong><%= request.getMethod() %></strong></li>
	<li>text :<strong><%= text %></strong></li>
	<li>password :<strong><%= pass %></strong></li>
	<li>hidden :<strong><%= hid %></strong></li>
	<li>date :<strong><%= date %></strong></li>
	<li>file :<strong><%= file %></strong></li>
	<li>ta :<strong><%= ta.replaceAll("\n", "<br/>") %></strong></li>
	<li><textarea style="width: 400px; height: 100px"><%= ta %></textarea></li>
	<li>radio :<strong><%= gender %></strong></li>
	<li>domain :<strong><%= domain %></strong></li>
	<li>flag :<strong><%= flag %></strong></li>
</ul>
</body>
</html>
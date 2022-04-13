<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="세션에서 존재하는 값 삭제"
    %>
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

<%
	// 이전페이지에서 사용된 값을 이동한 페이지에서는 사용할 수 없다
	// 세션을 사용하여 세션에 저장된 값을 얻는다.
	String name = (String)session.getAttribute("user_name");
	String age = (String)session.getAttribute("user_age");
	String ip = (String)session.getAttribute("user_ip");
%>
<%-- <strong>값 삭제 전</strong><br/>
<%= name %><br/>
<%= age %><br/>
<%= ip %><br/> --%>
<% 
	// 세션에 값 삭제 - 브라우저에 할당된 세션은 존재하고 값만 삭제
	session.removeAttribute("user_name");
	session.removeAttribute("user_ip");
	
	// 브라우저에 할당된 세션 자체를 무효화
	session.invalidate();
	// 값 얻기 : 무효화 된 후에는 값을 얻을 수 없다.
	//name = (String)session.getAttribute("user_name");
	//age = (String)session.getAttribute("user_age");
	//ip = (String)session.getAttribute("user_ip");
	//response.sendRedirect("http://localhost/jsp_prj/day0413/use_session_a.jsp");
%>
<%-- <strong>값 삭제 후</strong><br/>
<%= name %><br/>
<%= age %><br/>
<%= ip %><br/> --%>
<script type="text/javascript">
$(function() {
	alert("로그아웃");
	<%
		// JSP는 HTML보다 먼저 실행된다.
		//response.sendRedirect("http://localhost/jsp_prj/day0413/use_session_a.jsp");
	%>
	location.href="http://localhost/jsp_prj/day0413/use_session_a.jsp"
}); // ready
</script>
</head>
<body>
</body>
</html>
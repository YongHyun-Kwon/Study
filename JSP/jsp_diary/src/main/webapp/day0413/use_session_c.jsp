<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="이전페이지에서 사용한 값을 사용할 페이지-세션에서 값을 얻는다."
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
<script type="text/javascript">
$(function() {
	
}); // ready
</script>
</head>
<body>
<%
	// 이전페이지에서 사용된 값을 이동한 페이지에서는 사용할 수 없다
	// 세션을 사용하여 세션에 저장된 값을 얻는다.
	String name = (String)session.getAttribute("user_name");
	if(name == null){ 
		// 세션에서 얻은 값이 없을 때.
		// 1. 직접 요청했을 때( 개발자가 의도한 요청의 순서가 아닐 때 )
		// 2. session이 사라졌을 때( 개발자가 의도한 요청의 순서였지만 데이터의 유지시간을 초과했을 때)
		response.sendRedirect("use_session_a.jsp");
		return;
	}
	
%>
<%= name %> 님 안녕하세요?<br/>
이동한 작업 페이지에서 이전페이지의 값을 사용할 수 있다.<br/>
<a href="use_session_d.jsp">값 삭제</a>


</body>
</html>
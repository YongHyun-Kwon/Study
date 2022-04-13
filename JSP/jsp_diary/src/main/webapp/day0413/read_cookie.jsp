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
	//쿠키 읽기
	Cookie[] cookies = request.getCookies();
	
	Cookie cookie = null;
	String cookieName = "";
	String cookieValue = "";
	if(cookies!=null){ // 읽어들인 쿠키가 존재하면
	for(int i = 0; i < cookies.length; i++){
		cookie = cookies[i];
		// 쿠키이름 얻기
		cookieName = cookie.getName();
		// 쿠키 값 얻기
		cookieValue = cookie.getValue();
		//if("JSESSIONID".equals(cookieName)){
%>
쿠키명 : <%= cookieName %><br/>
쿠키값 : <%= cookieValue %><br/>
<%
		//}
		} // end for
	%>
	<a href="remove_cookie.jsp">쿠키 삭제</a>
	<%
	} else {
		%>
	<a href="add_cookie.jsp">쿠키 추가</a>	
<%		
	}
%>
<div>
</div>
</body>
</html>
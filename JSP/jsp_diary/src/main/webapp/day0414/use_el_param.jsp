<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="파라메터사용"
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
<!-- 링크를 눌렀을 때 nick에는 test가 age에는 25가 현재 페이지로 전송되는 링크 태그를 작성. -->
<a href="use_el_param.jsp?nick=test&age=25">클릭</a>
<form action="use_el_param.jsp">
<input type="hidden" name="nick" value="hidtest"/>
<input type="hidden" name="age" value="260"/>
<input type="hidden" name="name" value="AA"/>
<input type="hidden" name="name" value="BB"/>
<input type="submit" value="클릭"/>
</form>
<div>
<!-- EL은 null을 출력하지 않는다. -->
	EL 닉 : <strong>${ param.nick }</strong><br/>
	나이 : <strong>${ param.age }</strong><br/>
	이름 : <strong>${ param.name }</strong><br/>
	이름 : <strong>${ paramValues.name[0] }</strong><br/>
	이름 : <strong>${ paramValues.name[1] }</strong><br/>
	
	Expression 닉 : <strong><%= request.getParameter("nick") %></strong><br/>
	나이 : <strong><%= request.getParameter("age") %></strong><br/>
</div>
입력 값 : ${param.flag }
<span style="color:#FF0000">${ empty param.flag?"아래 링크": "" }</span>
<br/>
<a href="use_el_param.jsp?flag=true">클릭</a>
</body>
</html>
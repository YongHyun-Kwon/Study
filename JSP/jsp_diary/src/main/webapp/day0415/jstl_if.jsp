<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="JSTL if 사용"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
// 입력된 id가 admin이라면 경고창으로 "관리자 로그인"을 보여준다.		
<c:if test="${param.id eq 'admin'}">
alert("관리자 로그인");
</c:if>
$(function() {	
	$("#btn").click(function(){
		$("#frm").submit();
	})
}); // ready
</script>
</head>
<body>
<c:if test="false">
안녕하세요?
</c:if>
<!-- form태그에 action속성을 생략하면 submit되었을 때 자신페이지로 요청을 보낸다. -->
<form name="frm" id="frm">
<label>아이디</label>
<input type="text" id="id" name="id" class="inputBox"/>
<input type="button" value="입력" id="btn" class="localBtn"/>
</form>
<!-- 입력된 아이디를 출력한다. 만약에 입력된 id가 admin일 경우에는
<button type="button" class="btn btn-primary">
관리자 <span class="badge bg-secondary">4</span>
</button>
을 보여주고 아이디를 출력
 -->
 <c:if test="${not empty param.id }">
 <c:if test="${param.id eq 'admin' }">
 <button type="button" class="btn btn-primary">
관리자 <span class="badge bg-secondary">4</span>
</button>
</c:if>
<c:out value="${ param.id }"/>
</c:if>
</body>
</html>
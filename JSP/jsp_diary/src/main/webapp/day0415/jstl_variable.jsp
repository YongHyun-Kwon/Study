<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="JSTL 변수의 사용"
    %>
<!-- JSTL을 사용할려면 taglib 지시자를 선언해야한다. -->
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
$(function() {
	
}); // ready
</script>
</head>
<body>
<!-- 변수의 선언 -->
<c:set var="msg" value="오늘은 금요일!"/>
<c:set var="day" value="15"/>
<!-- 출력 : 입력값을 그대로 출력한다.-->
<c:out value="msg"/><br/>
<c:out value="day"/><br/>
<!-- 출력 : 변수의 값을 출력할려면 EL이나 Expression을 사용한다. -->
<c:out value="${ msg }"/><br/>
<c:out value="${ day }"/><br/>

<!-- 같은 이름의 변수를 여러개 선언 : 이전의 값이 사라진다. -->
<c:set var="name" value="오늘은 <strong>금요일</strong>입니다."/>
HTML Tag해석하지 않음<c:out value="${ msg }"/><br/>
EL 직접 사용 : ${ msg }<br/>
escapeXml속성 사용 : <c:out value="${ msg }" escapeXml="false"/><br/>

<!-- 변수삭제 : 삭제된 변수는 출력되지 않는다.-->
<c:remove var="msg"/>
msg : <c:out value="${ msg }"/><br/>
day : <c:out value="${ day }"/><br/>

</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="forEach를 사용한 배열, List방의 값 출력"
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
$(function() {
	$("#btn").click(function() {
		$("#frm").submit();
	})
}); // ready
</script>
</head>
<body>
<%
String[] names={"강산","전민정","정인선","권용현",};
List<String> subject= new ArrayList<String>();
subject.add("JSP Tag");
subject.add("JSP 내장객체");
subject.add("액션태그");
subject.add("EL");
subject.add("JSTL");

//scope객체에 저장
pageContext.setAttribute("names", names);
request.setAttribute("subjects", subject);
%>
<ul>
<li>배열반복</li>
<c:forEach var="name" items="${names }">
<li><c:out value="${name}"/></li>
</c:forEach>
</ul>
<ul>
<li>리스트반복</li>
<c:forEach var="sub" items="${subjects }">
<li><c:out value="${sub}"/></li>
</c:forEach>
</ul>
<form action="jstl_for_each2.jsp" id="frm">
<c:forEach var="name" items="${names }">
<input type="checkbox" value="${name }" name="name"/><c:out value="${name }"/>
</c:forEach>
<br/>
<input type="button" value="전송" class="btn btn-info" id="btn">
</form>
<!-- 전송버튼이 클릭되면 선택된 체크박스의 값을 모두 출력.
체크박스가 선택되지 않았다면 "선택한 이름 없음"을 출력 -->
<c:choose>
<c:when test="${ not empty param.name }">
<c:forEach var="name" items="${paramValues.name }" >
	<c:out value="${ name }"/>
</c:forEach>
</c:when>
<c:otherwise>
선택한 이름이 없습니다.
</c:otherwise>
</c:choose>
<!-- scope객체에 저장된 subjects를 table로 출력 -->
<table>
	<tr>
		<th>번호</th><th>세부과목명</th>
	</tr>
	<c:forEach var="subject" items="${subjects }">
	<c:set var="i" value="${i+1 }"/>
	<tr>
		<td><c:out value="${ i }"/></td>
		<td><c:out value="${ subject }"/></td>
	</tr>
	</c:forEach>
	<%-- <c:forEach var="subject" varStatus="cnt" items="${subjects }">
	<tr>
		<td>${ cnt.index }</td>
		<td>${ subject }</td>
	</tr>
	</c:forEach> --%>
	
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/spring_mvc/common/css/main_20220321.css"/>
<style type="text/css">
.car_img{ width: 80px; height: 60px;}
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
	
	$("#btnCarSearch").click(function() {
		
		chkNull();
		
	});// click

	$("#keyword").keydown(function( evt ) {
		if(evt.which == 13){
			chkNull();
		}// end if
	});// click
	
}); // ready

function chkNull() {
	
	if($("#keyword").val() == "") {
			alert("검색키워드를 입력해주세요");
		$("#keyword").focus();
		return;
	}// end if
	
	$("#carSearchFrm").submit();
	
}// chkNull
</script>
</head>
<body>
<!-- <form action="http://localhost/spring_mvc/mybatis/day0525/likeFrmProcess.do" method="get">
<label>옵션 차량 조회</label>
<input type="text" name="option" class="inputBox"/>
<input type="submit" value="전송" class="btn btn-success"/>
</form> -->



<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>이미지</th>
			<th>차량명</th>
			<th>연식</th>
			<th>옵션</th>
			<th>가격</th>
			<th>입력일</th> 
		</tr>
	</thead>
	<tbody>
		<c:if test="${ empty carList }">
			<tr>
			</tr>
			<td colspan="7" style="width: 100%; text-align: center;">
				검색하신 [<c:out value="${ param.keyword }"/>] 차량이 존재하지 않습니다. <br/>
			<img src="http://localhost/spring_mvc/common/images/error.jpg" width="250"/><br/>
			</td>
		</c:if>
		<c:if test="${ not empty carList }">
		<c:forEach var="carData" varStatus="" items="${ carList }">
		<c:set var="i" value="${ i + 1 }"/>
		<tr>
			<td><c:out value="${ i }"/></td>
			<td><img src="http://localhost/spring_mvc/common/car_img/${ carData.car_img }" class="car_img"> </td>
			<td><c:out value="${ carData.model }"/></td>
			<td><c:out value="${ carData.car_year }"/></td>
			<td><c:out value="${ carData.car_option }"/></td>
			<td><c:out value="${ carData.price }"/></td>
			<td><c:out value="${ carData.hiredate }"/></td>
		</tr>
		</c:forEach>
		</c:if>	
	</tbody>
	
</table>
<div id="pageNation" style="text-align: center">
<%
	String field = request.getParameter("field");
	String keyword = request.getParameter("keyword");
%>
	<c:forEach var="i" end="${ pageCnt }" step="1" begin="1">
		[ <a href="http://localhost/spring_mvc/mybatis/day0525/subquery.do?currentPage=${ i }<%= !"".equals(keyword) && keyword != null ?"&field="+field+"&keyword="+keyword:"" %>"><c:out value="${ i }"/></a> ]
	</c:forEach>
</div>
<div id="searchCar" style="text-align: center; margin-top: 20px;">
	<form action="http://localhost/spring_mvc/mybatis/day0525/subquery.do" id="carSearchFrm" method="get">
		<select name="field" class="inputBox">
			<option value="1">모델명</option>
			<option value="2">옵션</option>
		</select>
	 <input type="text" id="keyword" name="keyword" class="inputBox" style="width: 180px"/>
	 <input type="text" style="display: none;"/><!-- 키입력 HTML Form Control이 하나 였을 때 엔터 키가 눌렸을 때 전송을 막기 위해-->
	 <input type="button" value="검색" id="btnCarSearch" class="btn btn-info"/>
	</form>
</div>

<a href="http://localhost/spring_mvc/mybatis/mybatis_index.do">메뉴</a>
</body>
</html>
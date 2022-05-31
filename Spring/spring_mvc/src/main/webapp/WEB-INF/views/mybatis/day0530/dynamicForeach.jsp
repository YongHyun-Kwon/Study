<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/spring_mvc/common/css/main_20220321.css"/>
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
		
		if($("#empno").val() == ""){
			$("#empno").val(0);
		}// end if
		
		if($("#deptno").val() == ""){
			$("#deptno").val(0);
		}// end if
		
		$("#frm").submit();
		
	});// click

}); // ready
</script>
</head>
<body>
<form id="frm" action="http://localhost/spring_mvc/mybatis/day0530/dynamicForeach.do" method="get">
<label>입력</label>
부서번호<input type="text" id="deptno" name="deptno" class="inputBox"/><br/>
직무<input type="checkbox" name="job" value="SALESMAN"/>SALESMAN
<input type="checkbox" name="job" value="ANALYST"/>ANALYST
<input type="checkbox" name="job" value="CLERK"/>CLERK
<input type="checkbox" name="job" value="MANAGER"/>MANAGER
<input type="checkbox" name="job" value="PRESIDENT"/>PRESIDENT<br/>
<input type="button" value="전송" id="btn" class="btn btn-success"/>
</form>
<strong>검색결과</strong>
<c:if test="${ not empty param.deptno }">
검색 부서  : <strong><c:out value="${ param.deptno }"/></strong><br/>
검색 직무 : 
<c:if test="${ empty param.job }">
 모든 직무
</c:if>
<c:forEach var="job" items="${ paramValues.job }">
	<c:out value="${ job }"/>
</c:forEach>
</c:if>
<table class="table table-hover">
	<thead>
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>부서번호</th>
			<th>연봉</th>
			<th>보너스</th>
			<th>직무</th>
			<th>입사일</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${ empty empList and not empty param.deptno }">
			<tr>
				<td colspan="5">
					사원을 검색할 수 없습니다.<br/>
					<img src="http://localhost/spring_mvc/common/images/error.jpg" width="250"/><br/>
				</td>
			</tr>
		</c:if>
		<c:if test="${ not empty empList  }">
			<c:forEach var="empData" items="${ empList }">
				<tr>
					<td><c:out value="${ empData.empno }"/></td>
					<td><c:out value="${ empData.ename }"/></td>
					<td><c:out value="${ param.deptno }"/></td>
					<td><c:out value="${ empData.sal }"/></td>
					<td><c:out value="${ empData.comm }"/></td>
					<td><c:out value="${ empData.job }"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ empData.hireDate }"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<a href="http://localhost/spring_mvc/mybatis/mybatis_index.do">메뉴</a>
</body>
</html>
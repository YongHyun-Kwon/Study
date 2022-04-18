<%@page import="day0418.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="day0418.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.135/jsp_prj/common/css/main_20220321.css"/>
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
 <c:catch var="e">
 <% 
 
 EmpDAO empDAO = new EmpDAO();
 
 List<EmpVO> list = empDAO.selectAllEmp();
 
 pageContext.setAttribute("empList", list);
 
 %>
 <table class="table table-success table-striped">
 <thead>
 
 </thead>
 <tr>
 <th>사원번호</th>
 <th>사원이름</th>
 <th>연봉</th>
 <th>직무</th>
 <th>입사일</th>
 </tr>
 <tbody>
 <c:forEach items="${ empList }" var="emp">
 <tr>
 	<td><c:out value="${ emp.empno }"/></td>
 	<td><c:out value="${ emp.ename }"/></td>
 	<td><c:out value="${ emp.sal }"/></td>
 	<td><c:out value="${ emp.job }"/></td>
 	<td><fmt:formatDate value="${ emp.hiredate }" pattern="MM-dd-yyyy"/></td>
 </tr>
 </c:forEach>
</tbody>
</table> 
 </c:catch>

<c:if test="${ not empty e }">
Error
</c:if>
</body>
</html>
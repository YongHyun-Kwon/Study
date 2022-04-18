<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="JSTL fmt 사용"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<c:set var="i" value="2022"/>

0패턴 사용 : <fmt:formatNumber value="${ i }" pattern="0,000,000"/><br/>
#패턴 사용 : <fmt:formatNumber value="${ i }" pattern="#,###,###"/><br/>
0패턴 사용 : <fmt:formatNumber value="${ i }" pattern="0,000,000.00"/><br/>
#패턴 사용 : <fmt:formatNumber value="${ i }" pattern="#,###,###.##"/><br/>

<%
	// list에 1000 ~ 10000까지 1000씩 증가하도록 값을 추가
	// 3자리마다 ,를 넣어 데이터가 존재하는 것 까지만 출력
	List<Integer> numList = new ArrayList<Integer>();

	for(int i = 1000; i < 10001; i += 1000){
			numList.add(i);
	} // end for
	
	pageContext.setAttribute("numList", numList );
%>

<c:forEach items="${ numList }" var="nums">
	<fmt:formatNumber value="${ nums }" pattern="#,###"/>
</c:forEach>

</body>
</html>
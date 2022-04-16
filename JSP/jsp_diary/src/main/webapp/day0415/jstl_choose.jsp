<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="여러개의 조건을 비교할 때"
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
	$("#blood").change(function(){
		$("#frm").submit()
	})
	
	$("#btnScore").click(function(){
		$("#frm2").submit();
	})
}); // ready
</script>
</head>
<body>
<form action="jstl_choose.jsp" id="frm">
<label>혈액형 선택</label>
<select name="blood" id="blood">
	<option value="none"${param.blood eq 'none'?" selected='selected'":"" }>--모름--</option>
	<option value="a"${param.blood eq 'a'?" selected='selected'":"" }>A</option>
	<option value="b"${param.blood eq 'b'?" selected='selected'":"" }>B</option>
	<option value="ab"${param.blood eq 'ab'?" selected='selected'":"" }>AB</option>
	<option value="o"${param.blood eq 'o'?" selected='selected'":"" }>O</option>
</select>
</form>
<c:choose>
<c:when test="${param.blood eq 'a' }">
<img src="images/blood_a.PNG"/>
</c:when>
<c:when test="${param.blood eq 'b' }">
<img src="images/blood_b.PNG"/>
</c:when>
<c:when test="${param.blood eq 'ab' }">
<img src="images/blood_ab.PNG"/>
</c:when>
<c:when test="${param.blood eq 'o' }">
<img src="images/blood_o.PNG"/>
</c:when>
<c:otherwise>
<img src="images/default.PNG"/>
</c:otherwise>
</c:choose>

<div>
<form action="jstl_choose.jsp" id="frm2">
<label>점수</label>
<input type="text" name="score" class="inputBox"/>
<input type="button" value="입력" id="btnScore" class="btn btn-info"/>
</form>
</div>
<!-- 점수가 0~100사 일 때만 
	choose를 사용하여 입력된 점수의 학점 출력
	90~100 : A
	80~89 : B
	70~79 : C
	60~ 69 : D
	0~59 : F
	 -->
<c:set var="score" value="${ param.score }"/>
<c:if test="${score ge 0 and score le 100 }">
<c:choose>
<c:when test="${score gt 89 and score lt 101  }">
	학점 : A
</c:when>
<c:when test="${score gt 79 and score lt 90  }">
	학점 : B
</c:when>
<c:when test="${score gt 69 and score lt 80  }">
	학점 : C
</c:when>
<c:when test="${score gt 59 and score lt 70  }">
	학점 : D
</c:when>
<c:otherwise>
	학점 : F
</c:otherwise>
</c:choose>
</c:if>
</body>
</html>
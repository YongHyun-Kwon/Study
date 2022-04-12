<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="배열로 처리하는 HTML Form Control"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.135/jsp_prj/common/css/main_20220321.css"/>
<style type="text/css">
div{ width: 400px; height: 200px; float: left; border: 1px solid #333; }
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
	$("#btnGet").click(function() {
		// 유효성 검증 수행 한 후	
		$("#getFrm").submit();
	})
	
	$("#btnPost").click(function() {
		// 유효성 검증 수행 한 후	
		$("#postFrm").submit();
	})
	
	
}); // ready
</script>
</head>
<body>
<div>
<strong>GET	방식으로요청</strong>

<form id="getFrm" action="form_arr_process.jsp" method="get"><!-- submit이 되었을 때 form_arr_process.jsp로 -->
<label>이름</label>
<input type="text" name="name" class="inputBox"><br/>
<label>관심언어</label>
<input type="checkbox" name="lang" value="java">자바
<input type="checkbox" name="lang" value="c/c++">C/C++
<input type="checkbox" name="lang" value="HTML">HTML<br/>
<input type="checkbox" name="lang" value="CSS">CSS
<input type="checkbox" name="lang" value="자바스크립트">자바스크립트
<input type="checkbox" name="lang" value="파이썬">파이썬<br/>
<input type="button" value="GET방식전송" class="btn btn-success" id="btnGet"/>
</form>
</div>
<div>
<strong>POST 방식으로요청</strong>

<form id="postFrm" action="form_arr_process.jsp" method="post"><!-- submit이 되었을 때 form_arr_process.jsp로 -->
<label>이름</label>
<input type="text" name="name" class="inputBox"><br/>
<label>관심언어</label>
<input type="checkbox" name="lang" value="java">자바
<input type="checkbox" name="lang" value="c/c++">C/C++
<input type="checkbox" name="lang" value="HTML">HTML<br/>
<input type="checkbox" name="lang" value="CSS">CSS
<input type="checkbox" name="lang" value="자바스크립트">자바스크립트
<input type="checkbox" name="lang" value="파이썬">파이썬<br/>
<input type="button" value="POST방식전송" class="btn btn-success" id="btnPost"/>
</form>
</div>

</body>
</html>
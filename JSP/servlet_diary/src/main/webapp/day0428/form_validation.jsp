<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$("#name").keydown(function(evt) {
		if(evt.which== 13){
			chkNull();
		} // end if
	})//keydown
	
	$("#btn").click(function(evt) {
			chkNull();
	})//click
	
}); // ready

function chkNull(){
	var name=$("#name").val();
	if(name == ""){
		alert("이름은 필수 입력!!");
	$("#name").focus();
		return;
	}// end if
	$("#frm").submit();
}
</script>
</head>
<body>
<!-- 사용자화면에 키입력이 가능한 HTML Form Control이 하나라면 자바스크립트의
유효성 검증이 실패 하더라도 Back-end로 전송이 된다. -->
<form id="frm" action="http://localhost/servlet_prj/form_process" method="get">
<label>입력</label><input type="text" name="name" id="name" class="inputBox"/>
<input type="text" style="width: 0px; display: none"/>
<input type="button" value="클릭" id="btn" class="btn btn-info"/>
</form>
</body>
</html>
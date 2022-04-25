<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.130/jsp_prj/common/css/main_20220321.css">
<style type="text/css">
#idResult{ color: #FF0000 }
</style>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript">
$(function(){
	
	$("#id").keyup(function() {
	var idDupFlag = false; // 아이디 중복확인 후 사용가능
		
		if($("#id").val().length > 3){
			
		$.ajax({
			url:"http://localhost/jsp_prj/day0422/memeber_form_process.jsp",
			data: { "id" : $("#id").val()},
			type:"get",
			dataType:"json",
			error:function( xhr ){
				alert( xhr.status)
			},success:function( jsonObj ){
				
				var flag = jsonObj.flag
				 if(flag){
					$("#idResult").html("사용불가능한 아이디 입니다.");
					return;
				 }
					$("#idResult").html("사용 가능한 아이디 입니다");
					idDupFlag = true;
			},
			
		}) // ajax
		}
	}) // keyup
	
	$("#btn").click(function() {
		chkNull();
	})
	
	function chkNull(){
		if(!idDupFlag){
			alert("아이디 중복확인이 필요합니다. 다시 입력해주세요.")
			return;
		}
	}
});//ready
</script>
</head>
<body>
<!-- 입력한 아이디가 사용가능한지 아닌지를 키가 눌릴때마다 체크하여 idResult에 사용가능 또는 사용불가를 출력 -->
<label>아이디</label>
<input type="text" name="id" id="id" class="inputBox"/><span id="idResult"></span><br/>
<label>비밀번호</label>
<input type="password" name="passwd" class="inputBox"/><br/>
<input type="button" value="입력" class="btn btn-success" id="btn"/><br/>
</body>
</html>
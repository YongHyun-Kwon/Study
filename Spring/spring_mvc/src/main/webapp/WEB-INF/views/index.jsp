<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.135/spring_mvc/common/css/main_20220321.css"/>
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
	$("#btnPost").click(function() {
		$("#frm").submit();
	})
}); // ready

function sendFrm( flag ){
	// <form>에 action을 변경할 수 있다.
	// document.폼이름.action="GET|POST"
	
	var method="GET";
	if( flag == 1 ){
		method="POST";
	}// end if
	
	document.frm.method=method;
	// 설정된 전송방식을 사용하여 back-end로 요청
	document.frm.submit();

}

function sendReq() {
	
	$.ajax({
		url:"day0513/ajax.do",
		type:"get",
		dataType:"json",
		error:function(xhr){
			alert(xhr.status + "/" + xhr.statusText);
		},
		success:function(json){
			
			//alert(json.pubDate);
			
			let output = "";
			output += "생산일 : " + json.pubDate + "<br/>"
			output += "데이터 건 수 : " + json.lang + "<br/>"
			for(var i = 0; i < json.data.length; i++){
				output += " : " + json.data[i].name + "<br/>"
			}
			
			$("#view").html(output);
		},
		
	});// ajax
	
}// sendReq

function sendReq1() {
	
	$.ajax({
		url:"day0516/ajax.do",
		type:"get",
		dataType:"json",
		async: false,
		error:function(xhr){
			alert(xhr.status + "/" + xhr.statusText);
		},
		success:function(json){
			
			//alert(json.pubDate);
			
			let output = "@ResponseBody 사용<br/>";
			output += "생산일 : " + json.pubDate + "<br/>"
			output += "데이터 건 수 : " + json.lang + "<br/>"
			output += "<ul>"
			for(var i = 0; i < json.data.length; i++){
				output += "<li>" + json.data[i].name + "</li>"
			}// end for
			
			output +="</ul>"
			
			$("#view").html(output);
		},
		
	});// ajax
	
}// sendReq1

</script>
</head>
<body>
<div>
<ul>
	<li><a href="get.do">GET 요청</a></li>
	<li>
		<form action="post.do" id="frm" method="post">
			<input type="button" value="post요청" id="btnPost" class="btn btn-success"/>
		</form>
	</li>
	<li>
		<form action="multi.do" id="frm" method="get">
			<input type="submit" value="GET요청" class="btn btn-info"/>
		</form>
		<form action="multi.do" id="frm" method="post">
			<input type="submit" value="POST요청" class="btn btn-warning"/>
		</form>
	</li>
	<li>
		[다른 URL로 같은 method 호출<a href="a.do">a.do 요청</a> |
		 <a href="b.do">b.do 요청</a> | <a href="c.do">c.do 요청</a> }
	</li>
	<li>
		응답페이지 처리 : 요청명과 jsp명이 같을 때<br/>
		<a href="void_return.do">요청</a>
	</li>
	<li>응답페이지 처리( views의 하위폴더 )
		<a href="sub_result.do">요청</a>
	</li>
	<li><a href="request_info.do">접속자정보 받기</a></li>
	
	<li>
		Web Parameter 처리( HttpServletRequest )
		<a href="use_request.do?name=test&age=20&lang=java&lang=c/c%2B%2B&lang=Python">요청</a>
	</li>
	<li>
		Web Parameter 처리( 단일형 )
		<a href="single_param.do?name=test&age=20&lang=java&lang=c/c%2B%2B&lang=Python">요청</a>
	</li>
	<li>
		Web Parameter 처리( VO )
		<a href="vo_param.do?name=test&age=20&lang=java&lang=c/c%2B%2B&lang=Python">요청</a>
	</li>
	<li>
		web parameter 처리
		<form action="vo_param.do" name="frm">
		<label>이름</label><input type="text" name="name" class="inputBox"><br/>
		<label>나이</label><input type="text" name="age" class="inputBox"><br/>
		<label>관심언어</label><br/>
		<input type="checkbox" name="lang" value="자바"/>자바<br/>
		<input type="checkbox" name="lang" value="자바스크립트"/>자바스크립트<br/>
		<input type="checkbox" name="lang" value="파이썬"/>파이썬<br/>
		<input type="checkbox" name="lang" value="C"/>C<br/>
		<input type="button" value="GET 전송" onclick="sendFrm(0)" class="btn btn-info"/>
		<input type="button" value="POST 전송" onclick="sendFrm(1)" class="btn btn-info"/>
		</form>	
	</li>
	<li>view로 데이터 전송(HttpServletRequest사용)
	  <a href="day0512/use_request.do">요청</a>
	</li>
	<li>
		view로 데이터 전송(Model사용)
		<a href="day0512/use_model.do">요청</a>
	</li>
	<li>
		view로 데이터 전송(ModelAndView사용)
		<a href="day0512/use_model_and_view.do">요청</a>
	</li>
	<li>
		redirect 이동
		<a href="day0512/do_move.do">do요청(Controller)</a>
	</li>
	<li>
		redirect 이동
		<a href="day0512/jsp_move.do">jsp요청(직접요청)</a>
	</li>
	<li>
		forward 이동
		<a href="day0512/forward_a.do">do요청(Controller 직접요청)</a>
	</li>
	<li>
		forward 이동
		<a href="day0512/forward_b.do">do요청</a>
	</li>
	
	<li>
		include 이동
		<a href="day0512/include_views.do">WEB-INF/views</a>
	</li>

	<li>
		include 이동
		<a href="day0512/include_webapp.do">do</a>
	</li>
	
	<li>
		HttpSession 사용
		<a href="day0512/session.do">do</a>
	</li>
	
	<li>
		HttpSession 사용
		<a href="day0513/set_session.do">@SessionAttribute 값 설정</a>
	</li>
	
	<li>
		HttpSession 사용
		<a href="day0513/get_session.do">@SessionAttribute 값 얻기</a>
	</li>
	
	<li>
		HttpSession 사용
		<a href="day0513/remove_session.do">@SessionAttribute 삭제</a>
	</li>
	<li>
		Cookie 사용
		<a href="day0513/add_cookie.do">쿠키 심기</a>
	</li>
	
	<li>
		Cookie 사용
		<a href="day0513/get_cookie.do">쿠키 읽기</a>
	</li>

	<li>
		Cookie 사용
		<a href="day0513/remove_cookie.do">쿠키 삭제</a>
	</li>
	<li>
		AJAX
		<a href="#void" onclick="sendReq()">요청</a>
		<div id="view"></div>
	</li>
	<li>
		AJAX @ResponseBody 사용
		<a href="#void" onclick="sendReq1()">요청</a>
		<div id="view1"></div>
	</li>
	<li>
		@ExceptionHandler를 사용한 예외처리
		<a href="day0516/use_exception.do">요청</a>
	</li>
	<li>
		<a href="day0518/di.do">DI도입</a>
	</li>
	<li>
		<a href="day0518/di2.do">DI도입(annotation)</a>
	</li>
	<li>
		<a href="mybatis/mybatis_index.do">MyBatis 사용</a>
	</li>
</ul>
</div>
</body>
</html>
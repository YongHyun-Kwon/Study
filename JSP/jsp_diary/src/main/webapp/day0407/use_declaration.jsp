<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- bootstrap CDN-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function() {
	
}); // ready
</script>
</head>
<body>
<%! // declaration은 JSP가 변경될 때 class field에 코드가 생성된다.
	
	int i; // instance variable : 자동초기화가 된다.
	public String date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE");
		
		return sdf.format(new Date());
} // test
%>
인스턴스 변수 : <%= i %>
<% // scriptlet은 Java로 변경될 때 _jspService method안에 코드가 생성된다.
int j=0; // 지역변수 : 자동치기화가 안되므로 초기화하여 사용한다.
%>
지역 변수 : <%= j %><br/>
<%
String date2=date();
%>
<ul>
	<li>직접 호출<%= date() %></li>
	<li>변수 저장 : <%= date2 %></li>
</ul>
<%!
 //request :  선언에서는 내장객체를 사용할 수 없다.
 public String createRadio(String radioName, int checkNum){
	// 0~10까지 선택할 수 있는 radiobutton 11개 생성하여 반환하는 일.
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < 11; i++){
		sb.append("<input type='radio' name='").append(radioName).append("' value='").append(i).append("'")
		.append(i==checkNum?"checked='checked'":"")
		.append(">")
		.append(i).append("점&nbsp;");
	}
	
	
	return sb.toString();
} // createRadio
%>
<%
 //request :  스크립틀렛에서는 내장객체를 사용할 수 있다.
 %>
 <%= createRadio("a",5) %><br/>
 <%= createRadio("b",7) %>

</body>
</html>
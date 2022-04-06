<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/html_prj/common/css/main_20220321.css"/>
<style type="text/css">
.td{ text-align: left; background-color: black; color: white; height: 30px; }
img{ height: 100px;}
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
<%
// scriptlet : method내에서 정의하는 Java Code 작성
String msg = ""; // 지역변수 선언
%>
<div>
<%
// _jspService method 안에 코드가 생성되므로 위의 코드를 아래에서 사용할 수 있다.
msg="오늘은 수요일 입니다.";
%>
<%= msg %>
</div>
<div>
	<% for(int i = 0; i < 7; i++ ) { %>
	<h<%= i %>><%= msg %></h<%= i%>>
	<% 
	}// end for
	%>
</div>
<div>
<select class="inputBox">
<%
int nowYear = Calendar.getInstance().get(Calendar.YEAR);
int flagYear = nowYear - 20 + 1;
// 나이 20살에 해당하는 년도의 option을 선택
for (int i = nowYear; i > 1949; i--) {
%>
		<option value = "<%= i %>"<%= i==flagYear?"selected='selcte'":""%>><%= i %></option>
<%
	}// end for
%>
</select>
</div>
<div>
	<select class="inputBox">
	<% for (int i = nowYear-2; i < nowYear +3; i++){ %>
		<option value = "<%= i %>"<%= i == nowYear?"selected='selcte'":"" %>><%= i %></option>
	<%
	}
	%>
	</select>
</div>
<div>
	<% 
	String[] names={"정인선","권용현","강현모","신유철","서희수"};
	%>
</div>
<div>
	<table>
		<tr>
			<%
			for(int i =0; i < names.length; i++) {
				if(names[i] == "권용현"){ %>
				<td class="td" ><img src="../common/images/rabbit.png"></td>
			<%		
				} else{
				%>
				<td class="td"><img src="../common/images/user.png"></td>
				
				<%
				}
				%>
				<%
				
			}
			%>
		</tr>
		<tr>
		<%
			for(int i = 0; i < names.length; i++ ){
		%>
			<td class="td"><%= names[i] %></td>
		<%
			}
		%>
		</tr>
	</table>
</div>

</body>
</html>
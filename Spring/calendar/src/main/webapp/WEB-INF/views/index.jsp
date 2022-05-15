<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/common/jsp/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/spring_mvc/common/css/main_20220321.css">
<style type="text/css">
th,td,table{ border: 1px solid #CECECE }
.td{ width: 120px;height: 80px; text-align: left; vertical-align:top;border: 1px solid #CECECE}
.todayTd{ background-color:  #E9F4FB}
.sunTitle{ width: 120px;height: 30px; text-align: center; background-color: #E43B2E;font-weight: bold; color: #FFFFFF }
.weekTitle{ width: 120px;height: 30px; text-align: center; background-color: #E9F1F6;font-weight: bold; color: #787878 }
.satTitle{ width: 120px;height: 30px; text-align: center; background-color: #89C1EF;font-weight: bold; color: #FFFFFF }

.sunText{ font-weight: bold; color:#E83038  }
.satText{ font-weight: bold; color:#5186BB }
.weekText{ color:#333333  }

</style>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript">
$(function(){
	
});//ready
</script>
</head>
<body>
<div>
<div id="header">
	<div id="navibar">
	<c:import url="http://localhost/calendar/common/jsp/navibar.jsp"/>
	</div>
</div>
<div id="container">
<div id="calendarContainer">
<%
Calendar cal=(Calendar)request.getAttribute("cal");
int nowYear=cal.get(Calendar.YEAR);
int nowMonth=cal.get(Calendar.MONTH)+1;
int nowDay=cal.get(Calendar.DAY_OF_MONTH);
%>
<div id="calendarHeader">
<a href="calendar.do?param_month=<%= nowMonth-1==0?12:nowMonth-1 %>&param_year=<%=
nowMonth-1==0?nowYear-1:nowYear%>" ><img src="<%= protocol+serverName+serverPath+commonImg%>btn_prev.png"/></a>
<span><%= nowYear %>.<%= nowMonth %></span>
<a href="calendar.do?param_month=<%= nowMonth+1==13?1:nowMonth+1 %>&param_year=<%=
nowMonth+1==13?nowYear+1:nowYear%>" ><img src="<%= protocol+serverName+serverPath+commonImg%>btn_next.png"/></a>
<a href="calendar.do"><img src="<%= protocol+serverName+serverPath+commonImg%>btn_today.png"/></a>
</div>
<div id="calendarContent">
<table id="tableCal" style="border-spacing: 1px">
<tr>
<th class="sunTitle">일</th>
<th class="weekTitle">월</th>
<th class="weekTitle">화</th>
<th class="weekTitle">수</th>
<th class="weekTitle">목</th>
<th class="weekTitle">금</th>
<th class="satTitle">토</th>
</tr>
<tr>
<%
String dayCss="";

//오늘에 바닥색을 설정 #E9F4FB
String todayCss="";
int today=(Integer)request.getAttribute("today");
for(int tempDay=1; tempDay < 33 ; tempDay++){
	//증가하는 임시일자로 달력객체의 일을 설정한다.
	cal.set(Calendar.DAY_OF_MONTH, tempDay);
	//설정된일자를 가져와서, 임시일자(tempDay)와 비교한다.
	if( cal.get(Calendar.DAY_OF_MONTH) != tempDay){
		//마지막 날 이후 칸 만들기 : cal객체는 다음 달 1일을 가진다.
		for( int blankTd=cal.get(Calendar.DAY_OF_WEEK); blankTd<= Calendar.SATURDAY ; blankTd++){
			%>
			<td class="td"></td>
			<%
		}//end for
		
		break;
	}//end if
	
	switch(tempDay){//시작일이
	case 1: //1일 이면
	//1부터 1일의 요일 수보다 작을 때까지 공백 출력
	for(int blankTd=1; blankTd<cal.get(Calendar.DAY_OF_WEEK); blankTd++){
		%>
		<td class="td"></td>
		<%
	}//end for
	}//end swtich
	
	//일요일이면 sunText, 평일이면 weekText, 토요일이면 satText로 dayCss를 설정
	dayCss="weekText";
	switch( cal.get(Calendar.DAY_OF_WEEK) ){
	case Calendar.SUNDAY: dayCss="sunText";break;
	case Calendar.SATURDAY: dayCss="satText";break;
	}//end switch
	todayCss="";
	if(tempDay==today){
	todayCss=" todayTd";
	}
%>
<td class="td<%= todayCss %>" ><div class="<%= dayCss %>"><%= tempDay %></div></td>
<%
	//토요일이면 줄을 변경.
	switch( cal.get(Calendar.DAY_OF_WEEK) ){
	case Calendar.SATURDAY : 
		%>
		</tr>
		<tr>
		<%
	}
	
}//end for
%>
</tr>

</table>
</div>

</div>


</div>
<div id="footer"></div>

</div>

</body>
</html>
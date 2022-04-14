<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="입력 URL로 이동할페이지를 설정하고 이동하는 일"
    %>
    <%
    request.setCharacterEncoding("UTF-8");
    String serverName = request.getServerName();
    String moveURI="kor.jsp";
    String lang = "한국어"; // 파라메터로 생성하여 전송
    if( !"localhost".equals(serverName) ){
    	moveURI="eng.jsp";
    	lang="english";
    } // end if
    %>
<%-- <jsp:forward page="<%= moveURI %>"/> --%>
<!-- 웹 파라메터를 생성하여 전송  -->
<jsp:forward page="<%= moveURI %>">
<jsp:param value="<%=lang %>" name="lang"/>
</jsp:forward>
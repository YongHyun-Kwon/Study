<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="공통기능을 사용하는 JSP"
    %>
<!-- 공통페이지가 사용되는 곳에서 소스보기 했을 때 하나의 HTML처럼 보이도록
만들어야한다. -->
<%-- <%= val2 %> <br/> 외부 JSP에 존재하는 변수는 사용할 수 있으나 eclipse에서 에러를 보여준다.
모외부 JSP에 val2변수가 존재하지 않을 수 도 있기 때문이다.
   --%>
공통데이터<br/>
<% String val="지역변수"; %>
<%= val %>


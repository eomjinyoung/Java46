<%-- 5) Directive Element
. 특별한 자바 코드로 변환됨.
. 종류: page, include, taglib
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.net.*" %>
<%@ page import="java.sql.Connection" %>
<%-- JSP 주석 : 무시한다. --%>
<!-- HTML 주석 : 출력문으로 만든다. -->  
<%-- 1) Template Date
. 그냥 작성한 텍스트
. 나중에 자바 출력문으로 만들어짐 
 --%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 2) Scriptlet 
. 자바 코드를 작성
. 서블릿 클래스의 _jspService()에 그대로 복사함.
--%>
<%
int a = 25;
if (a > 20) {%>
	a는 20보다 크다.
<%} else if (a == 20) {%>
	a는 20과 같다.
<%} else {%>
  a는 20보다 작다.	
<%}%>

<%-- 3) Expression Element
. 출력문의 파라미터로 올 수 있는 자바 코드(expression)
. 서블릿 클래스의 _jspService()에 출력문을 만듬. 
 --%>
<p>
a의 값은 <%=a%> 입니다.
</p>
인사말: <%=hi%><br>
또 인사말: <%=hello()%><br>
</body>
</html>

<%-- 4) Declaration Element 
. 클래스의 멤버(변수와 메서드)를 선언할 때 사용
. 이 태그의 위치는 상관없음.
--%>
<%!
String hi = "우후~~~ 반가워요..";

private String hello() {
  return "오호라..안녕하세요!";
}
%>



























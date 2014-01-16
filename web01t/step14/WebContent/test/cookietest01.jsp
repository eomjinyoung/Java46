<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie c1 = new Cookie("color", "red");
Cookie c2 = new Cookie("food", "buchim");
response.addCookie(c1);
response.addCookie(c2);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키테스트1</title>
</head>
<body>
<h1>쿠키 보냄</h1>
</body>
</html>
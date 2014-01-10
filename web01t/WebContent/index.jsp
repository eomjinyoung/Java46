<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPMS 시작</title>
</head>
<body>
<h1>SPMS 홈페이지</h1>
<c:if test="${empty member}">
  <c:redirect url="auth/login.html"/>
</c:if>
이름: ${member.name}<br>
이메일: ${member.email}<br>
<p>
<a href="auth/logout">[로그아웃]</a>
</p>
</body>
</html>










<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="login" method="post">
이메일: <input type="text" name="email" value="${email}"><br>
암호: <input type="password" name="password"><br>
<input type="checkbox" name="saveEmail" ${checkSaveEmail}>이메일 저장<br>
<input type="submit" value="로그인">
</form>
</body>
</html>
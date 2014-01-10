<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>객체를 찾는 범위 지정</h1>
<%
pageContext.setAttribute("v1", "오호라");
%>
requestScope의 값: ${requestScope.v1}<br>
sessionScope의 값: ${sessionScope.v1}<br>
applicationScope의 값: ${applicationScope.v1}<br>
pageContext의 값: ${pageScope.v1}<br>

<h1>EL 표기법</h1>
이름: ${requestScope.member["name"]}<br>
이메일: ${requestScope.member["email"]}<br>
전화: ${requestScope.member["tel"]}<br>
나이: ${requestScope.member["age"]}<br>

<h1>requestScope과 객체의 값 꺼내기</h1>
이름: ${requestScope.member.name}<br>
이메일: ${requestScope.member.email}<br>
전화: ${requestScope.member.tel}<br>
나이: ${requestScope.member.age}<br>
</body>
</html>
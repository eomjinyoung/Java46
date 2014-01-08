<%@ page import="spms.vo.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Member m = (Member)request.getAttribute("member"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원정보</title>
</head>
<body>
<h1>회원 정보2</h1>
<form action='update' method='post'>
번호: <input readonly type='text' name='no' value='<%=m.getNo()%>'><br>
이름: <input type='text' name='name' value='<%=m.getName()%>'><br>
이메일: <input type='text' name='email' value='<%=m.getEmail()%>'><br>
전화: <input type='tel' name='tel' value='<%=m.getTel()%>'><br>
나이: <input type='text' name='age' value='<%=m.getAge()%>'><br>
<input type='submit' value='변경'>
<a href='delete?no=<%=m.getNo()%>'>[삭제]</a><br>
</form>
</body>
</html>
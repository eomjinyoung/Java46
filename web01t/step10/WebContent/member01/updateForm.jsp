<%@ page import="spms.vo.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="spms.vo.Member"/>    
<%-- 
spms.vo.Member member = (spms.vo.Member)request.getAttribute("member"); 
if (member == null) {
  member = new Member();
  request.setAttribute("member", member);
}
--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원정보</title>
</head>
<body>
<h1>회원 정보2</h1>
<form action='update' method='post'>
번호: <input readonly type='text' name='no' value='<%=member.getNo()%>'><br>
이름: <input type='text' name='name' value='<%=member.getName()%>'><br>
이메일: <input type='text' name='email' value='<%=member.getEmail()%>'><br>
전화: <input type='tel' name='tel' value='<%=member.getTel()%>'><br>
나이: <input type='text' name='age' value='<%=member.getAge()%>'><br>
<input type='submit' value='변경'>
<a href='delete?no=<%=member.getNo()%>'>[삭제]</a><br>
</form>
</body>
</html>
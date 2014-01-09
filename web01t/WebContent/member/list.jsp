<%@page import="spms.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원 목록</title>
</head>
<body>
<h1>회원 목록</h1>
<a href='NewMember.html'>[새회원]</a><br>
<table border='1'>
<tr>
<th>번호</th>
<th>이름</th>
<th>이메일</th>
<th>나이</th>
<th>전화</th>
</tr>

<% //Scriptlet 엘리먼트 
ArrayList<Member> members = 
  (ArrayList<Member>) request.getAttribute("members");
for(Member m : members) {
%>
<tr>
<td><%=m.getNo()%></td>
<td><a href='read?no=<%=m.getNo()%>'><%=m.getName()%></a></td>
<td><%=m.getEmail()%></td>
<td><%=m.getAge()%></td>
<td><%=m.getTel()%></td>
</tr>
<%} %>
</table>
</body>
</html>
<% System.out.println("list.jsp: _jspService()"); %>    
    
    
    
    
    
    
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
<jsp:useBean id="members" 
  type="java.util.ArrayList<spms.vo.Member>"
  class="java.util.ArrayList"
  scope="request"/>

<% //Scriptlet 엘리먼트 
/*
// 1) type의 값은 레퍼런스 변수를 선언할 때 사용!
//    만약 type 속성이 없으면, class 값을 가지고 레퍼런스 변수를 선언한다.
java.util.ArrayList<spms.vo.Member> members = 
  (java.util.ArrayList<spms.vo.Member>) request.getAttribute("members");

// 2) class의 값은 빈을 찾을 수 없었을 때 새로 객체를 생성하기 위해 사용
if (members == null) {
	members = new java.util.Array();
	request.setAttribute("members", members);
}

*/
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
    
    
    
    
    
    
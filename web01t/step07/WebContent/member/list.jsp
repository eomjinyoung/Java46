<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
<c:forEach var="m" items="${members}">
<tr>
<td>${m.no}</td>
<td><a href='read?no=${m.no}'>${m.name}</a></td>
<td>${m.email}</td>
<td>${m.age}</td>
<td>${m.tel}</td>
</tr>
</c:forEach>

</table>
    
    
    
    
    
    
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="border:1px red solid;background-color:lightgray;">
*SPMS
<a href="${pageContext.request.contextPath}/member/list">회원</a>
<a href="${pageContext.request.contextPath}/project/list">프로젝트</a>
<a href="${pageContext.request.contextPath}/task/list">작업</a>
<a href="#">${member.name}</a>
<a href="${pageContext.request.contextPath}/auth/logout">[로그아웃]</a>
</div>
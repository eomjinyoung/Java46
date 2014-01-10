<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>fmt:parseDate 태그 - java.util.Date 객체 생성</h1>
<c:set var="startDate" value="1-13-2014"/>
<fmt:parseDate var="d1" value="${startDate}" pattern="MM-dd-yyyy" />
${d1}<br>
<fmt:formatDate value="${d1}" pattern="yyyy/MM/dd"/><br>

<h1>redirect 태그 </h1>
<c:set var="isRedirect" value="false"/>
<c:if test="${isRedirect}">
  <c:redirect url="http://www.daum.net"/>
</c:if>

<h1>import 태그 : 특정 URL의 콘텐츠 가져옴.</h1>
<%-- 
<c:import 
    url="http://www.zdnet.co.kr/Include2/ZDNetKorea_News.xml" 
    var="result" />
<textarea rows="10" cols="80">${result}</textarea>
--%>

<h1>url 태그 : URL을 만들 때 사용</h1>
<c:url var="memberAddUrl" value="http://localhost:9999/web01/member/add">
  <c:param name="name" value="홍길동2"/>
  <c:param name="email" value="hong2@test.com"/>
  <c:param name="tel" value="111-2222"/>
  <c:param name="age" value="22"/>
</c:url>
<a href="${memberAddUrl}">회원 등록</a><br>

<h1>forToken 태그 : 문자열을 특정 구분자로 자를 때 사용</h1>
<c:set var="names">aaaa#.#okoko#.#dddd#.#pppp</c:set>
<c:forTokens items="${names}" delims="#.#" var="n">
  ${n}<br>
</c:forTokens>

<h1>forEach 태그 : 자바의 for( 변수 : 배열 또는 Collection)</h1>
<%
pageContext.setAttribute("names", new String[]{"홍길동","임꺽정","유관순"});
%>
<%--
items : 배열, java.util.Collection, java.util.Iterator, 
        java.util.Enumeration, java.util.Map, 콤마로 구분된 문자열
var : 목록에서 꺼낸 항목을 가리는 변수
 --%>
<c:forEach items="${names}" var="name" begin="1" end="2">
  ${name},
</c:forEach>
<br>

<c:forEach items="${'aaa,bbb,ccc,ddd'}" var="name">
  ${name}#
</c:forEach>
<br>

<%
HashMap<String,String> maps = new HashMap<String,String>();
maps.put("s1","홍길동");
maps.put("s2","임꺽정");
maps.put("s3","일지매");
pageContext.setAttribute("maps", maps);
%>
<hr>
<c:forEach items="${maps}" var="name">
  ${name}<br>
</c:forEach>


<h1>choose 태그 : 자바의 if..else if, switch...case </h1>
<c:set var="state" value="0"/>
<c:choose>
  <c:when test="${state == 0}">준비</c:when>
  <c:when test="${state == 1}">진행</c:when>
  <c:when test="${state == 2}">완료</c:when>
  <c:otherwise>취소</c:otherwise>
</c:choose>

<h1>if 태그 : 조건문</h1>
<c:set var="name" value="홍길동"/>
<c:if test="${name == '홍길동'}">
  오호라... 너 홍길동이구나.<br>
</c:if>

<h1>set 태그 : 객체의 프로퍼티 값 설정</h1>
<jsp:useBean id="project" class="spms.vo.Project" scope="page"/>
<c:set target="${project}" property="state" value="1"/>
<c:set target="${project}" property="title" value="프로젝트 제목"/>
${project.state}<br>
${project.title}<br>  

<h1>remove 태그 : 보관소에 저장된 객체 제거</h1>
<c:remove var="project" scope="page"/>
${project.state}<br>
${project.title}<br> 

<h1>set 태그 : 변수 선언</h1>
<c:set var="name" value="임꺽정" scope="page"/>
<c:set var="name2">오호라</c:set>
${name}<br>
${name2}<br>

<h1>out 태그</h1>
<c:out value="홍길동"/><br>
${"홍길동"}<br>
</body>
</html>







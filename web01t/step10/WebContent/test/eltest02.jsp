<%@page import="spms.vo.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>조건 연산자</h1>
<%
pageContext.setAttribute("name", "홍길동");
%>
${(empty name)? "이름없음":name}<br>

<h1>empty 연산자</h1>
<%
pageContext.setAttribute("name", "홍길동");
%>
${empty name}<br>
${empty name2}<br>

<h1>EL 연산자</h1>
${20 + 30}<br>
${20 - 30}<br>
${20 * 30}<br>
${20 / 30}<br>
{20 div 30}<br>
${20 % 30}<br>
${20 mod 30}<br>

<h1>자바 객체의 프로퍼티 값 꺼내기</h1>
<%
pageContext.setAttribute("member", new Member()
  .setName("aaaa")
  .setEmail("bbb")
  .setTel("111")
  .setAge(30));
%>
${member.name}<br>
${member.email}<br>
${member.tel}<br>
${member.age}<br>

<h1>Map에서 값 꺼내기</h1>
<%
HashMap<String,String> maps = new HashMap<String,String>();
maps.put("s01", "aaaa");
maps.put("s02", "bbbb");
maps.put("s03", "cccc");
pageContext.setAttribute("maps", maps);
%>
${maps.s01}<br>
${maps["s01"]}<br>
${maps['s01']}<br>

<h1>List에서 값 꺼내기</h1>
<%
ArrayList<String> names = new ArrayList<String>();
names.add("aaaa");
names.add("bbbb");
names.add("cccc");
pageContext.setAttribute("names", names);
%>
${names[1]}<br>

<h1>배열에서 값 꺼내기</h1>
<%
pageContext.setAttribute("scores", new int[]{90,80,90,90});
%>
배열출력: ${scores[3]}<br>

<h1>EL 표현식</h1>
문자열: ${"오호라 문자열"}<br>
문자열: ${'이것도 문자열'}<br>
정수: ${34}<br>
부동소수점: ${3.14}<br>
참거짓: ${true}<br>
null: ${null}<br>
<%String s = null; %>
Expression: <%=s%><br>

</body>
</html>
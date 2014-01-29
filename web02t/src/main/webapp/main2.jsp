<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPMS 시작화면</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main2.css">
</head>
<body>
<div>
SPMS(Simple Project Management System)
</div>
<table>
<tr>
<td id="sidebar">
<jsp:include page="auth/loginUser.do"/>
<jsp:include page="project/myProjects.do"/>
<jsp:include page="task/myTasks.do"/>
</td>
<td id="contents">
<jsp:include page="project/desc.do?no=1"/>
<jsp:include page="member/projectMembers.do?no=1"/>
<jsp:include page="task/list.do?projectNo=1"/>
</td>
<td id="feedbar">3</td>
</tr>
</table>

</body>
</html>











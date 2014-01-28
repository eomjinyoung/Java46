<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPMS 시작화면</title>
<style type="text/css">
table {
  width: 900px; 
  border: 1px solid blue;
}
td {
  border: 1px dotted green;
}
#sidebar {
  width: 150px; 
  vertical-align: top;
}
#contents {
  vertical-align: top;
}
#feedbar {
  width: 200px; 
  vertical-align: top;
}
#loginUser {
  display: table;
  vertical-align: middle;
}
#loginUser img {
  display: table-cell;
  width: 60px;
  height: 80px;
/*   border: 1px solid black; */
}
#loginUser .username {
  display: table-cell;
/*   border: 1px solid black; */
  vertical-align: middle;
}
.portlet h1 {
  font-size: medium;
}
.portlet ul {
  margin: 0;
  padding-left: 20px;
}
.portlet li {
  padding: 0;
}
</style>
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
</td>
<td id="contents">2</td>
<td id="feedbar">3</td>
</tr>
</table>

</body>
</html>











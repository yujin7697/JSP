<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MAIN</h1>
Userid : <%=session.getAttribute("userid") %><br>


<a href="logout.jsp">로그아웃</a>

</body>
</html>
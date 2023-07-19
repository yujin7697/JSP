<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
%>

Session 값 : <%=session.getAttribute("ID") %>| <%=session.getAttribute("PW") %><br>
Request 값 : <%=request.getAttribute("ID2") %> | <%=request.getAttribute("PW2") %><br>
</body>
</html>
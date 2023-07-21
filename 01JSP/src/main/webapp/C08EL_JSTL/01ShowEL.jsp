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
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
	%>
	USERID : <%=userid %><br/>
	PWD : <%=pwd %><br/>
	
	<hr/>
	<h2>EL</h2>
	[PARAM]USERID : ${param.userid }<br/>
	[PARAM]PW : ${param.pwd }<br/>
	<hr/>
	
</body>
</html>
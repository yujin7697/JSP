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
	session.invalidate();	//세션 제거
	
	out.println("<script>");
	out.println("alert('로그아웃 하였습니다.')");
	out.println("location.href='login.jsp'");
	out.println("</script>");
%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Login</h1>
<form action="<%=request.getContextPath()%>/login.do" method="post">
	<input name = "userid" /><br/>
	<input type="password" name="pwd" /><br/>
	<input type="submit" />
</form>
	

</body>
</html>
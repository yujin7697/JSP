<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="main.do" method="post">
		ID : <input name="id" /><br> 
		PW : <input name="pw" type="password" /><br> 
		<input type="submit" value="로그인" />
	</form>
	<hr />
	<div class="msg">${msg}</div>
</body>
</html>
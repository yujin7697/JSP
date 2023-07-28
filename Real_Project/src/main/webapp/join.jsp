<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>

<form action="register.do" method="post">
	ID : <input name="id" required/><br>
	PW : <input name="pw" type="password" required/><br>
	PW-CHECK : <input name="pw-check" type="password" required/><br>
	NAME : <input name="username" required/><br>
	PHONE : <input name="phone" value="010-" required/><br>
	BIRTH : <input name="birth" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" placeholder="0000-00-00" required/><br>
	<input type="submit" value="가입" />
</form>
<hr />
<div class="msg">
	${msg}
</div>

</body>
</html>
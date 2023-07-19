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
	//1 파라미터 받기
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	
	//2 유효성체크(Validation) - 생략 (Userid는 일치 , pwd 일치..)
	if(userid.equals("test@test.com") && pwd.equals("1234")){
		//3 Service
		session.setAttribute("userid",userid);
		session.setMaxInactiveInterval(10); // 30분 => 60*30
											// 1시간 => 60*60
											// 1일 => 60*60*24
		//4 View
		response.sendRedirect("main.jsp");
		
	}else{ 
		response.sendRedirect("login.jsp");
	}
	
	

	

	

%>

</body>
</html>
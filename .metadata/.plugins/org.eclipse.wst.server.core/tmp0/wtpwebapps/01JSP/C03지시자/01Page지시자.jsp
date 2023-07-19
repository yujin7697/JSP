<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@page import="java.util.*, C03.SampleDto"%>
<%
	Scanner sc = new Scanner(System.in);
	SampleDto dto = new SampleDto("홍길동",55,"대구");
%>
SampleDto : <%=dto %><br/>
</body>
</html>
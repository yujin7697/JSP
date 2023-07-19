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
		System.out.println("pageContext : "  + pageContext);
		System.out.println("pageContext.getRequest() : "  + pageContext.getRequest());
		System.out.println("pageContext.getSession() : "  + pageContext.getSession());
		System.out.println("pageContext.getServletContext() : "  + pageContext.getServletContext());
		System.out.println("pageContext.getServletContext().getContextPath() : "  + pageContext.getServletContext().getContextPath());
	
	%>
</body>
</html>
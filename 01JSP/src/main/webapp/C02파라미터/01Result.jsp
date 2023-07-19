<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String title = request.getParameter("title");
	String bgcolor = request.getParameter("bgcolor");
	String hobbys[] = request.getParameterValues("hobbys");
	
	if(bgcolor.equals("etc")){
		bgcolor="lightgray";
	}
	System.out.println("title : "+title);
	System.out.println("bgcolor : "+bgcolor);
	System.out.println("hobbys : "+hobbys);
	for(int i=0;i<hobbys.length;i++){
		
		System.out.println(hobbys[i]);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title %></title>
</head>
<body bgcolor=<%=bgcolor %>>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import ="java.io.*"%>
<%
	//Download Path 확인
	String realPath = pageContext.getServletContext().getRealPath("/")+"C05내장객체\\download";
	System.out.println("RealPath : "+ realPath);
	
	try{
		
		//InputStream
		FileInputStream fin = new FileInputStream(realPath+"\\Text1.txt");
		
		//OutputStream
		ServletOutputStream bout = response.getOutputStream();
		
		while(true){
			int data=fin.read();
			if(data==-1) break;
			bout.write((byte)data);
			bout.flush();
		}
		bout.close();
		fin.close();
		 
		//Response 전달 파일타입 변경
		response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=Text1.txt");
	}catch(Exception e){
		e.printStackTrace();
	}

%>
</body>
</html>
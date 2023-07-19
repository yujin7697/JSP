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
	String msg1="HELLO WORLD1";
	String msg2="HELLO WORLD2";
	String msg3="HELLO WORLD3";
	String msg4="HELLO WORLD4";
%>

<form action="" name=frm>
	<input type="text"  />
	<input type="text"  />
	<input type="text"  />
	<input type="text"  />
</form>

<script>
	const form= document.frm;
  	form[0].value="<%=msg1%>";
  	form[1].value="<%=msg2%>";
  	form[2].value="<%=msg3%>";
  	form[3].value="<%=msg4%>";
  	
</script>


</body>
</html>
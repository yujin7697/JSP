<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
	td{border : 1px solid; width : 50px; height:50px;}
</style>

<%
	String param1 = request.getParameter("param1");
	String param2 = request.getParameter("param2");
	String param3 = request.getParameter("param3");
	String param4 = request.getParameter("param4");
	System.out.println(param1 +" " + param2 + " " + param3 + " "+ param4);
	if(param1==null&&param2==null&&param3==null&&param4==null){
		param1="lightgray";
		param2="lightgray";
		param3="lightgray";
		param4="lightgray";
	}
	  
%>
<table>
	<tr>
		<td bgcolor="<%=param1%>"></td>
		<td bgcolor="<%=param2%>"></td>
	</tr>
	<tr>
		<td bgcolor="<%=param3%>"></td>
		<td bgcolor="<%=param4%>"></td>
	</tr>	
</table>


<form  name=frm>
	<input type="hidden" name=param1 />
	<input type="hidden" name=param2 />
	<input type="hidden" name=param3 />
	<input type="hidden" name=param4 />
	<button onclick="sendtoJsp()">변환</button>
</form>

</body>

<script>
	function sendtoJsp()
	{
			//1 폼태그 찾기
			const form = document.frm;
			form[0].value="red";
			form[1].value="orange";
			form[2].value="yellow";
			form[3].value="green";
			form.action="04JsToJsp.jsp"
			form.submit();	//전송		
	}
	
 
</script>

</html>
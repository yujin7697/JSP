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
<h1>USER PAGE</h1>
ID : ${ID}
<br>

<h3>대여 내역 조회(비동기 요청)</h3>
<button class=lend_btn class="width:500px; border : 1px solid;">조회하기</button>
<div class="mylendList">

</div>
<hr/>
<!-- axios cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js" integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
		
		function formatDate(date) {
		  const year = date.getFullYear();
		  const month = String(date.getMonth() + 1).padStart(2, '0');
		  const day = String(date.getDate()).padStart(2, '0');
		  console.log(year,month,day);
		  
		  return year+"-"+month+"-"+day;
		}
	
	const lend_btn_el = document.querySelector('.lend_btn');
	lend_btn_el.addEventListener('click',function(){
		
		console.log('lend_btn clicked..');
		const projectPath='${pageContext.request.contextPath}';
		const ServerPort = '${pageContext.request.serverPort}';
		
		axios.get('http://localhost:'+ServerPort+projectPath+'/lend/search.do')
		.then(response=>{
			console.log('response',response);
			
			
			const mylendList_el = document.querySelector('.mylendList');
			const list = response.data;
			list.forEach((dto)=>{
			
				console.log('dto',dto);
				const dto_el = document.createElement('div');
				dto_el.classList.add("item");
				
				dto_el.innerHTML+="<span>"+dto.lendId+"</span> ";
				dto_el.innerHTML+="<span>"+dto.bookcode+"</span> ";
				dto_el.innerHTML+="<span>"+dto.id+"</span> ";
				dto_el.innerHTML+="<span>"+ formatDate(new Date(dto.lendDate))+"</span> | ";
				dto_el.innerHTML+="<span>"+ formatDate(new Date(dto.returnDate))+"</span><br/>";
				mylendList_el.appendChild(dto_el);	
			}) 
			
			
			
		})
		.catch(error=>{console.log('error',error)})
	})
	

		
</script>


<h3>나의 정보 확인(비동기 요청)</h3>
<hr/>
<a href="javascript:history.go(-1)">이전으로</a>
</body>
</html>
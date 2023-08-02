<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<style>
body {
	width: 1024px;
	height: 860px;
	margin: 10px auto;
}

h1 {
	text-align: center;
	text-decoration-line: none;
	color: black;
	font-size: 50px;
	border-bottom: 5px solid;
	padding-bottom: 30px;
}

p {
	text-align: center;
	font-size: 18px;
	margin: 10px 0;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 10px;
	text-align: center;
	border-bottom: 1px solid #ccc;
}

th {
	background-color: #f2f2f2;
}

.no-data {
	text-align: center;
	margin: 20px 0;
	font-size: 18px;
	color: #999;
}
</style>
</head>
<body>
	<h1>My Page</h1>

	<p>Welcome, ${memberId}!</p>

	<%-- DB에 저장된 정보를 가져오는 코드 --%>
	<c:if test="${empty posts}">
		<p class="no-data">데이터가 없습니다.</p>
	</c:if>

	<c:if test="${not empty posts}">
		<table border="1">
			<tr>
				<th>글 번호</th>
				<th>작성자</th>
				<th>글 내용</th>
				<th>작성날짜</th>
				<th>조회수</th>
				<th>좋아요</th>
			</tr>
			<c:forEach var="board" items="${posts}">
				<tr>
					<td>${board.number}</td>
					<td>${board.id}</td>
					<td>${board.contents}</td>
					<td>${board.date}</td>
					<td>${board.hits}</td>
					<td>${board.like}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
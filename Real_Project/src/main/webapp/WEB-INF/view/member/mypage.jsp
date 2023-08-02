<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	
}

body {
	width: 100%;
	height: 100%;
	boader: 1px solid black;
}

.wrapper {
	
}

.wrapper>header {
	
}

.wrapper>header>.top--header {
	
}

.wrapper>header>nav {
	
}

.wrapper>main {
	
}

.wrapper>footer {
	
}
</style>
</head>
<body>

	<div class="wrapper">
		<header>
			<div class="top--header">게시물 수정</div>
			<nav></nav>
		</header>
		<main>
			<section>
				<div class=show--block>
					<!-- 로그인한 회원의 아이디 출력 -->
					<h2>회원 정보</h2>
					<p>회원 아이디: ${memberId}</p>

					<!-- 로그인한 회원이 작성한 게시물 표시 -->
					<h2>작성한 게시물 목록</h2>
					<form action="member/mypage.do" method="post">
						<button type="submit">수정</button>
					</form>
					<hr>
					<div>
						<h2>검색 결과</h2>
						<c:if test="${not empty posts}">
							<table border="1">
								<tr>
									<th>글 번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성날짜</th>
									<th>조회수</th>
									<th>좋아요</th>
									<th>수정</th>
								</tr>
								<c:forEach items="${posts}" var="board">
									<tr>
										<td>${board.number}</td>
										<td>${board.id}</td>
										<td>${board.contents}</td>
										<td>${board.date}</td>
										<td>${board.hits}</td>
										<td>${board.like}</td>
										<td>
											<form action="board/edit.do" method="post">
												<!-- 수정 페이지로 이동하는 폼 추가 -->
												<input type="hidden" name="boardNumber"
													value="${board.number}" />
												<button type="submit">수정</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${not empty posts}">
							<p>작성한 게시물이 없습니다.</p>
						</c:if>
					</div>
					<div></div>
					<div></div>
					<div></div>
					<div></div>
					<div></div>
				</div>



			</section>
			<section></section>
			<section></section>
		</main>
		<footer></footer>
	</div>


</body>
</html>
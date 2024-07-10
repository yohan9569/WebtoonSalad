<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>찜한 웹툰</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jjim.css">
</head>
<body>
	<header>
		<div class="logo">웹툰 샐러드</div>
		<div class="search-bar">
			<input type="text" placeholder="제목으로 검색">
		</div>
		<div class="auth-buttons">
			<button onclick="location.href='login.jsp'">로그인</button>
			<button onclick="location.href='signup.jsp'">회원가입</button>
		</div>
	</header>
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/home">홈</a></li>
			<li><a href="${pageContext.request.contextPath}/jjim" class="active">찜꽁</a></li>
			<li><a href="${pageContext.request.contextPath}/workroom">와글와글</a></li>
			<li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
		</ul>
	</nav>
	<main>
	<aside class="advertisement">
		<div class="ad">
			<!-- <img src="${pageContext.request.contextPath}/images/placeholder.jpg"
				alt="광고">  -->
			<p>광고</p>
			<p>$0</p>
		</div>
		<div class="ad">
			<p>광고</p>
			<p>$50 / month</p>
			<button>Button</button>
		</div>
	</aside>
	<section class="jjim-list">
		<h1>찜한 웹툰</h1>
		<div class="search-bar">
			<input type="text" placeholder="친구 찜꽁 구경하기">
		</div>
		<div class="webtoon-items">
			<c:forEach var="webtoon" items="${jjims}">
				<div class="webtoon-item">
					<div class="thumbnail-container">
                        <img src="${webtoon.thumbnail1}" alt="${webtoon.title} thumbnail 1" />
                        <c:if test="${not empty webtoon.thumbnail2}">
                            <img src="${webtoon.thumbnail2}" alt="${webtoon.title} thumbnail 2" />
                        </c:if>
                    </div>
					<p>${webtoon.title}</p>
					<button class="delete-button" onclick="deleteJJim(${webtoon.id})">🗑</button>
				</div>
			</c:forEach>
		</div>
	</section>
	</main>
	<footer>
		<p>© HAHAHOHO CORP</p>
	</footer>
	<script>
	function deleteJJim(id) {
		// AJAX 요청을 보내서 찜 목록에서 삭제하는 함수
		// 구현해야 할 부분
		alert('찜 목록에서 삭제되었습니다.');
	}
	</script>
</body>
</html>
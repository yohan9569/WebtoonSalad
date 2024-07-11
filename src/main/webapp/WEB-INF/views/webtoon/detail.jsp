<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>웹툰 샐러드</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/webtoon/detail.css">
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
			<li><a href="${pageContext.request.contextPath}/square">찜꽁</a></li>
			<li><a href="${pageContext.request.contextPath}/workroom">와글와글</a></li>
			<li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
		</ul>
	</nav>
	<div class="container">
		<aside class="sidebar left-sidebar">
			<div class="advertisement">
				<div class="ad">
					<img
						src="${pageContext.request.contextPath}/images/placeholder.jpg"
						alt="광고">
					<p>$0</p>
				</div>
				<div class="ad">
					<p>광고</p>
					<p>$50 / month</p>
					<button>Button</button>
				</div>
			</div>
		</aside>
		<main>
		<section class="webtoon-detail">
			<h1>웹툰</h1>
			<div class="webtoon-info">
				<div class="thumbnail-container">
					<img src="${detail.thumbnail1}" alt="thumbnail 1" class="thumbnail">
					<c:if test="${not empty detail.thumbnail2}">
						<img src="${detail.thumbnail2}" alt="thumbnail 2" class="thumbnail">
					</c:if>
				</div>
				<div class="details">
					<p>${detail.provider}</p>
					<h2>${detail.title}</h2>
					<p>연재 요일 | ${detail.updateDays}</p>
					<p>글/그림 | ${detail.authors} 글/그림</p>
					<c:if test="${detail.isAdult == 1}">
						<p>청소년 관람불가</p>
					</c:if>
					<c:if test="${detail.freeWaitHour == 1}">
						<p>기다리면 무료</p>
					</c:if>
					<p>최근 업로드 일자| ${detail.lastUp}</p>
					<button class="btn-like">찜꽁 ❤️ ${detail.jjimCount}</button>
					<button class="btn-view"
						onclick="window.location.href='${detail.url}'">바로 보기</button>
				</div>
			</div>
			<div class="comments">
				<button class="btn-comment">나의 한 줄 평</button>
				<button class="btn-comment">작화는 초반이 더 좋다</button>
				<p>👍 30</p>
				<button class="btn-edit">수정 / 삭제</button>
			</div>
			<div class="ad-placeholder">
				<button class="btn-ad">스포 방지 버튼</button>
			</div>
		</section>
		</main>
		<aside class="sidebar right-sidebar"></aside>
	</div>
	<footer>
		<p>© HAHAHOHO CORP</p>
	</footer>
</body>
</html>

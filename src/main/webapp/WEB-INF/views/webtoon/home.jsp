<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>웹툰 샐러드</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css">
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
	<main>
	<aside class="advertisement">
		<div class="ad">
			<img src="${pageContext.request.contextPath}/images/placeholder.jpg"
				alt="광고">
			<p>$0</p>
		</div>
		<div class="ad">
			<p>광고</p>
			<p>$50 / month</p>
			<button>Button</button>
		</div>
	</aside>
	<section class="webtoon-list">
		<div class="day-filter">
			<button>요일전체</button>
			<button class="active">월</button>
			<button>화</button>
			<button>수</button>
			<button>목</button>
			<button>금</button>
			<button>토</button>
			<button>일</button>
		</div>
		<div class="webtoon-items">
			<c:forEach var="webtoon" items="${home}">
				<div class="webtoon-item">
					<div class="thumbnail-container">
                        <img src="${webtoon.thumbnail1}" alt="${webtoon.title} thumbnail 1" />
                        <c:if test="${not empty webtoon.thumbnail2}">
                            <img src="${webtoon.thumbnail2}" alt="${webtoon.title} thumbnail 2" />
                        </c:if>
                    </div>
                    <p>${webtoon.title}</p>
				</div>
			</c:forEach>
		</div>
	</section>
	</main>
	<footer>
		<p>© HAHAHOHO CORP</p>
		<!-- Additional footer content -->
	</footer>
</body>
</html>

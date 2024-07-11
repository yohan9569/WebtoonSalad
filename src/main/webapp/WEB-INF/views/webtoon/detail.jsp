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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	// 전역 범위에서 toggleJjim 함수 정의
	function toggleJjim(webtoonId) {
		console.log("Button clicked for webtoonId: " + webtoonId); // 버튼 클릭 확인용 로그 출력
		const toggleUrl = "${pageContext.request.contextPath}/jjim/toggleJjim?webtoonId="
				+ webtoonId;
		console.log("Toggle URL: " + toggleUrl); // 경로 확인용 로그 출력
		$.get(toggleUrl, function(response) {
			if (response === "success") {
				console.log("Toggle successful");
				location.reload();
			} else {
				console.log("Toggle failed: " + response);
				alert("Failed to toggle jjim: " + response);
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
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
				<p>최근 업로드 일자 | ${detail.lastUp}</p>
				<c:choose>
					<c:when test="${jjimExists}">
						<button class="btn-like" onclick="toggleJjim('${detail.id}')">찜꽁
							♡ ${detail.jjimCount}</button>
					</c:when>
					<c:otherwise>
						<button class="btn-like" onclick="toggleJjim('${detail.id}')">찜꽁
							❤️ ${detail.jjimCount}</button>
					</c:otherwise>
				</c:choose>
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
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>

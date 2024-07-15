<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>웹툰 샐러드</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/webtoon/home.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/aside.css">
<script>
    function filterByDay(day) {
        // 한글 요일을 영어 요일로 변환하는 객체
        const dayMap = {
            '일': 'SUN',
            '월': 'MON',
            '화': 'TUE',
            '수': 'WED',
            '목': 'THU',
            '금': 'FRI',
            '토': 'SAT',
            '요일전체': null
        };
        
        // 전달받은 요일(day)을 영어 요일로 변환
        const englishDay = dayMap[day];

        // 폼의 hidden input 필드에 영어 요일 값 설정
        document.getElementById('dayForm').day.value = englishDay;
        
        // 폼 제출
        document.getElementById('dayForm').submit();
    }
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<main> <jsp:include page="/WEB-INF/views/aside.jsp" />
	<section class="webtoon-list">
		<form id="dayForm" action="${pageContext.request.contextPath}/home"
			method="get">
			<input type="hidden" name="day" value="" />
		</form>
		<div class="day-filter">
			<button onclick="filterByDay('요일전체')">요일전체</button>
			<button onclick="filterByDay('월')">월</button>
			<button onclick="filterByDay('화')">화</button>
			<button onclick="filterByDay('수')">수</button>
			<button onclick="filterByDay('목')">목</button>
			<button onclick="filterByDay('금')">금</button>
			<button onclick="filterByDay('토')">토</button>
			<button onclick="filterByDay('일')">일</button>
		</div>
		<div class="webtoon-items">
			<c:forEach var="webtoon" items="${home}">
				<div class="webtoon-item">
					<a class="webtoon-link"
						href="${pageContext.request.contextPath}/webtoon/detail?id=${webtoon.id}">
						<div class="thumbnail-container">
							<img src="${webtoon.thumbnail1}"
								alt="${webtoon.title} thumbnail 1" />
							<c:if test="${not empty webtoon.thumbnail2}">
								<img src="${webtoon.thumbnail2}"
									alt="${webtoon.title} thumbnail 2" />
							</c:if>
						</div>
						<p>${webtoon.title}</p>
						<c:choose>
							<c:when test="${webtoon.isUpdated == 1}">  🆙
                        	</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${webtoon.isAdult == 1}"> 🔞
                        	</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
						<p>♥ ${webtoon.jjimCount}</p>
					</a>
				</div>
			</c:forEach>
		</div>
	</section>
	</main>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>

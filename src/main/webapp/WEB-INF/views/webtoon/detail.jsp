<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/aside.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function toggleJjim(webtoonId) {
        const toggleUrl = "${pageContext.request.contextPath}/jjim/toggleJjim?webtoonId=" + webtoonId;
        $.get(toggleUrl, function(response) {
            if (response.error) {
                console.log("Error: " + response.error);
                return;
            }
            let button = $("button.btn-like");
            let jjimCount = response.jjimCount !== null ? response.jjimCount : 0;
            if (response.jjimExists) {
                button.html("찜꽁 ❤️ " + jjimCount);
            } else {
                button.html("찜꽁 🤍 " + jjimCount);
            }
        });
    }
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<main>
		<jsp:include page="/WEB-INF/views/aside.jsp" />
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
					<p>연재 요일 | 
						<c:forEach var="day" items="${fn:split(detail.updateDays, ' / ')}" varStatus="status">
							<c:choose>
								<c:when test="${day == 'MON'}">월</c:when>
								<c:when test="${day == 'TUE'}">화</c:when>
								<c:when test="${day == 'WED'}">수</c:when>
								<c:when test="${day == 'THU'}">목</c:when>
								<c:when test="${day == 'FRI'}">금</c:when>
								<c:when test="${day == 'SAT'}">토</c:when>
								<c:when test="${day == 'SUN'}">일</c:when>
								<c:otherwise>${day}</c:otherwise>
							</c:choose>
							<c:if test="${not status.last}"> / </c:if>
						</c:forEach>
					</p>
					<p>글/그림 | ${detail.authors}</p>
					<c:if test="${detail.isAdult == 1}">
						<p>청소년 관람불가</p>
					</c:if>
					<c:if test="${detail.freeWaitHour == 1}">
						<p>기다리면 무료</p>
					</c:if>
					<c:choose>
						<c:when test="${detail.isUpdated == 1}">  🆙 </c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${jjimExists}">
							<button class="btn-like" onclick="toggleJjim('${detail.id}')">찜꽁 ❤️ ${detail.jjimCount}</button>
						</c:when>
						<c:otherwise>
							<button class="btn-like" onclick="toggleJjim('${detail.id}')">찜꽁 🤍 ${detail.jjimCount}</button>
						</c:otherwise>
					</c:choose>
					<button class="btn-view" onclick="window.location.href='${detail.url}'">바로 보기</button>
				</div>
			</div>
			<!-- Review form -->
            <div class="review-form">
                <textarea id="reviewComment" placeholder="한 줄 평을 작성해 주세요..."></textarea>
                <button onclick="submitReview()">작성</button>
            </div>
            
            <!-- Existing comments -->
            <div class="comments">
                <span class="review">나의 한 줄 평</span>
                <span class="review">${userReview.comment}</span>
                <div class="like-section">
                    <i class="fa fa-thumbs-up"></i>
                    <p>${userReview.likeCount}</p>
                </div>
                <button class="btn-edit" onclick="editReview('${userReview.id}', '${userReview.comment}')">수정</button>
                <button class="btn-delete" onclick="deleteReview('${userReview.id}')">삭제</button>
            </div>
            
            <div class="ad-placeholder">
                <button class="btn-ad">스포 방지 버튼</button>
            </div>
		</section>
	</main>
	<aside class="sidebar right-sidebar"></aside>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>

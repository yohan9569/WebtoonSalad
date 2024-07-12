<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>찜한 웹툰</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jjim.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/aside.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<main>
	<jsp:include page="/WEB-INF/views/aside.jsp" />
	<section class="jjim-list">
	    <h1>찜한 웹툰</h1>
	    <div class="search-bar">
	        <form action="${pageContext.request.contextPath}/jjim/search" method="get">
	            <input type="text" name="nickname" placeholder="친구 찜꽁 구경하기">
	            <button type="submit">검색</button>
	        </form>
	    </div>
	    <c:if test="${not empty jjims}">
	        <div class="webtoon-items">
	            <c:forEach var="webtoon" items="${jjims}">
	                <div class="webtoon-item">
	                    <a href="${webtoon.url}" target="_blank" class="webtoon-link">
	                        <div class="thumbnail-container">
	                            <img src="${webtoon.thumbnail1}" alt="${webtoon.title} thumbnail 1" />
	                            <c:if test="${not empty webtoon.thumbnail2}">
	                                <img src="${webtoon.thumbnail2}" alt="${webtoon.title} thumbnail 2" />
	                            </c:if>
	                        </div>
		                    <div class="webtoon-details">
		                        <p class="webtoon-title">${webtoon.title}</p>
		                        <div class="webtoon-info">
		                            <p>찜한 수: ${webtoon.jjimCount}</p>
		                            <p>UP?: <c:choose>
		                                <c:when test="${webtoon.isUpdated == 1}">UP!</c:when>
		                                <c:otherwise>No..</c:otherwise>
		                            </c:choose></p>
		                            <p>제공자: ${webtoon.provider}</p>
		                            <p>연재 요일: ${webtoon.updateDays}</p>
		                            <p>기다무?: <c:choose>
		                                <c:when test="${webtoon.freeWaitHour == 1}">기다무</c:when>
		                                <c:otherwise>-</c:otherwise>
		                            </c:choose></p>
		                        </div>
		                    </div>
	                    </a>

	                    <div class="webtoon-buttons">
	                        <button class="detail-button" onclick="location.href='${pageContext.request.contextPath}/webtoon/detail?id=${webtoon.id}'">웹툰 정보</button>
	                        <button class="delete-button" onclick="deleteJJim(${webtoon.id})">🗑</button>
	                    </div>
	                </div>
	            </c:forEach>
	        </div>
	    </c:if>
	    <c:if test="${empty jjims}">
	        <p>찜한 웹툰이 없습니다.</p>
	    </c:if>
	    <c:if test="${not empty error}">
	        <p class="error">${error}</p>
	    </c:if>
	</section>
	</main>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
	<script>
	function deleteJJim(id) {
		// AJAX 요청을 보내서 찜 목록에서 삭제하는 함수
		// 구현해야 할 부분
		alert('찜 목록에서 삭제되었습니다.');
	}
	</script>
</body>
</html>
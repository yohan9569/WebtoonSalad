<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="webtoon-items" id="webtoonItems">
    <c:forEach var="webtoon" items="${jjims}">
        <div class="webtoon-item" data-webtoon-id="${webtoon.webtoonId}">
            <a href="${webtoon.url}" target="_blank" class="webtoon-link" onclick="updateLastView('${userId}', '${webtoon.webtoonId}')">
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
				        <!-- temporary -->
				        <p>lastView: ${webtoon.lastView}</p>
		                <p>lastUp: ${webtoon.lastUp}</p>
				    </div>
				</div>
            </a>

            <div class="webtoon-buttons">
                <button class="detail-button" onclick="location.href='${pageContext.request.contextPath}/webtoon/detail?id=${webtoon.webtoonId}'">웹툰 정보</button>
<%--                 <sec:authorize access="principal.username eq '${userId}'"> --%>
                   	<button class="delete-button" onclick="deleteJJim('${webtoon.webtoonId}')">🗑</button>
<%--                	</sec:authorize> --%>
            </div>
        </div>
    </c:forEach>
</div>
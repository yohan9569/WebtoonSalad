<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div id="webtoon-items">
               <c:forEach var="webtoon" items="${jjims}">
                  <div class="webtoon-item ${webtoon.isViewed == 1 ? 'viewed' : ''}" data-webtoon-id="${webtoon.webtoonId}">
                       <a href="${webtoon.url}" target="_blank" class="webtoon-link" onclick="updateLastView('${userId}', '${webtoon.webtoonId}')">
                           <div class="thumbnail-container">
                               <img src="${webtoon.thumbnail1}" alt="${webtoon.title} thumbnail 1" />
                               <c:if test="${not empty webtoon.thumbnail2}">
                                   <img src="${webtoon.thumbnail2}" alt="${webtoon.title} thumbnail 2" />
                               </c:if>
                           </div>
                          <div class="webtoon-details">
                          <div class="up_title">
                             <p class="webtoon-title">${webtoon.title}</p>
                             <c:choose>
                                    <c:when test="${webtoon.isUpdated == 1}">
                                        <div class="is-updated">🆙</div>
                                    </c:when>
                                  <c:otherwise> </c:otherwise>
                              </c:choose>
                          </div>
                              <div class="webtoon-info">
                                  <p>연재 요일 | ${webtoon.updateDays}</p>
                                  <p>최근 업로드 일자 | ${webtoon.lastUp}</p>
                                  <p>마지막으로 본 날짜 | 
                               <c:choose>
                                   <c:when test="${webtoon.lastView == null}">
                                       미열람
                                   </c:when>
                                   <c:otherwise>
                                       ${webtoon.lastView}
                                   </c:otherwise>
                               </c:choose>
                           </p>
                                  <div class="jjim-count">❤️ ${webtoon.jjimCount}</div>
                              </div>
                          </div>
                       </a>

                       <div class="webtoon-buttons">
                           <button class="detail-button" onclick="location.href='${pageContext.request.contextPath}/webtoon/detail?id=${webtoon.webtoonId}'">웹툰 정보</button>
                           <sec:authorize access="principal.username eq '${userId}'">
                               <button class="delete-button" onclick="deleteJJim('${userId}', '${webtoon.webtoonId}')">🗑</button>
                           </sec:authorize>
                           <sec:authorize access="principal.username ne '${userId}'">
                          <button class="delete-button" style="visibility: hidden;">🗑</button>
                      </sec:authorize>
                       </div>
                   </div>
               </c:forEach>
           </div>
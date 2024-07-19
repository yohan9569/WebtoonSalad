<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypage/mypage.css?version=${System.currentTimeMillis()}">
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp" />
    <div class="middleSection">
        <jsp:include page="/WEB-INF/views/leftaside.jsp" />
        <div class="content">
            <nav class="tab">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/mypage?tab=info">회원정보</a></li>
                    <li><a href="${pageContext.request.contextPath}/mypage?tab=report">마이리포트</a></li>
                </ul>
            </nav>
            <div class="tab-content">
                <jsp:include page="/WEB-INF/views/${tabContent}.jsp" />
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>

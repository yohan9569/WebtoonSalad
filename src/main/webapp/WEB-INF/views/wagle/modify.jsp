<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와글 수정</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wagle/wagleModify.css">
</head>
<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/views/header.jsp" />

    <div class="middleSection">
        <!-- aside -->
        <jsp:include page="/WEB-INF/views/leftaside.jsp" />

        <div class="wagleList">
            <div class="wagleSection">
                <h2 class="pageTitle">게시판 글쓰기</h2>
                <form action="${pageContext.request.contextPath}/wagle/modify" method="post">
                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="detailSection">
                        <div class="wagleTitleSection">
                            <label>제목</label>
                            <input class="input" id="titleInput" name="title" value="${detailList.title}">
                        </div>
                        <div class="wagleFileSection">
                            <label>파일</label>
                            <input class="input" id="fileInput" name="content_file" value="${detailList.content_file}">
                        </div>
                        <div class="wagleContentSection">
                            <textarea class="input" id="contentInput" name="content">${detailList.content}</textarea>
                        </div>
                        <div class="buttonSection">
                            <button class="wagleButton" type="button" onclick="location.href='${pageContext.request.contextPath}/wagle/list'">목록</button>
                            <button class="wagleButton" type="submit">확인</button>
                        </div>
                    </div>
                    <input type="hidden" name="id" value="${detailList.id}">
                </form>
            </div>
        </div>
        <jsp:include page="/WEB-INF/views/rightaside.jsp" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>

    <!-- footer -->
    <jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>

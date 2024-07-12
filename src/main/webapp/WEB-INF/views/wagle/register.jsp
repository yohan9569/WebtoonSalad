<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와글</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/wagle/wagleRegister.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/aside.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>

	<!-- header -->
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<!-- aside -->
	<jsp:include page="/WEB-INF/views/aside.jsp" />

	<div class="middleSection">
		<div class="leftAd"></div>
		<div class="wagleList">
			<h2 class="pageTitle">게시판 글쓰기</h2>
			<form action="/wagle/register" method="post">
				<div class="wagleTitleSection">
					<input class="input" id="titleInput" type="text" name="title" placeholder="제목을 입력해주세요">
				</div>
				<div class="wagleContentSection">
					<textarea class="input" id="contentInput" name="content" placeholder="글을 입력해주세요"></textarea>
				</div>
				<div class="buttonSection">
					<button class="wagleButton">취소</button>
					<button class="wagleButton">등록</button>
				</div>
			</form>
		</div>
		<div class="rightAd"></div>
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
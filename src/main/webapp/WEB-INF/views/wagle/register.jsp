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
</head>
<body>

	<!-- header -->
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div class="middleSection">
		<!-- aside -->
		<jsp:include page="/WEB-INF/views/aside.jsp" />
		
		<div class="wagleList">
			<div class="wagleSection">
				<h2 class="pageTitle">게시판 글쓰기</h2>
				<form role="form" action="register" method="post" accept-charset="UTF-8">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="wagleTitleSection">
						<label>제목</label>
						<input class="input" id="titleInput" type="text" name="title"
							placeholder="제목을 입력해주세요">
					</div>
					<div class="wagleFileSection">
						<label>파일</label>
						<input class="input" id="fileInput" name="content_file" placeholder="파일 첨부">
					</div>
					<div class="wagleContentSection">
						<textarea class="input" id="contentInput" name="content"
							placeholder="글을 입력해주세요"></textarea>
					</div>
					<div class="buttonSection">
						<button class="wagleButton" type="button" onclick="location.href='${pageContext.request.contextPath}/wagle/list'">취소</button>
						<button class="wagleButton" type="submit">완료</button>
					</div>
				</form>
			</div>
		</div>
		<div class="rightAd"></div>
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
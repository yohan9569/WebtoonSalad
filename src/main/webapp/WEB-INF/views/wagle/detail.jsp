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
	href="${pageContext.request.contextPath}/css/wagle/wagleDetail.css">
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

	<div class="middleSection">
		<!-- aside -->
		<jsp:include page="/WEB-INF/views/aside.jsp" />

		<div class="wagleList">
			<div class="wagleSection">
				<h2 class="pageTitle">게시판 글쓰기</h2>
				<div class="detailSection">
					<div class="wagleTitleSection">
						<label>제목</label>
						<input class="input" id="titleInput" name="title"
							value='<c:out value="${detailList.title}"/>' readonly="readonly">
					</div>
					<div class="wagleFileSection">
						<label>파일</label>
						<input class="input" id="fileInput" name="content_file"
							value='<c:out value="${detailList.content_file}"/>' readonly="readonly">
					</div>
					<div class="wagleContentSection">
						<textarea class="input" id="contentInput" name="content" readonly="readonly">
							<c:out value="${detailList.content}" />
						</textarea>
					</div>
					<div class="buttonSection">
						<button class="wagleButton" type="button"
							onclick="location.href='${pageContext.request.contextPath}/wagle/list'">목록</button>
						<button class="wagleButton" type="button"
							onclick="location.href='modify?id=<c:out value="${detailList.id}"/>'">수정</button>
					</div>
				</div>
			</div>
		</div>
		<div class="rightAd"></div>
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와글와글</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wagleList.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/aside.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<!-- aside -->
	<jsp:include page="/WEB-INF/views/aside.jsp" />
	
	<div class="middleSection">
		<div class="leftAd"></div>
		<div class="wagleList">
			<h2>자유게시판</h2>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>작성일</th>
						<th>조회</th>
						<th>추천</th>
					</tr>
				</thead>
				<c:forEach items="${list}" var="wagle">
					<tr>
						<td><c:out value="${wagle.row_number}" /></td>
						<td><c:out value="${wagle.title}" /></td>
						<td><c:out value="${wagle.name}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${wagle.create_date}" /></td>
						<td><c:out value="${wagle.view_cnt}" /></td>
						<td><c:out value="${wagle.recommend_cnt}" /></td>
					</tr>
				</c:forEach>
			</table>
			<div class="buttonSection">
			
			<!-- 버튼이랑 페이지네이션 이동시키기  -->
			
				<button>글쓰기</button>
			</div>
		</div>
		<div class="rightAd"></div>
	</div>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
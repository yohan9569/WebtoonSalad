<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와글와글</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/wagle/wagleList.css">
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
			<h2 class="pageTitle">자유게시판</h2>
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
				<tbody>
					<c:forEach items="${list}" var="wagle">
						<tr>
							<td><c:out value="${wagle.row_number}" /></td>
							<td><a href='detail?id=<c:out value="${wagle.id}"/>'> <c:out
										value="${wagle.title}" /></a></td>
							<td><c:out value="${wagle.name}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
									value="${wagle.create_date}" /></td>
							<td><c:out value="${wagle.view_cnt}" /></td>
							<td><c:out value="${wagle.recommend_cnt}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="buttonSection">
				<button class="createWagleButton" type="button"
					onclick="location.href='${pageContext.request.contextPath}/wagle/register'">글쓰기</button>
			</div>
			<div class="pageSection">
                <ul class="pagiNation">
                    <c:if test="${pageMaker.prev}">
                        <li class="paginateButton" onclick="location.href='list?pageNum=${pageMaker.startPage - 1}&amount=${pageMaker.cri.amount}'">이전</li>
                    </c:if>
                    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        <li class="paginateButton" onclick="location.href='list?pageNum=${num}&amount=${pageMaker.cri.amount}'">${num}</li>
                    </c:forEach>
                    <c:if test="${pageMaker.next}">
                        <li class="paginateButton" onclick="location.href='list?pageNum=${pageMaker.endPage + 1}&amount=${pageMaker.cri.amount}'">다음</li>
                    </c:if>
                </ul>
            </div>
			<form id="actionForm" action="list" method="get">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			</form>
		</div>
		<div class="rightAd"></div>
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
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
					<div class="infoSection">
						<c:out value="${detailList.name}" />
						| <c:out value="${detailList.create_date}" />
						| 추천 <c:out value="${detailList.recommend_cnt}" />
					</div>
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
						<textarea class="input" id="contentInput" name="content" readonly="readonly"><c:out value="${detailList.content}" />
						</textarea>
					</div>
					<div class="buttonSection">
						<button class="wagleButton" type="button"
							onclick="location.href='${pageContext.request.contextPath}/wagle/list'">목록</button>
						<button class="wagleButton" type="button"
							onclick="location.href='modify?id=<c:out value="${detailList.id}"/>'">수정</button>
					</div>
				</div>
				<div class="replySection">
					<table>
						<h3>댓글</h3>
				        <c:forEach items="${replyList}" var="reply">
							<tr>
								<td><c:out value="${reply.name}" /></td>
								<td><c:out value="${reply.content}" /></td>
								<td><c:out value="${reply.create_date}" /></td>
								<td><span><svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><title/><g data-name="1" id="_1"><path d="M348.45,432.7H261.8a141.5,141.5,0,0,1-49.52-8.9l-67.5-25.07a15,15,0,0,1,10.45-28.12l67.49,25.07a111.79,111.79,0,0,0,39.08,7h86.65a14.21,14.21,0,1,0,0-28.42,15,15,0,0,1,0-30H368.9a14.21,14.21,0,1,0,0-28.42,15,15,0,0,1,0-30h20.44a14.21,14.21,0,0,0,10.05-24.26,14.08,14.08,0,0,0-10.05-4.16,15,15,0,0,1,0-30h20.45a14.21,14.21,0,0,0,10-24.26,14.09,14.09,0,0,0-10-4.17H268.15A15,15,0,0,1,255,176.74a100.2,100.2,0,0,0,9.2-29.33c3.39-21.87-.79-41.64-12.42-58.76a12.28,12.28,0,0,0-22.33,7c.49,51.38-23.25,88.72-68.65,108a15,15,0,1,1-11.72-27.61c18.72-8,32.36-19.75,40.55-35.08,6.68-12.51,10-27.65,9.83-45C199.31,77,211,61,229.18,55.34s36.81.78,47.45,16.46c24.71,36.36,20.25,74.1,13.48,97.21H409.79a44.21,44.21,0,0,1,19.59,83.84,44.27,44.27,0,0,1-20.44,58.42,44.27,44.27,0,0,1-20.45,58.43,44.23,44.23,0,0,1-40,63Z"/><path d="M155,410.49H69.13a15,15,0,0,1-15-15V189.86a15,15,0,0,1,15-15H155a15,15,0,0,1,15,15V395.49A15,15,0,0,1,155,410.49Zm-70.84-30H140V204.86H84.13Z"/></g></svg>
									<c:out value="${reply.recommend_cnt}" /></span></td>
							</tr>
						</c:forEach>
				    </table>
				</div>
				<div class="pageSection">
	                <ul class="pagiNation">
	                    <c:if test="${pageMaker.prev}">
	                        <li class="paginateButton" onclick="location.href='detail?id=${detailList.id}&pageNum=${pageMaker.startPage - 1}&amount=${pageMaker.replyCri.amount}'">이전</li>
	                    </c:if>
	                    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	                        <li class="paginateButton" onclick="location.href='detail?id=${detailList.id}&pageNum=${num}&amount=${pageMaker.replyCri.amount}'">${num}</li>
	                    </c:forEach>
	                    <c:if test="${pageMaker.next}">
	                        <li class="paginateButton" onclick="location.href='detail?id=${detailList.id}&pageNum=${pageMaker.endPage + 1}&amount=${pageMaker.replyCri.amount}'">다음</li>
	                    </c:if>
	                </ul>
	            </div>
				<form id="actionForm" action="list" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.replyCri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.replyCri.amount}">
				</form>
			</div>
		</div>
		<div class="rightAd"></div>
	</div>

	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
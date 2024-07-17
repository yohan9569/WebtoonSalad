<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>웹툰 샐러드</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css?version=${System.currentTimeMillis()}">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/aside.css?version=${System.currentTimeMillis()}">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
		<div class="logo"> 
			<img src="${pageContext.request.contextPath}/resources/images/text_logo.png" alt="텍스트 로고 이미지" class="text-logo-image">
<%-- 			<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="로고 이미지" class="logo-image"> --%>
		</div>
		<div class="search-bar">
			<input type="text" id="searchInput" placeholder="제목, 작가로 검색"
				onkeyup="search()">
			<div class="results" id="results"></div>
		</div>
		<div class="auth-buttons">
			<sec:authorize access="isAnonymous()">
				<button
					onclick="location.href='${pageContext.request.contextPath}/customLogin'">로그인</button>
				<button onclick="location.href='signup.jsp'">회원가입</button>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="user-info">
					<span> <sec:authentication property="principal.member.name" />
						<!-- 유저 name 보여줌 --> <!-- <sec:authentication property="principal.username" /> -->
						<!-- 유저 ID 보여줌 -->
					</span>
					<form action="${pageContext.request.contextPath}/customLogout"
						method="post" style="display: inline;">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit">로그아웃</button>
					</form>
				</div>
			</sec:authorize>
		</div>
	</header>
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/home">홈</a></li>
			<li><sec:authentication property="name" var="username" /> 
				<a href="${pageContext.request.contextPath}/jjim?userId=${username}">찜꽁</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/wagle/list">와글와글</a></li>
			<li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
		</ul>
	</nav>
	<script>
		function search() {
			var keyword = document.getElementById('searchInput').value;

			if (keyword.length > 0) {
				$.ajax({
					url : '${pageContext.request.contextPath}/webtoon/search',
					type : 'GET',
					data : {
						keyword : keyword
					},
					success : function(data) {
						if (Array.isArray(data)) {
							displayResults(data);
						} else {
							console.error('Received data is not an array');
						}
					},
					error : function() {
						console.error('검색 중 오류 발생');
					}
				});
			} else {
				$('#results').hide();
			}
		}

		function displayResults(data) {
			var results = $('#results');
			results.empty();
			if (data.length > 0) {
				data
						.forEach(function(item) {
							var div = $('<div>').addClass('result-item');
							var thumbnailContainer = $('<div>').addClass(
									'search-thumbnail-container');
							var thumbnail1 = $('<img>').addClass(
									'search-thumbnail1').attr('src',
									item.thumbnail1).attr('alt',
									item.title + ' thumbnail');
							thumbnailContainer.append(thumbnail1);

							if (item.thumbnail2) {
								var thumbnail2 = $('<img>').addClass(
										'search-thumbnail2').attr('src',
										item.thumbnail2).attr('alt',
										item.title + ' thumbnail');
								thumbnailContainer.append(thumbnail2);
							}

							div.append(thumbnailContainer);
							div.append('<div><span>' + item.title
									+ '</span><br><span>' + item.authors
									+ '</span></div>');

							div
									.on(
											'click',
											function() {
												window.location.href = '${pageContext.request.contextPath}/webtoon/detail?id='
														+ item.id;
											});
							results.append(div);
						});
				results.show();
			} else {
				results.hide();
			}
		}
	</script>
</body>
</html>

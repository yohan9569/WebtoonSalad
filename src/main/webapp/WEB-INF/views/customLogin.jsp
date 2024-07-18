<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>웹툰 샐러드</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customLogin.css">
</head>
<body>
    <div class="login-container">
    	<div class="logo">
    		<img
				src="${pageContext.request.contextPath}/resources/images/text_logo.png"
				alt="로고 이미지" class="logo-image">
		</div>
        <div class="login-box">
            <h2>로그인</h2>
			<c:if test="${not empty error}">
		        <p class="err-msg"><c:out value="${error}"/></p>
		    </c:if>
            <form action="/webtoonsalad/login" method="post">
                <div class="input-group">
                    <label for="username">아이디</label>
                    <input type="text" id="username" name="username" autofocus="autofocus" placeholder="ID" required>
                </div>
                <div class="input-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit" class="login-button">로그인</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
            <div class="signup-link">
                <p>계정이 없으신가요? <a href="${pageContext.request.contextPath}/signup">회원가입</a></p>
            </div>
        </div>
        <aside class="advertisement">
		    <div class="ad">
		        <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="광고 이미지" class="ad-image">
		        <div class="ad-text">
		            <p>매일매일 신선한 웹툰을 한 눈에!</p>
		            <p><span class="webtoon">웹툰 </span><span class="salad">샐러드</span></p>
		        </div>
		    </div>
		</aside>
    </div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<header>
    <div class="logo">웹툰 샐러드</div>
    <div class="search-bar">
        <input type="text" placeholder="제목, 작가로  검색">
        <button type="button">검색</button>
    </div>
    <div class="auth-buttons">
        <button onclick="location.href='login.jsp'">로그인</button>
        <button onclick="location.href='signup.jsp'">회원가입</button>
    </div>
</header>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/home">홈</a></li>
        <li><a href="${pageContext.request.contextPath}/square">찜꽁</a></li>
        <li><a href="${pageContext.request.contextPath}/workroom">와글와글</a></li>
        <li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
    </ul>
</nav>

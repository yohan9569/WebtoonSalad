<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와글</title>
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
	
	<h2>register</h2>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
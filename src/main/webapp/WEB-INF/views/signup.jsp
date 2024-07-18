<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>회원가입</title>
</head>
<script type="text/javascript">
      $(document).ready(function(){
         // 취소 버튼 클릭 시 페이지 이동
         $(".cancel").on("click", function(){
        	 location.href = "${pageContext.request.contextPath}/home";
         });
         
         // 제출 버튼 클릭 시 폼 유효성 검사
         $("#submit").on("click", function(event){
            if($("#id").val() == ""){
               alert("아이디를 입력해주세요.");
               $("#id").focus();
               return false;
            }
            if($("#pw").val() == ""){
               alert("비밀번호를 입력해주세요.");
               $("#pw").focus();
               return false;   
            }
            if($("#name").val() == ""){
               alert("이름을 입력해주세요.");
               $("#name").focus();
               return false;
            }
         });
      });
   </script>
<body>
	<section id="container">
		<form:form action="${pageContext.request.contextPath}/signup"
			method="post" modelAttribute="userDTO">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="form-group has-feedback">
				<label class="control-label" for="id">아이디</label>
				<form:input path="id" id="id" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="pw">비밀번호</label>
				<form:input path="pw" id="pw" type="password" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이름</label>
				<form:input path="name" id="name" />
			</div>
			<div class="form-group has-feedback">
				<button type="submit" id="submit">가입하기</button>
				<button class="cancel" type="button">취소</button>
			</div>
		</form:form>
	</section>
</body>
</html>

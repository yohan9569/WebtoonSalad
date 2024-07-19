<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 - 웹툰 샐러드</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/signup.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="login-container">
		<div class="logo">
			<img
				src="${pageContext.request.contextPath}/resources/images/text_logo.png"
				alt="로고 이미지" class="logo-image">
		</div>
		<div class="login-box">
			<h2>회원가입</h2>
			<form:form action="${pageContext.request.contextPath}/signup"
				method="post" modelAttribute="userDTO">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="input-group">
					<label for="id">아이디</label>
					<form:input path="id" id="id" maxlength="16"
						placeholder="4~16자 이내로 입력" required="required" />
					<button type="button" id="checkId" class="check-button">중복
						확인</button>
				</div>
				<div class="input-group">
					<label for="pw">비밀번호</label>
					<form:input path="pw" id="pw" type="password" maxlength="16"
						placeholder="4~16자 이내로 입력" required="required" />
				</div>
				<div class="input-group">
					<label for="pwConfirm">비밀번호 확인</label> <input type="password"
						id="pwConfirm" maxlength="16" placeholder="4~16자 이내로 입력"
						required="required" />
				</div>
				<div class="input-group">
					<label for="name">닉네임</label>
					<form:input path="name" id="name" maxlength="8"
						placeholder="3~8자 이내로 입력" required="required" />
					<button type="button" id="checkName" class="check-button">중복
						확인</button>
				</div>
				<button type="submit" id="submit" class="login-button">가입하기</button>
				<button class="cancel-button" type="button">취소</button>

			</form:form>
			<div class="signup-link">
				<p>
					이미 계정이 있으신가요? <a
						href="${pageContext.request.contextPath}/customLogin">로그인</a>
				</p>
			</div>
		</div>
		<aside class="advertisement">
		<div class="ad">
			<img
				src="${pageContext.request.contextPath}/resources/images/logo.png"
				alt="광고 이미지" class="ad-image">
			<div class="ad-text">
				<p>매일매일 신선한 웹툰을 한 눈에!</p>
				<p>
					<span class="webtoon">웹툰 </span><span class="salad">샐러드</span>
				</p>
			</div>
		</div>
		</aside>
	</div>

	<script type="text/javascript">
        const csrfToken = '${_csrf.token}';
        const csrfHeader = '${_csrf.headerName}';
        $(document).ready(function() {
            $.ajaxSetup({
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(csrfHeader, csrfToken);
                }
            });

            var idChecked = false;
            var nameChecked = false;

            $("#checkId").on("click", function() {
                var id = $("#id").val();
                if (id == "") {
                    alert("아이디를 입력해주세요.");
                    $("#id").focus();
                    return false;
                }
                if (id.length < 4 || id.length > 16) {
                    alert("아이디는 4자 이상 16자 이하로 입력해주세요.");
                    $("#id").focus();
                    return false;
                }

                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/checkId",
                    data: { id: id },
                    success: function(response) {
                        if (response == "true") {
                            alert("사용할 수 있는 아이디입니다.");
                            idChecked = true;
                        } else {
                            alert("이미 존재하는 아이디입니다.");
                            idChecked = false;
                            $("#id").focus();
                        }
                    },
                    error: function() {
                        alert("아이디 중복 확인 중 오류가 발생했습니다.");
                    }
                });
            });

            $("#checkName").on("click", function() {
                var name = $("#name").val();
                if (name == "") {
                    alert("닉네임을 입력해주세요.");
                    $("#name").focus();
                    return false;
                }
                if (name.length < 3 || name.length > 8) {
                    alert("닉네임은 3자 이상 8자 이하로 입력해주세요.");
                    $("#name").focus();
                    return false;
                }

                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/checkName",
                    data: { name: name },
                    success: function(response) {
                        if (response == "true") {
                            alert("사용할 수 있는 닉네임입니다.");
                            nameChecked = true;
                        } else {
                            alert("이미 존재하는 닉네임입니다.");
                            nameChecked = false;
                            $("#name").focus();
                        }
                    },
                    error: function() {
                        alert("닉네임 중복 확인 중 오류가 발생했습니다.");
                    }
                });
            });

            $("#submit").on("click", function(event) {
                if ($("#id").val() == "") {
                    alert("아이디를 입력해주세요.");
                    $("#id").focus();
                    return false;
                }
                if ($("#id").val().length < 4 || $("#id").val().length > 16) {
                    alert("아이디는 4자 이상 16자 이하로 입력해주세요.");
                    $("#id").focus();
                    return false;
                }
                if (!idChecked) {
                    alert("아이디 중복 확인을 해주세요.");
                    $("#id").focus();
                    return false;
                }
                if ($("#pw").val() == "") {
                    alert("비밀번호를 입력해주세요.");
                    $("#pw").focus();
                    return false;
                }
                if ($("#pw").val().length < 4 || $("#pw").val().length > 16) {
                    alert("비밀번호는 4자 이상 16자 이하로 입력해주세요.");
                    $("#pw").focus();
                    return false;
                }
                if ($("#pwConfirm").val() == "") {
                    alert("비밀번호 확인을 입력해주세요.");
                    $("#pwConfirm").focus();
                    return false;
                }
                if ($("#pw").val() !== $("#pwConfirm").val()) {
                    alert("비밀번호 확인이 일치하지 않습니다.");
                    $("#pwConfirm").focus();
                    return false;
                }
                if ($("#name").val() == "") {
                    alert("닉네임을 입력해주세요.");
                    $("#name").focus();
                    return false;
                }
                if ($("#name").val().length < 3 || $("#name").val().length > 8) {
                    alert("닉네임은 3자 이상 8자 이하로 입력해주세요.");
                    $("#name").focus();
                    return false;
                }
            });

            $(".cancel-button").on("click", function() {
                location.href = "${pageContext.request.contextPath}/home";
            });
        });
    </script>
</body>
</html>

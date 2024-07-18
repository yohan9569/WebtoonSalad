<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>회원가입</title>
</head>
<script type="text/javascript">
    const csrfToken = '${_csrf.token}';
    const csrfHeader = '${_csrf.headerName}';
    $(document).ready(function() {
        $.ajaxSetup({
            beforeSend : function(xhr) {
                xhr.setRequestHeader(csrfHeader, csrfToken);
            }
        });

        var idChecked = false; // 아이디 중복 체크 여부
        var nameChecked = false; // 닉네임 중복 체크 여부

        // 아이디 중복 확인 버튼 클릭 시 AJAX 요청
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
                type : "POST",
                url : "${pageContext.request.contextPath}/checkId",
                data : { id : id },
                success : function(response) {
                    if (response == "true") {
                        alert("사용할 수 있는 아이디입니다.");
                        idChecked = true;
                    } else {
                        alert("이미 존재하는 아이디입니다.");
                        idChecked = false;
                        $("#id").focus();
                    }
                },
                error : function() {
                    alert("아이디 중복 확인 중 오류가 발생했습니다.");
                }
            });
        });

        // 닉네임 중복 확인 버튼 클릭 시 AJAX 요청
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
                type : "POST",
                url : "${pageContext.request.contextPath}/checkName",
                data : { name : name },
                success : function(response) {
                    if (response == "true") {
                        alert("사용할 수 있는 닉네임입니다.");
                        nameChecked = true;
                    } else {
                        alert("이미 존재하는 닉네임입니다.");
                        nameChecked = false;
                        $("#name").focus();
                    }
                },
                error : function() {
                    alert("닉네임 중복 확인 중 오류가 발생했습니다.");
                }
            });
        });

        // 제출 버튼 클릭 시 폼 유효성 검사
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
    });
</script>
<body>
    <section id="container">
        <form:form action="${pageContext.request.contextPath}/signup" method="post" modelAttribute="userDTO">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="form-group has-feedback">
                <label class="control-label" for="id">아이디</label>
                <form:input path="id" id="id" maxlength="16" autofocus="autofocus" placeholder="4~16자 이내로 입력" />
                <button type="button" id="checkId">중복 확인</button>
            </div>
            <div class="form-group has-feedback">
                <label class="control-label" for="pw">비밀번호</label>
                <form:input path="pw" id="pw" type="password" maxlength="16" placeholder="4~16자 이내로 입력"/>
            </div>
            <div class="form-group has-feedback">
                <label class="control-label" for="pwConfirm">비밀번호 확인</label> 
                <input type="password" id="pwConfirm" maxlength="16" placeholder="4~16자 이내로 입력"/>
            </div>
            <div class="form-group has-feedback">
                <label class="control-label" for="name">닉네임</label>
                <form:input path="name" id="name" maxlength="8" placeholder="3~8자 이내로 입력"/>
                <button type="button" id="checkName">중복 확인</button>
            </div>

            <div class="form-group has-feedback">
                <button type="submit" id="submit">가입하기</button>
                <button class="cancel" type="button">취소</button>
            </div>
        </form:form>
    </section>
</body>
</html>

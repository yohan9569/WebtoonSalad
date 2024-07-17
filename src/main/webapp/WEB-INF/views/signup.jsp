<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
   <head>
      <!-- 합쳐지고 최소화된 최신 CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
      <!-- 부가적인 테마 -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <title>회원가입</title>
   </head>
   <script type="text/javascript">
      $(document).ready(function(){
         // 취소
         $(".cancel").on("click", function(){
            location.href = "/customLogin";
         });

         $("#submit").on("click", function(){
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
               alert("성명을 입력해주세요.");
               $("#name").focus();
               return false;
            }
         });
      });
   </script>
   <body>
      <section id="container">
         <form:form action="${pageContext.request.contextPath}/signup" method="post" modelAttribute="userDTO">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group has-feedback">
               <label class="control-label" for="id">아이디</label>
               <form:input path="id" cssClass="form-control" id="id"/>
            </div>
            <div class="form-group has-feedback">
               <label class="control-label" for="pw">패스워드</label>
               <form:input path="pw" cssClass="form-control" id="pw" type="password"/>
            </div>
            <div class="form-group has-feedback">
               <label class="control-label" for="name">성명</label>
               <form:input path="name" cssClass="form-control" id="name"/>
            </div>
            <div class="form-group has-feedback">
               <button class="btn btn-success" type="submit" id="submit">회원가입</button>
               <button class="cancel btn btn-danger" type="button">취소</button>
            </div>
         </form:form>
      </section>
   </body>
</html>

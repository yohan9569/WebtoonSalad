<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Info</title>
    <script type="text/javascript">
        window.onload = function() {
            // 성공 메시지를 Model에서 가져와서 alert로 표시
            <c:if test="${not empty success}">
                alert("${success}");
            </c:if>
            // 오류 메시지를 Model에서 가져와서 alert로 표시
            <c:if test="${not empty error}">
                alert("${error}");
            </c:if>
        }
    </script>
</head>
<body>
    <div class="user-info">
        <h3>메롱</h3>
        <c:choose>
            <c:when test="${not empty user}">
                <p>ID: ${user.id}</p>
                <p>Name: ${user.name}</p>
            </c:when>
            <c:otherwise>
                <p>${error}</p>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="update-password">
        <h3>Update Password</h3>
        <form action="${pageContext.request.contextPath}/updatePassword" method="post">
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Update Password</button>
        </form>
    </div>
</body>
</html>

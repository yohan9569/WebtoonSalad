<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="user-info">
    <h2>회원 정보</h2>
    <form>
        <div>
            <label for="email">이메일 아이디</label>
            <input type="email" id="email" name="email" value="아이디 (read only)" readonly>
        </div>
        <div>
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <label for="password-confirm">비밀번호 확인</label>
            <input type="password" id="password-confirm" name="password-confirm">
        </div>
        <div>
            <label for="nickname">닉네임</label>
            <input type="text" id="nickname" name="nickname" value="닉네임">
        </div>
        <button type="submit">수정</button>
    </form>
</div>

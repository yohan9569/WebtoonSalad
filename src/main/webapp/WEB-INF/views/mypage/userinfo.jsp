<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="user-info">
    <h2>회원 정보 수정</h2>
    <form>
        <div>
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" value="아이디 (read only)" readonly>
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
            <label for="name">닉네임</label>
            <input type="text" id="name" name="name" value="닉네임">
        </div>
        <button type="submit">수정하기</button>
    </form>
</div>

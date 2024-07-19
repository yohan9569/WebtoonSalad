<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /* 모달 (배경) */
        .modal {
            display: none; /* 기본적으로 숨김 */
            position: fixed; /* 고정 위치 */
            z-index: 1; /* 최상단에 위치 */
            left: 0;
            top: 0;
            width: 100%; /* 전체 너비 */
            height: 100%; /* 전체 높이 */
            overflow: auto; /* 필요 시 스크롤 활성화 */
            background-color: rgb(0,0,0); /* 기본 색상 */
            background-color: rgba(0,0,0,0.4); /* 불투명 검정색 */
        }

        /* 모달 내용/박스 */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 상단에서 15% 떨어져서 중앙에 위치 */
            padding: 20px;
            border: 1px solid #888;
            width: 80%; /* 화면 크기에 따라 조절 가능 */
            text-align: center;
        }

        /* 닫기 버튼 */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        .modal-button {
            background-color: #ff007f; /* 분홍색 */
            color: white;
            border: none;
            padding: 10px 20px;
            margin: 10px;
            cursor: pointer;
        }

        .modal-button:hover {
            background-color: #ff3385;
        }

        .emoji {
            font-size: 50px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<!-- 모달 -->
<div id="myModal" class="modal">

  <!-- 모달 내용 -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <div class="emoji">😍</div>
    <p>로그인이 필요한 기능이에요. 지금 회원가입 혹은 로그인하고 웹툰 샐러드에서 더 다양한 기능을 함께해요</p>
    <button class="modal-button" id="signUpBtn">회원가입</button>
    <button class="modal-button" id="loginBtn">로그인</button>
  </div>

</div>

<script>
    // 모달 가져오기
    var modal = document.getElementById("myModal");

    // 모달을 닫는 <span> 요소 가져오기
    var span = document.getElementsByClassName("close")[0];

    // 사용자가 <span> (x)을 클릭하면 모달 닫기
    span.onclick = function() {
      modal.style.display = "none";
    }

    // 사용자가 모달 외부를 클릭하면 모달 닫기
    window.onclick = function(event) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
    }

    // 회원가입 버튼 클릭 시 처리
    document.getElementById("signUpBtn").onclick = function() {
      window.location.href = '<%= request.getContextPath() %>/signup';
    }

    // 로그인 버튼 클릭 시 처리
    document.getElementById("loginBtn").onclick = function() {
      window.location.href = '<%= request.getContextPath() %>/customLogin';
    }
</script>

</body>
</html>

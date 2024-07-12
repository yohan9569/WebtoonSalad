<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>웹툰 샐러드</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/webtoon/detail.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function toggleJjim(webtoonId) {
        console.log("Button clicked for webtoonId: " + webtoonId); // 버튼 클릭 확인용 로그 출력
        const toggleUrl = "${pageContext.request.contextPath}/jjim/toggleJjim?webtoonId=" + webtoonId;
        console.log("Toggle URL: " + toggleUrl); // 경로 확인용 로그 출력

        $.get(toggleUrl, function(response) {
            console.log("Response: ", response); // 응답 확인용 로그 출력

            if (response.error) {
                console.log("Error: " + response.error);
                return;
            }

            let button = $("button.btn-like");

            if (response.jjimExists) {
                button.html("찜꽁 ❤️ " + response.jjimCount);
            } else {
                button.html("찜꽁 🤍 " + response.jjimCount);
            }
        });
    }

    function addComment(webtoonId) {
        const commentContent = $('#newComment').val();
        if (!commentContent) {
            alert('댓글을 입력해주세요.');
            return;
        }

        $.ajax({
            url: '${pageContext.request.contextPath}/comments/write',
            type: 'GET',
            data: {
                content: commentContent,
                webtoonId: webtoonId
            },
            success: function(response) {
                alert('댓글이 성공적으로 추가되었습니다.');
                // 입력 창 새로고침
                $('#newComment').val('');
                loadComments(webtoonId); // 댓글 목록 새로고침
            },
            error: function(xhr, status, error) {
                alert('댓글 추가에 실패했습니다: ' + xhr.responseText);
            }
        });
    }

    function loadComments(webtoonId) {
        $.ajax({
            url: `${pageContext.request.contextPath}/comments/list`,
            type: 'GET',
            data: {
                webtoonId: webtoonId
            },
            success: function(response) {
                let commentsList = $('#commentsList');
                commentsList.empty(); // 기존 댓글 목록 삭제

                if (response.length > 0) {
                    response.forEach(function(comment) {
                        const userName = comment.user ? comment.user.name : 'Unknown';
                        /* const commentHtml = `
                            <div class="comment">
                                <strong>${userName}:</strong> ${comment.content}
                                <button class="btn-edit" data-content="${comment.content}">수정</button>
                                <button class="btn-delete">삭제</button>
                            </div>`;
                        commentsList.append(commentHtml); */
                        commentsList.append(
                                '<div class="comment"><strong>' + userName + ':</strong> ' + comment.content +
                                ' <button class="btn-edit" data-content="' + comment.content + '">수정</button>' +
                                ' <button class="btn-delete">삭제</button></div>'
                            );
                    });

                    // Add click event listeners for edit and delete buttons
                    $('.btn-edit').click(function() {
                        const commentContent = $(this).data('content');
                        const newContent = prompt('수정할 내용을 입력하세요:', commentContent);
                        if (newContent !== null) {
                            editComment(newContent, webtoonId);
                        }
                    });

                    $('.btn-delete').click(function() {
                        if (confirm('정말로 이 댓글을 삭제하시겠습니까?')) {
                            deleteComment(webtoonId);
                        }
                    });
                } else {
                    commentsList.append('<div class="no-comments">댓글이 없습니다.</div>');
                }
            },
            error: function(xhr, status, error) {
                alert('댓글 목록을 불러오는 데 실패했습니다: ' + xhr.responseText);
            }
        });
    }

    function deleteComment(webtoonId) {
        $.ajax({
            url: `${pageContext.request.contextPath}/comments/delete`,
            type: 'GET',
            data: {
                webtoonId: webtoonId
            },
            success: function(response) {
                alert('댓글이 성공적으로 삭제되었습니다.');
                loadComments(webtoonId); // 댓글 목록 새로고침
            },
            error: function(xhr, status, error) {
                alert('댓글 삭제에 실패했습니다: ' + xhr.responseText);
            }
        });
    }

    function editComment(content, webtoonId) {
        $.ajax({
            url: `${pageContext.request.contextPath}/comments/edit`,
            type: 'GET',
            data: {
                webtoonId: webtoonId,
                content: content
            },
            success: function(response) {
                alert('댓글이 성공적으로 수정되었습니다.');
                loadComments(webtoonId); // 댓글 목록 새로고침
            },
            error: function(xhr, status, error) {
                alert('댓글 수정에 실패했습니다: ' + xhr.responseText);
            }
        });
    }

    $(document).ready(function() {
        const webtoonId = `${detail.id}`;
        $('#addComment').click(function() {
            addComment(webtoonId);
        });
        loadComments(webtoonId); // 페이지 로드 시 댓글 목록을 불러옴
    });
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<main>
	<section class="webtoon-detail">
		<h1>웹툰</h1>
		<div class="webtoon-info">
			<div class="thumbnail-container">
				<img src="${detail.thumbnail1}" alt="thumbnail 1" class="thumbnail">
				<c:if test="${not empty detail.thumbnail2}">
					<img src="${detail.thumbnail2}" alt="thumbnail 2" class="thumbnail">
				</c:if>
			</div>
			<div class="details">
				<p>${detail.provider}</p>
				<h2>${detail.title}</h2>
				<p>연재 요일 | ${detail.updateDays}</p>
				<p>글/그림 | ${detail.authors} 글/그림</p>
				<c:if test="${detail.isAdult == 1}">
					<p>청소년 관람불가</p>
				</c:if>
				<c:if test="${detail.freeWaitHour == 1}">
					<p>기다리면 무료</p>
				</c:if>
				<p>최근 업로드 일자 | ${detail.lastUp}</p>
				<c:choose>
					<c:when test="${jjimExists}">
						<button class="btn-like" onclick="toggleJjim('${detail.id}')">찜꽁
							❤️ ${detail.jjimCount}</button>
					</c:when>
					<c:otherwise>
						<button class="btn-like" onclick="toggleJjim('${detail.id}')">찜꽁
							🤍 ${detail.jjimCount}</button>
					</c:otherwise>
				</c:choose>
				<button class="btn-view"
					onclick="window.location.href='${detail.url}'">바로 보기</button>
			</div>
		</div>
		<div class="comments-section">
			<div class="input-section">
				<input type="text" id="newComment" placeholder="한줄평 입력">
				<button id="addComment">추가</button>
			</div>
			<div id="commentsList"></div>
			<!-- 댓글 목록을 표시할 위치 -->
			<div id="commentTemplate" style="display: none;">
				<div class="comment">
					<strong class="user-name"></strong>: <span class="comment-content"></span>
					<button class="btn-edit">수정</button>
					<button class="btn-delete">삭제</button>
				</div>
			</div>
		</div>
		</div>
		<div class="ad-placeholder">
			<button class="btn-ad">스포 방지 버튼</button>
		</div>
	</section>
	</main>
	<aside class="sidebar right-sidebar"></aside>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>

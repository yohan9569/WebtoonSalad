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
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/aside.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        //CSRF 토큰 설정
        const csrfToken = '${_csrf.token}';
        const csrfHeader = '${_csrf.headerName}';

        $(document).ready(function() {
            const userId = '${userId}';
            const webtoonId = '${detail.id}';
            $.ajaxSetup({
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(csrfHeader, csrfToken);
                }
            });
            // 로그인 여부 확인 후 댓글 로드
            if (userId && userId !== "guest") {
                loadComments(userId, webtoonId); // 페이지 로드 시 한줄평 목록을 불러옴
                $('#addComment').click(function() {
                    addComment(userId, webtoonId);
                });
            } else {
                $('#loginMessage').show(); // 로그인하지 않은 경우 로그인 안내 메시지를 표시
            }
            
            $('.btn-ad').click(function() {
                loadCommentsExceptMine(userId, webtoonId);
            });
        });

        function toggleJjim(userId, webtoonId) {
            if (!userId || userId === "guest") {
                var modal = document.getElementById("myModal");
                modal.style.display = "block";
                return;
            }
            const toggleUrl = `${pageContext.request.contextPath}/webtoonsalad/jjim/toggleJjim?userId=${userId}&webtoonId=${detail.id}`;

            $.get(toggleUrl, function(response) {

                if (response.error) {
                    console.log("Error: " + response.error);
                    return;
                }

                let button = $("button.btn-jjim");

                if (response.jjimExists) {
                    button.html("찜꽁 ❤️ " + response.jjimCount);
                } else {
                    button.html("찜꽁 🤍 " + response.jjimCount);
                }
            });
        }

        function addComment(userId, webtoonId) {
            const commentContent = $('#newComment').val();
            if (!commentContent) {
                alert('한줄평을 입력해주세요.');
                return;
            }

            $.ajax({
                url: '${pageContext.request.contextPath}/comments/write',
                type: 'POST',
                data: {
                    content: commentContent,
                    userId: userId,
                    webtoonId: webtoonId
                },
                success: function(response) {
                    alert('한줄평이 성공적으로 추가되었습니다.');
                    // 입력 창 새로고침
                    $('#newComment').val('');
                    $('#commentInputSection').hide(); // 한줄평 입력 섹션 숨기기
                    loadComments(userId, webtoonId); // 한줄평 목록 새로고침
                },
                error: function(xhr, status, error) {
                    alert('한줄평 추가에 실패했습니다: ' + xhr.responseText);
                }
            });
        }

        function loadComments(userId, webtoonId) {
            getMyComment(userId, webtoonId, function(comment) {
                let commentsList = $('#commentsList');
                commentsList.empty(); // 기존 한줄평 목록 삭제

                if (comment) {
                    getLikeCount(comment.id, function(likeCount) {
                        let likeButton = '<button class="btn-like" data-comment-id="' + comment.id + '">' 
                                        + (comment.exists ? '😍 ' : '😀 ') + likeCount + '</button>';

                        commentsList.append('<div class="comment"><div class="comment-header"><strong> 내 한줄평 </strong></div> ' + '<div class="comment-content">' + comment.content + '</div>' 
                              +'<div class="comment-actions">'
                                            + likeButton 
                                            + ' <button class="btn-edit" data-content="' + comment.content + '">수정</button>' 
                                            + ' <button class="btn-delete">삭제</button>' 
                                            + ' <span class="create-date">' + new Date(comment.create_date).toISOString().split('T')[0] + '</span></div></div>');

                        $('.btn-like').click(function() {
                            const commentId = $(this).data('comment-id');
                            const button = $(this);
                            toggleLike(commentId, userId, function(response) {
                                //alert(response.message);
                                if (response.status === "liked") {
                                    button.text('😍 ' + likeCount);
                                } else if (response.status === "unliked") {
                                    button.text('😀 ' + likeCount);
                                }
                                // 좋아요 수 갱신
                                getLikeCount(commentId, function(newLikeCount) {
                                    button.text((response.status === "liked" ? '😍 ' : '😀 ') + newLikeCount);
                                });
                            });
                        });

                        $('.btn-edit').click(function() {
                            const commentId = $(this).data('comment-id'); // comment-id를 가져옴
                            const commentContent = $(this).data('content');
                            $('#commentInputSection').show(); // 수정 입력 섹션 표시
                            $('#newComment').val(commentContent); // 기존 내용 입력 필드에 설정
                            $('#addComment').hide(); // 추가 버튼 숨기기
                            $('#editComment').show(); // 수정 버튼 보이기

                            $('.comment').hide(); // 모든 댓글 숨기기
                            $('.comment[data-comment-id="' + commentId + '"]').hide(); // 수정 중인 댓글 숨기기

                            $('#editComment').off('click').on('click', function() {
                                const newContent = $('#newComment').val();
                                editComment(newContent, userId, webtoonId, commentId);
                            });
                        });

                        $('.btn-delete').click(function() {
                            if (confirm('정말로 이 한줄평을 삭제하시겠습니까?')) {
                                deleteComment(userId, webtoonId);
                            }
                        });
                    });
                } else {
                    $('#commentInputSection').show(); // 한줄평 입력 섹션 표시
                    $('#addComment').off('click').on('click', function() {
                        addComment(userId, webtoonId);
                    });
                }
            });
        }

        function getMyComment(userId, webtoonId, callback) {
            const url = `${pageContext.request.contextPath}/comments/mycomment`;
            
            $.ajax({
                url: url,
                type: 'GET',
                data: {
                    userId: userId,
                    webtoonId: webtoonId
                },
                success: function(response) {
                    if (response === null) {
                        console.log('No comment found');
                    }
                    callback(response);
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching comment:', status, error); // 에러 로그 추가
                    console.error('Status code:', xhr.status); // 상태 코드 추가
                    console.error('Response text:', xhr.responseText); // 응답 본문 추가
                    alert('한줄평 목록을 불러오는 데 실패했습니다: ' + xhr.responseText);
                }
            });
        }


        function getLikeCount(commentId, callback) {
            $.ajax({
                url: `${pageContext.request.contextPath}/comments/likes/count`,
                type: 'GET',
                data: {
                    commentId: commentId
                },
                success: function(response) {
                    callback(response);
                },
                error: function(xhr, status, error) {
                    alert('좋아요 수를 불러오는 데 실패했습니다: ' + xhr.responseText);
                }
            });
        }

        function toggleLike(commentId, userId, callback) {
            $.ajax({
                url: `${pageContext.request.contextPath}/comments/likes/toggle`,
                type: 'POST',
                data: {
                    userId: userId,
                    commentId: commentId
                },
                success: function(response) {
                    callback(response);
                },
                error: function(xhr, status, error) {
                    alert('좋아요 상태를 변경하는 데 실패했습니다: ' + xhr.responseText);
                }
            });
        }

        function deleteComment(userId, webtoonId) {
            $.ajax({
                url: `${pageContext.request.contextPath}/comments/delete`,
                type: 'POST',
                data: {
                    userId: userId,
                    webtoonId: webtoonId
                },
                success: function(response) {
                    alert('한줄평이 성공적으로 삭제되었습니다.');
                    loadComments(userId, webtoonId); // 한줄평 목록 새로고침
                },
                error: function(xhr, status, error) {
                    alert('한줄평 삭제에 실패했습니다: ' + xhr.responseText);
                }
            });
        }

        function editComment(content, userId, webtoonId) {
            $.ajax({
                url: `${pageContext.request.contextPath}/comments/edit`,
                type: 'POST',
                data: {
                    userId: userId,
                    webtoonId: webtoonId,
                    content: content
                },
                success: function(response) {
                    alert('한줄평이 성공적으로 수정되었습니다.');
                    $('#commentInputSection').hide();
                    loadComments(userId, webtoonId); // 한줄평 목록 새로고침
                },
                error: function(xhr, status, error) {
                    alert('한줄평 수정에 실패했습니다: ' + xhr.responseText);
                }
            });
        }


        function loadCommentsExceptMine(userId, webtoonId) {
            
            $.ajax({
                url: `${pageContext.request.contextPath}/comments/list`,
                type: 'GET',
                data: {
                   userId: userId,
                    webtoonId: webtoonId,
                },
                success: function(response) {
                    let commentsList = $('<div class="review-card-section"></div>'); // 새로운 div 생성하여 한줄평 목록 저장
                    if (response.length > 0) {
                        response.forEach(function(comment) {
                            const userName = comment.user ? comment.user.name : 'Unknown';
                            
                            getLikeCount(comment.id, function(likeCount) {
                                const likeButtonInitialText = comment.exists ? '😍 ' + likeCount : '😀 ' + likeCount;

                                commentsList.append(
                                      
                                       '<div class="review-card">' 
                                       + '<div class="user-info">' 
                                           + '<div class="username">' + '👤 ' + userName + '</div>' 
                                       + '</div>' 
                                       + '<div class="review-text">' + comment.content + '</div>' 
                                       + '<hr class="divider">' 
                                       + '<div class="like-section">' 
                                           + ' <button class="btn-like" data-comment-id="' + comment.id + '">' + likeButtonInitialText + '</button>' 
                                       + '</div>' 
                                       + '<div class="create-date">' + new Date(comment.create_date).toISOString().split('T')[0] + '</div>'
                                       + '</div>'
                                       
                                   );

                                $('#ad-placeholder').html(commentsList); // ad-placeholder 자리에 한줄평 목록을 추가
                                $('.review-card').show(); // review-card 요소를 모두 보이도록 설정
                                $('.btn-ad').hide(); // btn-ad 버튼 숨기기

                                $('.btn-like').off('click').on('click', function() {
                                    if (userId === "guest") {
                                       // 모달 열기
                                        var modal = document.getElementById("myModal");
                                        modal.style.display = "block";
                                        return;
                                    }

                                    const commentId = $(this).data('comment-id');
                                    const button = $(this);
                                    toggleLike(commentId, userId, function(response) {
                                        //alert(response.message);
                                        // 좋아요 수 갱신
                                        getLikeCount(commentId, function(newLikeCount) {
                                            if (response.status === "liked") {
                                                button.text('😍 ' + newLikeCount);
                                            } else if (response.status === "unliked") {
                                                button.text('😀 ' + newLikeCount);
                                            }
                                        });
                                    });
                                });
                            });
                        });
                    } else {
                        commentsList.append('<div class="no-comments">한줄평이 없습니다.</div>');
                        $('#ad-placeholder').html(commentsList); // ad-placeholder 자리에 한줄평 목록을 추가
                        $('.btn-ad').hide(); // btn-ad 버튼 숨기기
                    }
                },
                error: function(xhr, status, error) {
                    alert('한줄평 목록을 불러오는 데 실패했습니다: ' + xhr.responseText);
                }
            });
        }

        function updateLastView(userId, webtoonId) {
            $.ajax({
                url: '${pageContext.request.contextPath}/jjim/updateLastView',
                type: 'POST',
                data: {
                    userId: userId,
                    webtoonId: webtoonId,
                    _csrf: '${_csrf.token}' // CSRF 토큰 추가
                },
                success: function(response) {
                    if (response === "success") {
                        reloadWebtoonList(userId); // 웹툰 목록을 다시 불러옵니다.
                    } else {
                        alert("lastview 업데이트에 실패했습니다.");
                    }
                },
                error: function(xhr, status, error) {
                    alert("lastview 업데이트 중 오류가 발생했습니다. 상태: " + status + ", 오류: " + error);
                }
            });
        }

        function reloadWebtoonList(userId) {
            $.ajax({
                url: '${pageContext.request.contextPath}/jjim/list',
                type: 'GET',
                data: {
                    userId: userId
                },
                success: function(response) {
                    var tempDiv = $('<div>').html(response); // 응답을 임시로 div에 넣습니다.
                    var newContent = tempDiv.find('#webtoonItems').html();
                    $('#webtoon-items').html(newContent);
                },
                error: function(xhr, status, error) {
                    alert("웹툰 목록을 불러오는 중 오류가 발생했습니다. 상태: " + status + ", 오류: " + error);
                }
            });
        }
    </script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp" /> 
    <jsp:include page="/WEB-INF/views/modal.jsp" />
    <main>
        <jsp:include page="/WEB-INF/views/leftaside.jsp" />
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
                    <p>글/그림 | ${detail.authors}</p>
                    <c:if test="${detail.isAdult == 1}">
                        <p>청소년 관람불가</p>
                    </c:if>
                    <c:if test="${detail.freeWaitHour == 1}">
                        <p>기다리면 무료</p>
                    </c:if>
                    <p>최근 업로드 일자 | ${detail.lastUp}</p>

                    <c:choose>
                        <c:when test="${userId == 'guest'}">
                            <button class="btn-jjim"
                                onclick="toggleJjim('${userId}', '${detail.id}')">찜꽁 🤍
                                ${detail.jjimCount}</button>
                        </c:when>
                        <c:when test="${jjimExists}">
                            <button class="btn-jjim"
                                onclick="toggleJjim('${userId}', '${detail.id}')">찜꽁 ❤️
                                ${detail.jjimCount}</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn-jjim"
                                onclick="toggleJjim('${userId}', '${detail.id}')">찜꽁 🤍
                                ${detail.jjimCount}</button>
                        </c:otherwise>
                    </c:choose>

                    <button class="btn-view"
                        onclick="updateLastView('${userId}', '${detail.id}'); window.open('${detail.url}', '_blank');">바로보기
                    </button>
                </div>
            </div>
            
            <div class="comments-section">
               <h1>한줄평✍️</h1>
                <div id="commentInputSection" class="input-section" style="display: none;">
                    <label for="newComment">🙋 내 한줄평</label>
                    <div class="CommentWrite">
                       <input type="text" id="newComment" placeholder="한줄평 입력">
                       <button id="addComment">추가</button>
                       <button id="editComment" style="display: none;">수정</button>   
                    </div>
                </div>
                <div id="loginMessage" class="input-section" style="display: none;">
                 <p>한줄평 작성은 로그인 후, 이용 가능합니다.</p>
             </div>
                <div id="commentsList"></div>
            </div>
            
            <div class="ad-placeholder" id="ad-placeholder">
                <button class="btn-ad">스포 방지 버튼</button>            
            </div>
        </section>
    </main>
    <aside class="sidebar right-sidebar"></aside>
    <jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
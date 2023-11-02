<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%@ include file="./header.jsp" %>
        <div class="container">
            <section class="view_rc_container">
                <h2>레시피 순서</h2>
                <div class="view_step">
                    <div id="stepDiv1" class="stepDiv">
                        <div class="stepBox">
                            <p id="s_num1" class="s_num">Step <span>1</span></p>
                            <p id="stepP1" class="stepP">맛있는 계란말이 찜을 다같이 먹어봅시다아아아아아아아아아</p>
                        </div>
                        <div id="stepImg1" class="stepImg"><img src="" alt=""></div>
                    </div>
                    <div id="stepDiv1" class="stepDiv">
                        <div class="stepBox">
                            <p id="s_num1" class="s_num">Step <span>2</span></p>
                            <p id="stepP1" class="stepP">계란 송송 파 탁탁 소금 촵촵</p>
                        </div>
                        <div id="stepImg1" class="stepImg"><img src="" alt=""></div>
                    </div>
                    <div id="stepDiv1" class="stepDiv">
                        <div class="stepBox">
                            <p id="s_num1" class="s_num">Step <span>3</span></p>
                            <p id="stepP1" class="stepP">오이시쿠나레 모에모에 큥</p>
                        </div>
                        <div id="stepImg1" class="stepImg"><img src="" alt=""></div>
                    </div>
                </div>
                <div class="good"><button>좋아요<p>13</p></button></div>
            </section>
            <section class="tag_section">
                <div class="tagDiv">
                    <div class="tagP">태그</div>
                    <ul>
                        <li><a href="">#계란</a></li>
                        <li><a href="">#파</a></li>
                        <li><a href="">#간단요리</a></li>
                        <li><a href="">#다이어트</a></li>
                    </ul>
                </div>
            </section>
            <section class="reply_section">
                <h4 class="rc_reply">댓글 <span>2</span></h4>
                <form class="rc_reply_form">
                    <div class="rc_reply_table">
                        <ul>
                            <li class="reply_nick">상창</li>
                            <li class="reply_date">2022-12-23 17:01</li>
                            <li class="reply_update"><a href="">수정</a></li>
                            <li class="reply_delete"><a href="">삭제</a></li>
                            <li class="reply_report"><a href="">신고</a></li>
                        </ul>
                        <tr>
                            <td colspan="3" class="reply_content">너무너무 맛있어 보인다</td>
                        </tr>
                    </div>
                    <div class="rc_reply_table">
                        <ul>
                            <li class="reply_nick">또기</li>
                            <li class="reply_date">2022-12-23 17:41</li>
                            <li class="reply_update"><a href="">수정</a></li>
                            <li class="reply_delete"><a href="">삭제</a></li>
                            <li class="reply_report"><a href="">신고</a></li>
                        </ul>
                        <tr>
                            <td colspan="3" class="reply_content">계란 좋아</td>
                        </tr>
                    </div>
                </form>
                <form action="" class="reply_textareaForm">
                    <ul>
                        <li>
                            <textarea class="rc_reply_ta" name="rc_reply" id="" cols="30" rows="3" placeholder="댓글을 남겨주세요!!"></textarea>
                        </li>
                        <li>
                            <button class="rc_reply_btn">댓글작성</button>
                        </li>
                    </ul>
                </fo>
                </form>
            </section>
        </div>
        <%@ include file="./footer.jsp" %>
</body>
</html>
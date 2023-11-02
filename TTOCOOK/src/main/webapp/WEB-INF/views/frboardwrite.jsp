<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:자유게시판</title>
    <%@include file="./header.jsp" %>
        <div class="container">
            <section class="ck_boardpan">
                <h2>자유게시판</h2>
                <form action="">
                    <table class="ck_boardpanTbl">
                        <tr>
                            <td colspan="2">글쓰기</td>
                        </tr>
                        <tr class="ck_boardpanTitle">
                            <td><label for="">제목</label></td>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea name="" id="" cols="30" rows="10"></textarea></td>
                        </tr>
                        <tr>
                            <td>첨부파일</td>
                            <td><input type="file" style="border : none"></td>
                        </tr>
                    </table>
                    <ul class="ck_boardpanBtn">
                        <li><button>작성</button></li>   
                        <li><button>목록</button></li>
                    </ul>
                </form>
            </section>
        </div>
        <footer class="footer">
            <div class="footerIn">
                <p>대표 : 문상석 | E : mss3662352@naver.com | TEL : 010-0000-0000 | 울산광역시 남구 삼산중로100번길 26, 케이엠 빌딩 1~4층</p>
                <p>문의전화 : 010-0000-0000 | 사업자등록번호 000-00-00000 | 통신판매업신고 0000 | 벤처기업확인 | 사업자정보확인</p>
                <p>&copy;Copyright 또쿡 Inc. All Rights Reserved</p>
                <p class="ft_logo">logo이미지</p>
            </div>
        </footer>
    </div>
    <script src="./js/script.js"></script>
</body>
</html>
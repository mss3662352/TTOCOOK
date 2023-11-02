<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:홈</title>
    
	<%@include file="./header.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
        <div class="container">
            <section class="eventSlide">
                <h2 class="event">이벤트</h2>
                <div class="eventImg">
                    <div><a href="#"><img src="./img/topic-1.jpg" alt="이벤트1"></a></div>
                    <div><a href="#"><img src="./img/topic-2.jpg" alt="이벤트2"></a></div>
                    <div><a href="#"><img src="./img/topic-3.jpg" alt="이벤트3"></a></div>
                    <div><a href="#"><img src="./img/topic-3.jpg" alt="이벤트4"></a></div>
                    <div><a href="#"><img src="./img/topic-3.jpg" alt="이벤트5"></a></div>
                </div>
                <p class="eventBtnL">
                    <a href="">
                        <img src="" alt="">
                    </a>
                </p>
                <p class="evnetBtnR">
                    <a href="">
                        <img src="" alt="">
                    </a>
                </p>
                <div class="eventPager">
                    <ul>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                    </ul>
                </div>
            </section>
            <section class="recipeSlide">
                <h2>추천 레시피</h2>
                <ul class="recipeImg">
                    <li>
                       	<div class="recipeBox">
	                        <div class="recipePic">
	                            <a href=""><img src="./img/no_image.png" alt=""></a>
	                        </div>
	                        <div class="recipeCon">
	                            <p class="recipeName">요리이름</p>
	                            <p class="recipeIng">재료</p>
	                            <p>추천수 댓글수</p>
	                        </div>
                       	</div>
                    </li>
                    <li>
                       	<div class="recipeBox">
	                        <div class="recipePic">
	                            <a href=""><img src="./img/no_image.png" alt=""></a>
	                        </div>
	                        <div class="recipeCon">
	                            <p class="recipeName">요리이름</p>
	                            <p class="recipeIng">재료</p>
	                            <p>추천수 댓글수</p>
	                        </div>
                       	</div>
                    </li>
                    <li>
                       	<div class="recipeBox">
	                        <div class="recipePic">
	                            <a href=""><img src="./img/no_image.png" alt=""></a>
	                        </div>
	                        <div class="recipeCon">
	                            <p class="recipeName">요리이름</p>
	                            <p class="recipeIng">재료</p>
	                            <p>추천수 댓글수</p>
	                        </div>
                       	</div>
                    </li>
                    <li>
                       	<div class="recipeBox">
	                        <div class="recipePic">
	                            <a href=""><img src="./img/no_image.png" alt=""></a>
	                        </div>
	                        <div class="recipeCon">
	                            <p class="recipeName">요리이름</p>
	                            <p class="recipeIng">재료</p>
	                            <p>추천수 댓글수</p>
	                        </div>
                       	</div>
                    </li>
                </ul>
            </section>
            <section class="comunity">
                <h2>커뮤니티</h2>
                <div class="comuBoard">
                    <div class="cookComu">
                        <h3><a href="<c:url value='/board/cook'/>">요리게시판</a></h3>
                        <p><a href="<c:url value='/board/cook'/>">더보기</a></p>
                        <ul>
                            <li><a href="">dknkfdnknfk</a></li>
                            <li><a href="">ernienrienri</a></li>
                            <li><a href="">ekrnsknkdtnk</a></li>
                            <li><a href="">qwerzasdgsd</a></li>
                            <li><a href="">dnfikdnfkdf</a></li>
                        </ul>
                    </div>
                    <div class="freeComu">
                        <h3><a href="<c:url value='/board/free'/>">자유게시판</a></h3>
                        <p><a href="<c:url value='/board/free'/>">더보기</a></p>
                        <ul>
                            <li><a href="">eerdfsa</a></li>
                            <li><a href="">efdsafienri</a></li>
                            <li><a href="">rerdfdknkdtnk</a></li>
                            <li><a href="">vcxvdfsgsd</a></li>
                            <li><a href="">fefreadnfkdf</a></li>
                        </ul>
                    </div>
                </div>
            </section>
        </div>
<%@include file="./footer.jsp" %>
<script>
    $('.eventImg').slick({
	    arrows: false,
	    slidesToShow: 3,
	    slidesToScroll: 1,
	    autoplay: true,
	    autoplaySpeed: 2500,
	    varibleWidth :  true,
	    dots : true,
	    dotsClass : 'eventImg_pager'
	});
</script>
</body>
</html>
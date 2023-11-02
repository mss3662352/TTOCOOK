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
            <section class="view_rc">
                <h2>레시피 보기</h2>
                <div class="view_rcMenu">
                    <p class="chooseIng">재료 정하기</p>
                    <ul class="view_rcIng">
                        <li class="on"><a href="">전체</a></li>
                        <li><a href="">소고기</a></li>
                        <li><a href="">돼지고기</a></li>
                        <li><a href="">닭고기</a></li>
                        <li><a href="">육류</a></li>
                        <li><a href="">해물류</a></li>
                        <li><a href="">채소류</a></li>
                        <li><a href="">기타</a></li>
                    </ul>	
                </div>
                <div class="recipeContainer">
                    <ul class="recipeList">
	                    <c:forEach var="recipeDto" items="${list}">
	                    	<li>
	                    		<div class="recipeBox">
			                        <div class="recipePic">
			                            <a href="<c:url value='/recipe/view${ph.sc.getQueryString()}&rcno=${recipeDto.rcno}'/>">
			                            	<img src="./img/no_image.png" alt="">
			                            </a>
			                        </div>
			                        <div class="recipeCon">
			                            <p class="recipeName">요리이름</p>
			                            <p class="recipeIng">재료</p>
			                            <p>추천수 댓글수</p>
			                        </div>
		                       	</div>
	                    	</li>
	                    </c:forEach>
                    </ul>
                </div>
                <div class="paging_container">
					<c:if test="${ph.getTotalCnt()!=null && ph.getTotalCnt()!=0}">
						<div class="page_container">
					       	<c:if test="${ph.showPrev}">
					       		<div class="page">
					       		<a href="<c:url value='/board/cook${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>
					       		</div>   
					       	</c:if>
					       	
					       	<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
					       		<div class='${i==ph.sc.page? "paging-active" : "page"}'>
					       		<a href="<c:url value='/board/cook${ph.sc.getQueryString(i)}'/>"> ${i}</a>
					       		</div>
					       	</c:forEach>
					       	
					       	<c:if test="${ph.showNext}">
					       		<div class="page">
					       			<a href="<c:url value='/board/cook${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>
					       		</div>   
					       	</c:if>
					  	</div>
			   		</c:if>
				</div>
            </section>
        </div>
    <%@ include file="./footer.jsp" %>
    <script>
        $(function(){
                $v = $('.view_rcIng li');
                $v.on('click', function(e){
                e.preventDefault();

                $v.removeClass('on');

                $(this).addClass('on');

            })
        })
    </script>
</body>
</html>
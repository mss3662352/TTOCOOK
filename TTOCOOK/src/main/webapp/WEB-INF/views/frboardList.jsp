<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:자유게시판</title>
  
<%@include file="./header.jsp" %>

<script>
	let msg="${msg}";
	
	if(msg == "DEL_OK") alert("게시글이 삭제되었습니다.");
	if(msg == "DEL_ERR") alert("게시글 삭제에 실패하였습니다.");
    if(msg=="LIST_ERR")  alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
	if(msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
	if (msg == "MOD_OK") alert("게시글 수정을 성공하였습니다.")
</script>
<div class="container">
    <section class="community">
        <h2>자유게시판</h2>
        <div class="ck_board">
            <p>총 게시물 <span>${ph.getTotalCnt()}개</span></p>
            <ul class="ck_best">
                <li><button>인기글</button></li>
                <li><button>추천글</button></li>
                <li><button type="button" id="ckListBtn">목록</button></li>
            </ul>
            <table class="ck_boardTbl">  
                <tr class="ck_list">
                    <td>게시물번호</td>
                    <td>작성자</td>
                    <td>제목</td>
                    <td>파일</td>
                    <td>등록일</td>
                    <td>조회수</td>
                    <td>추천수</td>
                </tr>
                <c:forEach var="frboardDto" items="${list}">
			       	<tr class="ck_content">
			           <td>${frboardDto.frbno}</td>
			           <td>${frboardDto.frbwriter}</td>
			           <td><a href="<c:url value='/board/frread${ph.sc.getQueryString() }&frbno=${frboardDto.frbno } '/>">
			           		<c:out value="${frboardDto.frbtitle}"/>
			           </a></td>
			           <td>X</td>
			           <c:choose>
				            <c:when test="${frboardDto.frbdate.time >= startOfToday}">
				              	<td class="regdate"><fmt:formatDate value="${frboardDto.frbdate}" pattern="HH:mm" type="time"/></td>
				            </c:when>
				            <c:otherwise>
				              	<td class="regdate"><fmt:formatDate value="${frboardDto.frbdate}" pattern="yyyy-MM-dd" type="date"/></td>
				            </c:otherwise>
		          		</c:choose>
			           <td>${frboardDto.frview_cnt}</td>
			           <td>${frboardDto.frgood_cnt}</td>
			       </tr>
				</c:forEach>
				<c:if test="${ph.getTotalCnt()==null || ph.getTotalCnt()==0}">
					<tr>
						<td colspan="7" class="no_board">게시물이 없습니다.</td>
					</tr>
				</c:if>
            </table>
            
            <button class="ck_write" onclick="location.href='<c:url value="/board/frwrite"/>'">글 작성</button>
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
		<form action="<c:url value='/board/cook'/>" class="ck_scBar" method="get">
		        <select name="search-option" name="option" class="ck_se">
		            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
		            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목</option>
		            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
		        </select>
		        <input type="text" name="keyword" class="ck_input" value="${ph.sc.keyword }" placeholder="검색어 입력">
		        <button type="submit" class="ck_scBtn">검색</button>
		    	<button type="reset" class="ck_rsBtn">초기화</button>
		</form>
		
	</section>
</div>
	<%@include file="./footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:요리게시판</title>
    
    <%@ include file="./header.jsp" %>
    <script type="text/javascript">
		let msg="${msg}"
		if(msg =="MOD_ERROR") alert("게시글 수정에 실패하였습니다. 확인해주세요!");
		
	</script>
        <div class="container">
            <section class="ck_board_read">
                <h2>요리게시판</h2>
                <form action="" id="ckFrm" class="ck_board_read_frm">
                    <table class="ck_board_read_tbl">
                        <tr>
                            <td colspan="8" class="ck_board_read_title">요리게시판 글 읽기</td>
                        </tr>
                        <tr>
                            <td colspan="1">제목</td>
                            <td colspan="7" style="padding-left: 10px;">${boardDto.ckbtitle }</td>
                        </tr>
                        <tr>
	                        <td>번호</td>
	                        <td style="width: 100px;">${boardDto.ckbno}</td>
	                        <td style="width: 100px;">작성자</td>
	                        <td style="width: 200px;">${boardDto.ckbwriter}</td>
	                        <td style="width: 100px;">추천수</td>
	                        <td style="width: 100px;">${boardDto.ckgood_cnt }</td>
	                        <td style="width: 100px;">조회수</td>
	                        <td style="width: 100px;">${boardDto.ckview_cnt }</td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td colspan="7">${boardDto.ckbcon }</td>
                        </tr>
                        
                    </table>
                    <ul class="ck_board_readBtn">
                        <li><button type="button" id="modifyBtn" ${boardDto.ckbwriter == nickname ? "":'style="display:none;"' }>수정</button></li>
                        <li><button type="button" id="removeBtn" ${boardDto.ckbwriter == nickname ? "":'style="display:none;"' }>삭제</button></li>   
                        <li><button type="button" id="listBtn" class="ck_boardpanBtn_list">목록</button></li>
                    </ul>
                    <input type="hidden" name="ckbno" value="${boardDto.ckbno}">
                    <input type="hidden" name="writer" value="${boardDto.ckbwriter}">
                    
                    
                </form>
            </section>
        </div>
        <%@ include file="./footer.jsp" %>
	<script>
		$("#listBtn").on('click', function(){
			location.href="<c:url value='/board/cook?page=${page}&pageSize=${pageSize}'/>"
			
		})
		$("#removeBtn").on("click", function(){
			if(!confirm("정말로 삭제하시겠습니까?")) return;
			
			let form = $("#ckFrm");
			form.attr("action", "<c:url value='/board/ckremove?page=${page}&pageSize=${pageSize}'/>");
			form.attr("method", "post");
			
			form.submit();
		})
		$("#modifyBtn").on("click", function(){
			
			let form = $("#ckFrm");
			form.attr("action", "<c:url value='/board/ckmodify'/>");
			form.attr("method", "get");
			
			form.submit();

		})
		
		
	</script>
</body>
</html>
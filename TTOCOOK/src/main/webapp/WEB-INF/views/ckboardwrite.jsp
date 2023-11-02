<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:요리게시판</title>
    
    <%@ include file="./header.jsp" %>
    	
        <div class="container">
            <section class="ck_boardpan">
                <h2>요리게시판</h2>
                <form action="<c:url value='/board/ckwrite'/>" method="post">
                	<input type="hidden" name="ckbno" value=${boardDto.ckbno }>
                    <table class="ck_boardpanTbl">
                        <tr>
                            <td colspan="2">글쓰기</td>
                        </tr>
                        <tr class="ck_boardpanTitle">
                            <td><label for="">제목</label></td>
                            <td><input type="text" name="ckbtitle" id="wr_ckbtitle"></td>
                        </tr>
                        <tr>
                        	<td>작성자</td>
                        	<td><input type="text" name="ckbwriter" value="${boardDto.ckbwriter }" readonly="readonly" style="border: none; background: transparent;"></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea name="ckbcon" id="wr_ckbcon" cols="30" rows="10" ></textarea></td>
                        </tr>
                        <tr>
                            <td>첨부파일</td>
                            <td><input type="file" name="file" multiple="multiple"  style="border : none"></td>
                        </tr>
                        
                    </table>
                    <ul class="ck_boardpanBtn">
                        <li><button type="submit" id="writeBtn">작성</button></li>   
                        <li><button type="button" id="listBtn" class="ck_boardpanBtn_list">목록</button></li>
                        
                    </ul>
                </form>
                <input type="hidden" name="page" value="${page }">
                <input type="hidden" name="pageSize" value="${pageSize }">
            </section>
        </div>
        <%@ include file="./footer.jsp" %>
	<script>
	$("#listBtn").on('click', function(){
		location.href="<c:url value='/board/cook'/>"
		
	})
	$("#writeBtn").on('click', function(){
		if($('#wr_ckbtitle').val().trim()==""||$('#wr_ckbtitle').val().trim()==null){
			alert('제목을 작성해주세요');
			return false;
		}
		if($('#wr_ckbcon').val().trim()==""||$('#wr_ckbcon').val().trim()==null){
			alert('내용을 작성해주세요');
			return false;
		}
		if(!confirm("작성 완료하시겠습니까"))return false;
	})
	</script>
</body>
</html>
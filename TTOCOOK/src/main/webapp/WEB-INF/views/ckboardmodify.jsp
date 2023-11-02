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
                <form action="<c:url value='/board/ckmodify'/>" method="post">
                	<input type="hidden" name="ckbno" value=${boardDto.ckbno }>
                    <table class="ck_boardpanTbl">
                        <tr>
                            <td colspan="2">수정하기</td>
                        </tr>
                        <tr class="ck_boardpanTitle">
                            <td><label for="">제목</label></td>
                            <td><input type="text" name="ckbtitle" id="mo_ckbtitle" value="${boardDto.ckbtitle }"></td>
                        </tr>
                        <tr>
                        	<td>작성자</td>
                        	<td><input type="text"  name="ckbwriter" value="${boardDto.ckbwriter }" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea name="ckbcon" id="mo_ckbcon" cols="30" rows="10">${boardDto.ckbcon }</textarea></td>
                        </tr>
                    </table>
                    <ul class="ck_boardpanBtn">
                        <li><button type="submit" id="modifyBtn">수정</button></li>   
                        <li><button type="button" id="cancelBtn" class="ck_boardpanBtn_list">취소</button></li>
                    </ul>
                </form>
            </section>
        </div>
        <%@ include file="./footer.jsp" %>
	<script>
	$(document).ready(function(){
		$('#modifyBtn').on('click', function(){
			if($('#mo_ckbtitle').val().trim()==""||$('#mo_ckbtitle').val().trim()==null){
				alert('제목을 작성해주세요');
				return false;
			}
			if($('#mo_ckbcon').val().trim()==""||$('#mo_ckbcon').val().trim()==null){
				alert('내용을 작성해주세요');
				return false;
			}
			
			if(!confirm("수정을 완료하시겠습니까"))return false;
			
		})
		$('#cancelBtn').on('click', function(){
			location.href="<c:url value='/board/cook'/>"
			
		})
	})
	
	</script>
</body>
</html>
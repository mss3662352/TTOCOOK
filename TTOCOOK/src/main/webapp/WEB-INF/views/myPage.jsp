<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <%@include file="./header.jsp" %>
        <div class="container">
            <section class="myPageCon">
                <h2 class="myPage">마이페이지</h2>
                <form action='<c:url value="/mypage/login"/>' method="post" class="myPageTab" onsubmit="return formCheck(this);">
                    <div class="pannel_wrap">
                        <div class="pannel_item">
                            <div class="pannel_inner">
                            <div id="msg">
								<c:if test="${not empty param.msg}">
								  <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>            
								</c:if>        
							</div>
                                <div class="id_pw_wrap">
                                    <div class="input_row" id="id_line_myPage">
                                        <div class="icon_cell">
                                            <span class="icon_id">
                                                <span class="blind">아이디</span>
                                            </span>
                                        </div>
                                        <input type="text" class="input_text" id="login-id-myPage" name="id" value="${user }" title="아이디" readonly onfocus="this.blur()">
                                        <span role="button" class="btn_delete" id="id_clear_myPage">
                                            <span class="icon_delete">
                                                <span class="blind">삭제</span>
                                            </span>
                                        </span>
                                    </div>
                                    <div class="input_row" id="pw_line_myPage">
                                        <div class="icon_cell">
                                            <span class="icon_pw">
                                                <span class="blind">비밀번호</span>
                                            </span>
                                        </div>
                                        <input type="password" class="input_text" id="login-pw-myPage" name="pw" placeholder="비밀번호" required>
                                        <span role="button" class="btn_delete" id="pw_clear_myPage">
                                            <span class="icon_delete">
                                                <span class="blind">삭제</span>
                                            </span>
                                        </span>
                                    </div>
                                    <div class="btn_login_wrap">
                                        <button type="submit" class="btn_login" id="btn_login"><span class="login_test">회원정보 확인</span></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    <%@include file="./footer.jsp" %>
    <script>

        $(function(){
            $pw = $('#login-pw-myPage');
            
            $pw.focus(function(e){
                e.preventDefault();
                $('#pw_line_myPage').css('border', '2px solid #ebb54b')

                $('#pw_clear_myPage').css('display', 'block');
            
            })
            $pw.focusout(function(e){
                e.preventDefault();
                $('#pw_line_myPage').css('border', '2px solid gray')
                if($pw.val().length==0){
                	$('#pw_clear_myPage').css('diplay', 'none');
            	}
            })
	
            $('#pw_clear_myPage').click(function(){
            	$('#pw_line_myPage .input_text').val('');
		        $('#pw_clear_myPage').css('display', 'none');
            })
        })
        
        
        function formCheck(form){
	     	let msg = '';
	     	
	     	if(form.pw.value.length==0) {
	             setMessage('password를 입력해주세요.', form.pw);
	             return false;
	         }
	         return true;
	    }
	
	    function setMessage(msg, element){
	         document.getById("msg").innerHTML = ` ${'${msg}'}`;
	
	         if(element) {
	             element.select();
	         }
	    }
        
    </script>
</body>
</html>
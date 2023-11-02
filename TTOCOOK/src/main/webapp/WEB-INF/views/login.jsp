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
    <title>TTOCOOK:로그인</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	<%@include file="./header.jsp" %>
        <div class="container">
          <section class="loginCon">
              <h2 class="login">로그인</h2>
              <form action="<c:url value='/login/login'/>" class="loginTab" method="post" onsubmit="return formCheck(this);">
                <div class="pannel_wrap">
                  <div class="pannel_item">
                    <div class="pannel_inner">
                      <div id="msg">
						<c:if test="${not empty param.msg}">
						  <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>            
						</c:if>        
					  </div>
                      <div class="id_pw_wrap">
                        <div class="input_row" id="id_line">
                          <div class="icon_cell">
                            <span class="icon_id">
                               <span class="blind">아이디</span>
                             </span>
                          </div>
  					      <input type="hidden" name="toURL" value="${param.toURL }">
                          <input type="text" class="input_text" id="login-id" name="id" placeholder="아이디" title="아이디" value="${cookie.id.value }">
                          <span role="button" class="btn_delete" id="id_clear">
                            <span class="icon_delete">
                              <span class="blind">삭제</span>
                            </span>
                          </span>
                       	</div>
                        <div class="input_row" id="pw_line">
                          <div class="icon_cell">
                            <span class="icon_pw">
                              <span class="blind">아이디</span>
                            </span>
                          </div>
                          <input type="password" class="input_text" id="login-pw" name="pw" placeholder="비밀번호">
                            <span role="button" class="btn_delete" id="pw_clear">
                              <span class="icon_delete">
                                <span class="blind">삭제</span>
                              </span>
                            </span>
                        </div>
                        <div id="msg"></div>
                        <div class="login_keep_wrap">
                          <div class="keep_check">
                            <input type="checkbox" id="keep" name="rememberId" class="input_keep" ${empty cookie.id.value ? "" : "checked"}>
                            <label for="keep" class="keep_text" >
                              아이디 기억하기
                            </label>
                          </div>
                        </div>
                        <div class="btn_login_wrap">
                          <button type="submit" class="btn_login" id="btn_login"><span class="login_test">로그인</span></button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </form>
            </section>
        </div>
    <%@ include file="footer.jsp" %>        
	<script>
	
		$(function(){
		    $id = $('#login-id');
		    $pw = $('#login-pw');
		
		
		    $id.focus(function(e){
		
		        e.preventDefault();
		        $('#id_line').css('border', '2px solid #ebb54b');
		        $('#id_clear').css('display', 'block');
		    })
		    $id.focusout(function(e){
		        e.preventDefault();
		        $('#id_line').css('border', '2px solid gray')
		        if($id.val().length== 0){
		            $('#id_clear').css('display', 'none');
		        }
		    }) 
		    $pw.focus(function(e){
		        e.preventDefault();
		        $('#pw_line').css('border', '2px solid #ebb54b')
		
		        $('#pw_clear').css('display', 'block');
		    
		    })
		    $pw.focusout(function(e){
		        e.preventDefault();
		        $('#pw_line').css('border', '2px solid gray')
		        if($pw.val().length== 0){
		            $('#pw_clear').css('display', 'none');
		        }
		    })
		
		    $('#id_clear').click(function(){
		        $('#id_line .input_text').val('');
		        $('#id_clear').css('display', 'none');
		    })
		    $('#pw_clear').click(function(){
		        $('#pw_line .input_text').val('');
		        $('#pw_clear').css('display', 'none');
		    })
		})
	        
	     function formCheck(form){
	     	let msg = '';
	     	
	     	if(form.id.value.length==0){
	     		setMessage('id를 입력해주세요.', form.id);
	     		return false;
	     	}
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
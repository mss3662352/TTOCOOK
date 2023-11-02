<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:회원가입</title>
   <%@include file="./header.jsp" %>
   
 <script>
 	let msg = "${msg}"
 	if(msg =="REG_ERROR") alert("회원가입 실패");
 </script>
        <div class="container">
            <section class="registerCon">
                <h2>회원가입</h2>
                <form name="form" action="<c:url value='/register/add'/>" method="post">
                    <div class="register-container">
                      <div id="register-article">
                        <div class="register-title">
                        </div>
              	
                        <strong class="register-tf">아이디</strong>
                        <div class="register-subtitle">
                            <label for="logo_id" class="register-lab"></label>
                            <p id="userIdN"></p>
                            
                            <input
                            class="register-input"
                            type="text"
                            id="logo_id"
                            placeholder="아이디 입력"
                            name="id"
                            />
                            <div class="register-util1">
                                <button type="button" id="idDuplication">
                                	중복확인
                                </button>
                            </div>
                        </div>
                        <strong class="register-tf">비밀번호</strong>
                        <div class="register-subtitle">
                            <label for="logo_pwd" class="register-lab"></label>
                            <p id="userPwN"></p>
                            <input
                                class="register-input"
                                type="password"
                                id="logo_pwd"
                                placeholder="비밀번호 입력(8~16자리)"
                                name="pw"
                            />
                            <p id="userPwCN"></p>
                            <input
                                class="register-input"
                                type="password"
                                id="logo_confirmPwd"
                                placeholder="비밀번호 재입력"
                                name="confirmPw"
                            />
                            <div class="register-util"></div>
                        </div>
              
                        <strong class="register-tf">전화번호</strong>
                        <div class="register-subtitle">
                            <label for="logo_tel" class="register-lab"></label>
                            <p id="userTelN"></p>
                            <input
                                class="register-input"
                                type="tel"
                                id="logo_tel"
                                placeholder="전화번호 입력 (010-0000-0000)"
                                name="tel"
                            />
                            <div class="register-util"></div>
                        </div>
              
                        <strong class="register-tf">이메일</strong>
                        <div class="register-subtitle">
                            <label for="logo_mail" class="register-lab"></label>
                            <p id="userMailN"></p>
                            <input
                                class="register-input"
                                type="email"
                                id="logo_mail"
                                placeholder="이메일 입력 (*@*.*)"
                                name="email"
                            />
                            <div class="register-util"></div>
                        </div>
              
                        <strong class="register-tf">닉네임</strong>
                        <div class="register-subtitle">
                            <label for="logo_nickname" class="register-lab"></label>
                            <p id="userNickN"></p>
                            <input
                                class="register-input"
                                type="text"
                                id="logo_nickName"
                                placeholder="닉네임 입력(2~5자리)"
                                name="nickname"
                            />
                            <div class="register-util"></div>
                            <div class="register-util1">
                                <button type="button" id="nickDuplication" >
                                중복확인
                                </button>
                            </div>
                        </div>
                            <input id="submit" type="submit" value="회원가입" onclick="return check()"/>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    <%@ include file="./footer.jsp" %>
    <script>
	let regId = /^[A-Za-z0-9]{6,12}$/;
	let regPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/
	let regTel = /^01[016789]{1}-{1}?([0-9]{4})-{1}?([0-9]{4})$/;
	let regMail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{1,3}$/i;
	let regNickName = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣A-Za-z0-9]{2,5}$/;
	
	let id = document.querySelector("#logo_id");
	let pw1 = document.querySelector("#logo_pwd");
	let pw2 = document.querySelector("#logo_confirmPwd");
	let tel = document.querySelector("#logo_tel");
	let mail = document.querySelector("#logo_mail");
	let nickName = document.querySelector("#logo_nickName");
	
    let idck = 0;
    let nickck = 0;
    $(function() {
    	$("#idDuplication").click(function() {
            let id = $("#logo_id").val();
            $.ajax({
            	type : 'post',
                url : '/web/register/idCheck',
                headers : {'Content-Type' : 'application/json'},
                dataType : 'text',
                data : id,
                success : function(cnt) {
                	if(!(regId.test(id))){
                        alert("아이디는 영문 대소문자와 숫자 6~12자리로 입력해주세요")
                        id="";
                        idckck = 0;
                    }else if (cnt == "N") {
                        alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                        id="";
                        idckck = 0;
                    }else if(cnt =="Y"){
                        alert("사용가능한 아이디입니다.");
                        idck = 1;
                    }
                },
                error : function(cnt) {
                	console.log(cnt);
                    alert(cnt);
                }
            });
        });
    });
    $(function() {
    	$("#nickDuplication").click(function() {
    		let nick = $("#logo_nickName").val();
            $.ajax({
            	type : 'post',
                url : '/web/register/nickCheck',
                headers : {'Content-Type' : 'application/json'},
                dataType : 'text',
                data : nick,
                success : function(cnt) {
                	if(!(regNickName.test(nick))){
                        alert("닉네임을 2~5자리로 입력해주세요");
                        nick="";
                        nickck = 0;
                    }else if (cnt == "N") {
                        alert("닉네임이 존재합니다. 다른 닉네임을 입력해주세요.");
                        nick="";
                        nickck = 0;
                    }else if(cnt =="Y"){
                    	alert("사용가능한 닉네임입니다.");
                        nickck = 1;
                    }
                },
                error : function(cnt) {
                	console.log(cnt);
                    alert(cnt);
                }
            });
        });
    });

	function check(){
	    if(!(regId.test(id.value))){
	        document.querySelector('#userIdN').innerHTML ="아이디는 영문 대소문자와 숫자 6~12자리로 입력해주세요"
	        id.value="";
	        id.focus();
	        return false;
	    }else{
	        document.querySelector('#userIdN').innerHTML =""
	    
	    }
	
	    if(!(regPw.test(pw1.value))){
	        document.querySelector('#userPwN').innerHTML ="비밀번호는 영문과 숫자 및 특수문자를 포함하여 8~16자리로 입력해주세요";
	        pw1.value="";
	        pw1.focus();
	        return false;
	    }else{
	        document.querySelector('#userPwN').innerHTML ="";
	    }
	
	    if(pw1.value != pw2.value){
	        document.querySelector('#userPwCN').innerHTML ="비밀번호가 일치하지 않습니다";
	        pw2.value="";
	        pw2.focus();
	        return false;
	    }else{
	        document.querySelector('#userPwCN').innerHTML ="";
	    }
	
	    if(!(regTel.test(tel.value))){
	        document.querySelector('#userTelN').innerHTML ="전화번호를 다시 입력해주세요";
	        tel.value="";
	        tel.focus();
	        return false;
	    }else{
	        document.querySelector('#userTelN').innerHTML ="";
	    }
	
	    if(!(regMail.test(mail.value))){
	        document.querySelector('#userMailN').innerHTML ="이메일을 다시 입력해주세요";
	        mail.value="";
	        mail.focus();
	        return false;
	    }else{
	        document.querySelector('#userMailN').innerHTML ="";
	    }
	
	    if(!(regNickName.test(nickName.value))){
	        document.querySelector('#userNickN').innerHTML ="닉네임은 2~5자리로 입력해주세요";
	        nickName.value ="";
	        nickName.focus();
	        return false;
	    }else{
	        document.querySelector('#userNickN').innerHTML ="";
	
	    }
	    if(idck==0){
            alert('아이디 중복체크를 해주세요');
            return false;
        }
		if(nickck==0){
        	alert('닉네임 중복체크를 해주세요')
        	return false;
        }
	    alert("회원가입이 완료되었습니다");
	    return true;
}

    </script>
</body>
</html>
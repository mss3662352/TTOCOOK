<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:join</title>
    
	<%@ include file="./header.jsp" %>
	
        <div class="container">
            <section class="registerCon">
                <h2>회원정보 변경</h2>
                <form name="form" method="post">
                    <div class="register-container">
                      <div id="register-article">
                        <div class="register-title">
                        </div>
              
                        <strong class="register-tf">아이디</strong>
                        <div class="register-subtitle">
                            <label for="logo_id_Up" class="register-lab"></label>
                            <input
                            class="register-input"
                            type="text"
                            id="logo_id_Up"
                            name="id"
                            value="${memberDto.id }"
                            readonly
                            onfocus="this.blur()"
                            />
                        </div>

                        <strong class="register-tf">비밀번호 변경</strong>
                        <div class="register-subtitle">
                            <label for="logo_pwd_up" class="register-lab"></label>
                            <p id="userPwN"></p>
                            <input
                                class="register-input"
                                type="password"
                                id="logo_pwd_up"
                                placeholder="비밀번호 입력(8~16자리, 영문, 숫자, 특수기호 사용)"
                                name="pw"
                            />
                            <p id="userPwCN"></p>
                            <input
                                class="register-input"
                                type="password"
                                id="logo_confirmPwd_up"
                                placeholder="비밀번호 재입력"
                                name="pw2"
                            />
                            <div class="register-util"></div>
                        </div>
              
                        <strong class="register-tf">전화번호 변경</strong>
                        <div class="register-subtitle">
                            <label for="logo_tel_up" class="register-lab"></label>
                            <p id="userTelN"></p>
                            <input
                                class="register-input"
                                type="tel"
                                id="logo_tel_up"
                                placeholder="${memberDto.tel }"
                                name="tel"
                            />
                            <div class="register-util"></div>
                        </div>
              
                        <strong class="register-tf">이메일 변경</strong>
                        <div class="register-subtitle">
                            <label for="logo_mail_up" class="register-lab"></label>
                            <p id="userMailN"></p>
                            <input
                                class="register-input"
                                type="email"
                                id="logo_mail_up"
                                placeholder="${memberDto.email }"
                                name="email"
                            />
                            <div class="register-util"></div>
                        </div>
              
                        <strong class="register-tf">닉네임 변경</strong>
                        <div class="register-subtitle">
                            <label for="logo_nickname_up" class="register-lab"></label>
                            <p id="userNickN"></p>
                            <input
                                class="register-input"
                                type="text"
                                id="logo_nickName_up"
                                value="${memberDto.nickname }"
                                name="nickname"
                                onfocus="this.blur()"
                            />
                            <div class="register-util"></div>
                        </div>
                            <input id="submit" type="submit" onclick="return check()" value="회원정보 변경"/>
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

        let pw1 = document.querySelector("#logo_pwd_up");
        let pw2 = document.querySelector("#logo_confirmPwd_up");
        let tel = document.querySelector("#logo_tel_up");
        let mail = document.querySelector("#logo_mail_up");
        let nickName = document.querySelector("#logo_nickName_up");

        function check(){

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
            alert("회원정보 변경이 완료되었습니다");
            return true;
        }
    </script>
</body>
</html>
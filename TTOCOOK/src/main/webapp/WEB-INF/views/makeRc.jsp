<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TTOCOOK:레시피 만들기</title>
    
    <%@include file="header.jsp" %>
    
        <div class="container">
        	<section class="make_rc1">
          		<h2>레시피 만들기</h2>
              	<form action="" class="make_rcTab">
	                <table>
	                	
	                    <tr>
	                        <td><p>레시피 제목</p></td>
	                        <td>
	                        	<input type="text" name="rctitle" id="rc_title" placeholder="ex) 계란찜 만들기" required>
	                			<input type="hidden" name="rcwriter">
	                        </td>
	                    </tr>	
	                    <tr class="introText">
	                        <td><p>레시피 소개</p></td>
	                        <td><textarea name="rcintro" id="rc_intro" class="rc_intro" placeholder="레시피에 대한 소개 ex)계란과 우유를 사용하여 간단하게 만드는 계란찜" style="resize: none;" ></textarea></td>
	                    </tr>
	                    <tr>
	                        <td><label for="rc_category">카테고리</label></td>
	                        <td>
	                            <select name="mainIng" id="mainIng" class="mainIng">
	                                <option value="">메인재료</option>
	                                <option value="beef">소고기</option>
	                                <option value="pork">돼지고기</option>
	                                <option value="chicken">닭고기</option>
	                                <option value="meat">육류</option>
	                                <option value="seafood">해물류</option>
	                                <option value="vegetable">채소류</option>
	                                <option value="etc">기타</option>
	                            </select>       
	                            <input type="text" class="subIng" name="rcsub1" placeholder="서브재료"/>
	                            <input type="text" class="subIng" name="rcsub2" placeholder="서브재료"/>
	                            <input type="text" class="subIng" name="rcsub3" placeholder="서브재료"/>
	                            <input type="text" class="subIng" name="rcsub4" placeholder="서브재료"/>
	                        </td>
	                    </tr>
	                </table>
	                <div class="make_rc2">
		                <h3>요리순서</h3>
		                <table class="stepList">
		                    <tr class="make_rcStep" id="make_rcStep1">
		                        <td><p>Step 1</p></td>
		                        <td>
		                            <div>
		                                <textarea name="make_order1" id="make_order1" class="make_order" placeholder="요리방법에 대해 작성합니다 ex)계란 2개를 볼에 풀어 거품기로 저어주세요"></textarea>
		                                <div class="rcImgD" id="rcImgD1"></div>
		                                <input type="file" name="rcImg1" class="rcImg" id="rcImg1" accept="img/*">
		                            </div>
		                        </td>
		                    </tr>
		                </table>
		                <table> 
		                    <div class="stepBtn">
		                        <div>
		                            <button type="button" class="nextStep" onclick=addStep()><span>+</span></button>
		                            <button type="button" class="preStep" onclick= removeStep()><span>-</span></button>
		                        </div>
		                    </div>
		                    <tr class="tag">
		                        <td><p>태그</p></td>
		                        <td><input type="text" class="tag" placeholder="태그를 달아주세요 ex)계란요리, 우유, 다이어트, 간단요리"></td>
		                    </tr>
		                    <tr>
		                        <td colspan="2" class="make_rcBtn"><button type="submit">레시피 완성</button></td>
		                    </tr>
		                </table>
		         	</div>
	             </form>
	          </section>
	      </div>
        <%@ include file="./footer.jsp" %>
    <script>
    
    
    let count = 2;
    
    

    function addStep(){
        if(count == 2){
            $('.preStep').css('display', 'inline-block');
        }else if(count == 10){
            $('.nextStep').css('display', 'none');
        }
        let newTr = document.createElement("tr");
        let newTd = document.createElement("td");
        let newTd2 = document.createElement("td");
        let newP = document.createElement("p");
        let newD = document.createElement("div");
        let newT = document.createElement("textarea")
        let newD2 = document.createElement("div");
        let newI = document.createElement("input");
        let textCount = document.createTextNode("Step "+ count);
        newTr.appendChild(newTd);
        newTd.appendChild(newP);
        newP.appendChild(textCount);
        newTr.appendChild(newTd2);
        newTd2.appendChild(newD);
        newD.appendChild(newT);
        newD.appendChild(newD2);
        newD.appendChild(newI);

        newTr.setAttribute("class", "make_rcStep");
        newTr.setAttribute("id", "make_rcStep"+(count));
        newT.setAttribute("class", "make_order");
        newT.setAttribute("id", "make_order" +(count))
        newT.setAttribute("name", "make_order" +(count))
        newD2.setAttribute("class", "rcImgD");
        newD2.setAttribute("id", "rcImgD"+(count));
        newI.setAttribute("type", "file");
        newI.setAttribute("class", "rcImg");
        newI.setAttribute("id", "rcImg" +(count));
        newI.setAttribute("name", "rcImg" +(count));
        newI.setAttribute("accept", "img/*");
        let stepList = document.querySelector(".stepList")
        stepList.insertBefore(newTr, null)
        count += 1;
    } 
    
    function removeStep(){
        let $make_rcStep = $('#make_rcStep2');
        let $step = $("#make_rcStep"+(count-1));
        let $last = $('.make_rcStep:last-child');
        $step.remove();
        
        if(count == 3){
            $('.preStep').css('display', 'none');
        }else if(count == 11){
            $('.nextStep').css('display', 'inline-block');
        }
        

        count -=1;
    }
    
    $rcImgD = $(".rcImgD");
    $rcImgD.on('click', function(){
        $(this).next().click();
    })
    </script>
</body>
</html>
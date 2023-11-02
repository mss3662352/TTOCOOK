
$(function(){
    $('.main_nav li:nth-child(4)').click(function(e){
        e.preventDefault();

        let $d = $('.commu_nav').css('display');

        if($d == 'block'){
            $('.commu_nav').slideUp();
        }else{
            $('.commu_nav').slideDown();
        }
    })
})
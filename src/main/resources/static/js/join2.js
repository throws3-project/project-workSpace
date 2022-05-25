// 페이지 켜질 시 자동으로 모달창 뜨기
$(document).ready(function(){
    $(".modalWindowSuccess").show();
});

// 클릭시 모달창 꺼지게 만듬.
$('.modal_close_btn').on("click", function(){
   $(".modalWindowSuccess").hide();
});

// 관심분야 클릭시 클래스 추가 / 삭제
$("div#interestWrap p").each(function (i,tag) {
    $(tag).on("click",function () {
        if($('p.active').length<5){
            if($(tag).attr("class")=="active"){
                $(tag).removeClass("active");
            }else{
                $(tag).addClass("active");
            }
        }else{
            if($(tag).attr("class")=="active"){
                $(tag).removeClass("active");
            }else{
                alert("이미 5개를 선택하셨습니다.")
            }
        }
    })
})


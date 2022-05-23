// 댓글 열고 닫기 
$(".contentsBtnReply").on("click",function () {
    if($(".rpyAtiveWrap").css("display")=="block"){
        $(this).html("댓글 열기");
        $(".rpyAtiveWrap").hide();
    }else{
        $(this).html("댓글 닫기");
        $(".rpyAtiveWrap").show();
    }
})

// 스토리 삭제 모달
$(".remove").on("click",function(){
    $(".modalStory3").css('display','block');  
});

$(".mdBtnRemoves").on("click",function(){
    $(".modalStory3").css('display','none');
    $(".modalStory2").css('display','block');
});

$(".xBtns").on("click",function(){
    $(".modals").hide();
});

//프로필 상세보기 
$(".activeProName").on("mouseover", function () {
    $(this).next().show();
})

$(".activeProName").on("mouseout", function () {
    $(this).next().hide();
})
$(".hoverUl").on("mouseover", function () {
    $(this).show();
})

$(".hoverUl").on("mouseout", function () {
    $(this).hide();
})

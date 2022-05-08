// 댓글 열고 닫기 ]

$(".contentsBtnReply").on("click",function () {
    if($(".rpyAtiveWrap").css("display")=="block"){
        $(this).html("댓글 열기");
        $(".rpyAtiveWrap").hide();
    }else{
        $(this).html("댓글 닫기");
        $(".rpyAtiveWrap").show();
    }
})
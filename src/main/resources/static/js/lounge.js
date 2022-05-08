//댓글 열고 닫기 만들기
$(".replyOpen").each(function (i,open) {
    $(open).on("click",function () {
        if($($(".rpyAtiveWrap").get(i)).css("display")=="block") {
            $($(".rpyAtiveWrap").get(i)).hide();
            $(open).html("댓글 열기");
        }else{
            $($(".rpyAtiveWrap").get(i)).show();
            $(open).html("댓글 닫기");

        }
    })
})
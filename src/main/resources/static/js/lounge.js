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

//프로필 상세보기(댓글의댓글)
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

////프로필 상세보기(댓글)
$(".proNames").on("mouseover", function () {
    $(this).next().show();
})

$(".proNames").on("mouseout", function () {
    $(this).next().hide();
})
$(".hoverUl").on("mouseover", function () {
    $(this).show();
})

$(".hoverUl").on("mouseout", function () {
    $(this).hide();
})
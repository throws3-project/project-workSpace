$(document).ready(function () {
    $("#header").load('../../templates/fix/header.html');
    $("#footer").load('../../templates/fix/footer.html');
});

$(".userWrap").on("mouseover", function () {
    $(this).find("div.idMenu").show();
})

$(".userWrap").on("mouseout", function () {
    $(this).find("div.idMenu").hide();
})

$(".userId").on("mouseover", function () {
    $(this).find(".idMenu").show();
})

$(".userId").on("mouseout", function () {
    $(this).find(".idMenu").hide();
})

$(".ugname").on("mouseover", function () {
    $(this).next().show();
})

$(".ugname").on("mouseout", function () {
    $(this).next().hide();
})

$(".idHoverMenu").on("mouseover", function () {
    $(this).show();
})

$(".idHoverMenu").on("mouseout", function () {
    $(this).show();
})

$(".profileName").on("mouseover", function () {
    $(this).next().show();
})

$(".profileName").on("mouseout", function () {
    $(this).next().hide();
})

$(".subscriber").find("li").on("mouseover", function () {
    $(this).find("div.subHover").css("display", "block");
})

$(".subscriber").find("li").on("mouseout", function () {
    $(this).find("div.subHover").css("display", "none");
})

/* chapter three faq */

$("textarea.textarea").on("propertychange change keyup paste input", function () {
    if (!$(this).val()) {
        $("div.textButtonWrap").css("display", "none");
        $(this).attr("rows", 2);
    } else {
        $("div.textButtonWrap").css("display", "inline-flex");
        $(this).attr("rows", 5);
    }
})

$("textarea.textarea").on("keyup", function () {
    $("p.count").children(":first").text($(this).val().length);
})





// reply
let text = null;
$("div.faqBottom").find("a").on("click",function () {
    $("div.faqBottom").find("a").removeClass("active");
    $("div.replyWrap").removeClass("reply");

    text = $(this).text();

    $("div.faqBottom").find("a").text("댓글 열기");

    if(text == "댓글 닫기"){
        $(this).text("댓글 열기");
        return;
    }

    if($(this).text() == "댓글 열기") {
        $(this).text("댓글 닫기");
        $(this).addClass("active");
        $(this).parents("div.faqUploadWrap").next().addClass("reply");
    }

})



/* move menu */
$("div.projectTabMenu").find("li").on("click", function() {
    $("div.projectTabMenu").find("a").removeClass("active");
    $("div.projectDetailWrap").children().removeClass("active");
    $(this).find("a").addClass("active");

    if($(this).find("a").text() == "정보"){
        $("div.projectDetailWrap").children("div.projectInfo").addClass("active");
        $("textarea.textarea").val("");
        $("textarea.textarea").attr("rows",2);
        $("div.textButtonWrap").hide();
    }else if($(this).find("a").text() == "스토리"){
        $("div.projectDetailWrap").children("div.storySection").addClass("active");
        $("textarea.textarea").val("");
        $("textarea.textarea").attr("rows",2);
        $("div.textButtonWrap").hide();
    }else if($(this).find("a").text() == "질문"){
        $("div.projectDetailWrap").children("div.projectFaq").addClass("active");
    }
})





/* chatting */

let count = 1;

$("div.chattingOpen").on("click", function () {
    $(this).removeClass("open");
    $("div.chatting").addClass("open");
})

$("div.foldChatButton").on("click", function () {
    $(this).parents("div.chatting").removeClass("open");
    $("div.chattingOpen").addClass("open");
})

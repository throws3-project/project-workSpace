/* chatting */

$("div.chattingOpen").on("click", function () {
    $(this).removeClass("open");
    $("div.chatting").addClass("open");
})

$("div.foldChatButton").on("click", function () {
    $(this).parents("div.chatting").removeClass("open");
    $("div.chattingOpen").addClass("open");
})

$("div.writeButton").on("click",function () {
    location.href = "/story/storyRegister";
})
/* chatting */

<<<<<<< HEAD
// let count = 1;
=======
>>>>>>> 5b54a4f8453372be3cf55380fb3c96d2f8b6d69a

$("div.chattingOpen").on("click", function () {
    $(this).removeClass("open");
    $("div.chatting").addClass("open");
})

$("div.foldChatButton").on("click", function () {
    $(this).parents("div.chatting").removeClass("open");
    $("div.chattingOpen").addClass("open");
})
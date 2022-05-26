$("#imgUploadBtn").on("click", function () {
    let input = $("#imgUpload");
    input.click();
});

// 스토리 수정 확인모달
$(".modifyMd").on("click",function(){
     $(".modalStory1").css('display','block');  
 
});

$(".xBtns").on("click",function(){
    $(".modals").hide();
});


//스터디 분야 삭제
$("div.skillResult").on("click", "a.skillTag", function () {
    $(this).remove();
})



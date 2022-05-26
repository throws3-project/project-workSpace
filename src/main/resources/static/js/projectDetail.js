$("#projectContent").html(content);

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
    $(this).hide();
})

$(".profileName").on("mouseover", function () {
    $(this).next().show();
})

$(".profileName").on("mouseout", function () {
    $(this).next().hide();
})
$(".idMenu").on("mouseover", function () {
    $(this).show();
})

$(".idMenu").on("mouseout", function () {
    $(this).hide();
})

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
    }else if($(this).find("a").text() == "피드"){
        $("div.projectDetailWrap").children("div.projectFeed").addClass("active");
    }else if($(this).find("a").text() == "관리"){
        $("div.projectDetailWrap").children("div.projectManage").addClass("active");
    }
})


// 모달 종료
$(".xBtns").on("click",function(){
    $(".modals").hide();
 });

 //지원버튼 클릭 시 모달
 $(".applyButton").on("click",function(){
    $(".modal1").css('display','block');  
});

//지원버튼 예 클릭 시 모달
$(".complete1").on("click",function(){
    $(".modal2").css('display','block'); 
    $(".modal1").css('display','none'); 
});

//피드 클릭 시 멤버에게만 허용된다는 메세지 모달
$(".disafeed").on("click",function(){
    $(".modal3").css('display','block');  
});

//관리 클릭 시 리더에게만 허용된다는 모달
$(".disamanage").on("click",function(){
    $(".modal4").css('display','block');  
});

//관리 에서 프로젝트 클릭 시 모달 
$(".proManageMd").on("click",function(){
    $(".modal5").css('display','block');  
});

//관리에서 삭제버튼 클릭 시 모달
$(".mdBtnRemove").on("click",function(){
    $(".modal6").css('display','block');  
});

//삭제버튼 클릭 후 모달
$(".mdBtnCom").on("click",function(){
    $(".modal6").css('display','none');  
    $(".modal7").css('display','block');  
});

//지원자 승인 모달 success, nonono
$(".success").on("click",function(){
    $(".modal8").css('display','block');  
});

//지원자 승인 확인 모달 mdBtnMem1
$(".mdBtnMem1").on("click",function(){
    $(".modal9").css('display','block');  
});

//지원자 거절 모달
$(".nonono").on("click",function(){
    $(".modal10").css('display','block');  
});

//멤버 방출 모달 successBang
$(".successBang").on("click",function(){
    $(".modal11").css('display','block');  
});

//멤버 방출 완료 모달 mdBtnBang
$(".mdBtnBang").on("click",function(){
    $(".modal11").css('display','none');  
    $(".modal12").css('display','block');  
});

//프로젝트 구독하기 모달
$(".subscribeButton").on("click",function(){
    $(".modal13").css('display','block');  
});
//프로젝트 구독하기 예 클릭 시 모달 mdBtnProYes
$(".mdBtnProYes").on("click",function(){
    $(".modal13").css('display','none');
    $(".modal14").css('display','block');  
});
// 관리 메뉴 이동 
$("div.chooseManage").find("li").on("click", function(){
    
    if($(this).find("a").text() == "지원자 관리"){
        $(".manages").removeClass("active")
        $(".chooseManage ul li").removeClass("activeBorder")
        $(".projectSup").addClass("active");
        $(this).addClass("activeBorder");
    }else if($(this).find("a").text() == "멤버 관리"){
        $(".manages").removeClass("active")
        $(".chooseManage ul li").removeClass("activeBorder")
        $(".proManag").addClass("active");
        $(this).addClass("activeBorder");
    }else{
        $(".chooseManage ul li").removeClass("activeBorder")
        $(".manages").removeClass("active")
    }
})



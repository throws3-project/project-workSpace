$(document).ready(function(){
    $(".modalWindow").show();
});

$('.modal_close_btn').each(function(i, btn){
    $(btn).on("click", function(){
        $($(".modalWindow").get(i)).hide();
    });
});

$('.complete').each(function(i, btn){
    $(btn).on("click", function(){
        $($(".modalWindow").get(i)).hide();
    });
});

// 포트폴리오 SNS링크 추가
let count=1;
$("#copyInput").on("click", "#copyButton", function(){
    let length= $("#copyInput").children().length;
    if(length != 5){
        count++
        let input = $($(this).parent().children()[0]);
        let str = "";
        str += "<div id=\"url\" class=\"flex\">"
        str += "<input type='text' class='linkInput' placeholder='포폴/SNS 주소를 입력해주세요' value='" + input.val() + "'>";
        str += "<input id='deleteUrl' type='button' class='addButton a" + count + "' value='삭제'>";
        str += "</div>"
        $("div#copyInput").append(str);
        input.val("");
        if(length == 4){
            $(this).replaceWith("<input id='deleteUrl' type='button' class='addButton' value='삭제'>");
        }
    };
});

// 포트폴리오 SNS링크 추가
$("#copyInput").on("click", "#deleteUrl", function(){
    $(this).parent().hide();
    count--
    if(count==0){
        count++
        let str = "";
        str += "<div id=\"url\" class=\"flex\">"
        str += "<input type='text' class='linkInput' placeholder='포폴/SNS 주소를 입력해주세요' value=''>";
        str += "<input id='plusUrl' type='button' class='addButton a" + count + "' value='추가'>";
        str += "</div>"
        $("div#copyInput").append(str);
        count=1
    }
});

$('.complete').on("click", function(){
    $(".modalWindow").hide();
});

$("div#interestWrap p").each(function (i,tag) {
    $(tag).on("click",function () {
        if($('.active').length<5){
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

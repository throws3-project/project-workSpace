
$("#goInfo").click(function () {
    $(".pageNav").hide();
    $("#goInfo").parent().css("border-bottom","1px solid lightgray");
    $("#info").show();
    $("#goInfo").parent().css("border-bottom","1px solid black");
})
$("#goPoint").click(function () {
    $(".pageNav").hide();
    $("#goPoint").parent().css("border-bottom","1px solid lightgray");
    $("#point").show();
    $("#goPoint").parent().css("border-bottom","1px solid black");
})


/*정보페이지 - 포트폴리오 추가-삭제*/
let count=1
$("#portfolio").on("click", "#plusUrl", function () {
    let length=$("#portfolio").children().length;
    if (length != 5) {
        count++
        console.log(length)
        let input = $($(this).parent().children()[0]);
        let str = "";
        str += "<div id=\"url\" class=\"flex\">"
        str += "<input type='text' class='able' placeholder='URL을 입력해주세요' value='" + input.val() + "'>";
        str += "<input id='deleteUrl' type='button' class='able a" + count + "' value='삭제'>";
        str += "</div>"
        $("div#portfolio").append(str);
        input.val("");
        console.log(length)
        if (length == 4) {
            $(this).replaceWith("<input id='deleteUrl' type='button' class='able' value='삭제'>");
        }
    }
})

$("#portfolio").on("click", "#deleteUrl", function () {
    $(this).parent().hide();
    count--
    if(count==0){
        count++
        let str = "";
        str += "<div id=\"url\" class=\"flex\">"
        str += "<input type='text' class='able' placeholder='URL을 입력해주세요' value=''>";
        str += "<input id='plusUrl' type='button' class='able a" + count + "' value='추가'>";
        str += "</div>"
        $("div#portfolio").append(str);
        count=1
    }
})
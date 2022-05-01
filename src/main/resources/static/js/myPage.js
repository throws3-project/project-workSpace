/*네비게이션 이동*/
$($(".navBorder").get(0)).css("border-bottom","1px solid black");
    $(".nav").each(function (i,nav) {
        $(nav).on("click",function (e) {
            e.preventDefault();
            $(".pageNav").hide();
            $(".navBorder").css("border-bottom","1px solid lightgray");
            $($(".pageNav").get(i)).show();
            $($(".navBorder").get(i)).css("border-bottom","1px solid black");
        })
    })


/*포인트 충전/사용 이동*/
$($(".pointNav").get(0)).css("border","1px solid black");
$(".pointNav").each(function (i,nav) {
    $(nav).on("click",function () {
        $(".pointTable").hide();
        $(".pointNav").css("border","1px solid lightgray")
        $($(".pointTable").get(i)).show();
        $($(".pointNav").get(i)).css("border","1px solid black");
    })
})


/*정보페이지 - 포트폴리오 추가*/
let count=1
$("#portfolio").on("click", "#plusUrl", function () {
    let length=$("#portfolio").children().length;
    if (length != 5) {
        count++
        let input = $($(this).parent().children()[0]);
        let str = "";
        str += "<div id=\"url\" class=\"flex\">"
        str += "<input type='text' class='able' placeholder='URL을 입력해주세요' value='" + input.val() + "'>";
        str += "<input id='deleteUrl' type='button' class='able a" + count + "' value='삭제'>";
        str += "</div>"
        $("div#portfolio").append(str);
        input.val("");
        if (length == 4) {
            $(this).replaceWith("<input id='deleteUrl' type='button' class='able' value='삭제'>");
        }
    }
})

/*정보페이지 - 포트폴리오 삭제*/
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
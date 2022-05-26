// $(document).ready(function(){
//     $(".modalWindowPlus").show();
// });

// 클릭시 모달창 꺼지게 만듬.
$('img.xIcon').on("click", function(){
    console.log("실행전");
    $("div.modalWindowPlus").hide();
    console.log("실행후");
});

$('button.complete').on("click", function(){
    console.log("실행전");
    $("div.modalWindowPlus").hide();
    console.log("실행후");
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
        str += "<input type='text' class='linkInput' name='portUrl' placeholder='포폴/SNS 주소를 입력해주세요' value='" + input.val() + "'>";
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
    $(this).parent().remove();
    count--
    if(count==0){
        count++
        let str = "";
        str += "<div id=\"url\" class=\"flex\">"
        str += "<input type='text' class='linkInput' name='portUrl' placeholder='포폴/SNS 주소를 입력해주세요' value=''>";
        str += "<input id='plusUrl' type='button' class='addButton a" + count + "' value='추가'>";
        str += "</div>"
        $("div#copyInput").append(str);
        count=1
    }
});

$('.complete').on("click", function(){
    $(".modalWindow").hide();
});

// $("div#interestWrap p").each(function (i,tag) {
//     $(tag).on("click",function () {
//         if($('.active').length<5){
//             if($(tag).attr("class")=="active"){
//                 $(tag).removeClass("active");
//             }else{
//                 $(tag).addClass("active");
//             }
//         }else{
//             if($(tag).attr("class")=="active"){
//                 $(tag).removeClass("active");
//             }else{
//                 alert("이미 5개를 선택하셨습니다.")
//             }
//         }
//
//     })
// })

// 메인 기술 선택시 세부 기술 변경
function personChange(e) {
    let d = "";
    let person_a = ["UI/UX기획", "게임기획", "프로젝트 매니저", "하드웨어(제품) 기획"];
    let person_b = ["그래픽디자인", "UI/UX디자인", "3D디자인", "하드웨어(제품) 디자인", "(디자인)기타"];
    let person_c = ["IOS", "안드로이드", "웹프론트엔드", "웹퍼블리셔", "크로스플랫폼"];
    let person_d = ["웹 서버", "블록체인", "AI", "DB/빅데이터/DS", "게임 서버"];
    let person_e = ["사업기획", "마케팅", "영업", "재무/회계", "전략/컨설팅", "투자/고문", "(사업)그외"];
    let person_f = ["작가/블로거", "인플루언서/스트리머", "작곡(사운드)", "영상", "운영", "QA", "기타"];
    let target = $(e).next();

    if (e.value == "기획") d = person_a;
    else if (e.value == "디자인") d = person_b;
    else if (e.value == "프론트엔드개발") d = person_c;
    else if (e.value == "백엔드개발") d = person_d;
    else if (e.value == "사업") d = person_e;
    else if (e.value == "기타") d = person_f;

    target.html("");

    $(d).each(function (i,opt) {
        let str="";
        str+="<option>"+opt+"</option>"
        target.append(str);
    })
}

$(".joinComplete").on("click",function (e) {
    e.preventDefault();
    $(".userSubSkill").val($("#userSubSkill").val());
    $(".userSubDetail").val($("#userSubDetail").val());
    $(".userSubLevel").val($("#userSubLevel").val());
    $(".userContent").val($("#userIntroduce").val());
    $(".userPrice").val($("#userPrice").val());

    // $(".linkInput").each(function (i,tag) {
    //     let str="";
    //     if ($(tag).text()) {
    //         str = "<input type='hidden' id='interest' name='interest' value='"+$(tag).text()+"'>"
    //         $("#frm").append(str);
    //     }
    // })

    document.joinPlus.submit();
})

$("#joinLater").on("click", function (e) {
    e.preventDefault();
    document.laterForm.submit();
})

// 헤더 표시하기
$(document).ready(function () {
    $("#header").load('../../templates/fix/header.html');
    $("#foot").load('../../templates/fix/footer.html');
})


// 프로젝트/스터디 양식 선택
$(".choice").each(function (i,radio) {
    $(radio).on("click",function (e) {
        $(".make").hide();
        $($(".make").get(i)).show();
    })
})


// 모임지역 선택
function onOffChange(e) {
    var onOff_both = ["상관없음", "서울특별시", "경기도", "부산광역시", "인천광역시", "대구광역시", "경상남도", "경상북도", "충청남도", "충청북도", "전라남도", "전라북도", "광주광역시", "강원도", "울산광역시", "제주특별자치도", "세종특별자치시"];
    var onOff_on = ["상관없음"];
    var onOff_off = ["서울특별시", "경기도", "부산광역시", "인천광역시", "대구광역시", "경상남도", "경상북도", "충청남도", "충청북도", "전라남도", "전라북도", "광주광역시", "강원도", "울산광역시", "제주특별자치도", "세종특별자치시"];
    var target = document.getElementById("onOffResult");

    if (e.value == "both") var d = onOff_both;
    else if (e.value == "on") var d = onOff_on;
    else if (e.value == "off") var d = onOff_off;

    target.options.length = 0;

    for (x in d) {
        var opt = document.createElement("option");
        opt.value = d[x];
        opt.innerHTML = d[x];
        target.appendChild(opt);
    }
}


//모집인원 선택
function personChange(e) {
    var person_a = ["UI/UX기획", "게임기획", "프로젝트 매니저", "하드웨어(제품) 기획"];
    var person_b = ["그래픽디자인", "UI/UX디자인", "3D디자인", "하드웨어(제품) 디자인", "(디자인)기타"];
    var person_c = ["IOS", "안드로이드", "웹프론트엔드", "웹퍼블리셔", "크로스플랫폼"];
    var person_d = ["웹 서버", "블록체인", "AI", "DB/빅데이터/DS", "게임 서버"];
    var person_e = ["사업기획", "마케팅", "영업", "재무/회계", "전략/컨설팅", "투자/고문", "(사업)그외"];
    var person_f = ["작가/블로거", "인플루언서/스트리머", "작곡(사운드)", "영상", "운영", "QA", "기타"];
    var target = document.getElementById("personResult");

    if (e.value == "a") var d = person_a;
    else if (e.value == "b") var d = person_b;
    else if (e.value == "c") var d = person_c;
    else if (e.value == "d") var d = person_d;
    else if (e.value == "e") var d = person_e;
    else if (e.value == "f") var d = person_f;

    target.options.length = 0;

    for (x in d) {
        var opt = document.createElement("option");
        opt.value = d[x];
        opt.innerHTML = d[x];
        target.appendChild(opt);
    }
}

//모집인원 추가
let count = 1;
$("#personAddBtn").click(function () {
    let length = $("#personWrap").children().length;

    if(length != 9) {
        let str = "";

        str += "<div class='selectBoxWrap'>";
        str += "<div class='selectBox'>";
        str += "<select onchange='personChange(this)'>";
        str += "<option value='a'>기획</option>";
        str += "<option value='b'>디자인</option>";
        str += "<option value='c'>프론트엔드개발</option>";
        str += "<option value='d'>백엔드개발</option>";
        str += "<option value='e'>사업</option>";
        str += "<option value='f'>기타</option>";
        str += "</select>";
        str += "</div>";
        str += "<div class='selectBox'>";
        str += "<select id='personResult'>";
        str += "<option>UI/UX 기획</option>";
        str += "<option>게임 기획</option>";
        str += "<option>프로젝트 매니저</option>";
        str += "<option>하드웨어(제품) 기획</option>";
        str += "</select>";
        str += "</div>";
        str += "<div class='plusMinusBtnWrap'>";
        str += "<button type='button' class='imageBtn minus' disabled></button>";
        str += "<div class='countNumber'>1</div>";
        str += "<button type='button' class='imageBtn plus'></button>";
        str += "</div>";
        str += "</div>";

        $("#personWrap").append(str);
    }
});

//모집인원 삭제
$("#personDeleteBtn").click(function(){
   let div = $("#personWrap").children().last();
   div.remove();

});


//참고자료 추가
$("#addReferenceBtn").click(function () {
    let length = $("#referenceWrap").children().length;

    if(length != 5) {
        let str = "";

        str += "<div>";
        str += "<input type='text' placeholder='예) http://letspl.me'>";
        str += "</div>";

        $("#referenceWrap").append(str);
    }
});

//모집인원 삭제
$("#deleteReferenceBtn").click(function(){
    let div = $("#referenceWrap").children().last();
    div.remove();

});


//토스트 에디터
const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    height: '600px',
    initialEditType: 'wysiwyg',
    previewStyle: 'vertical',
    initialValue: '1. 프로젝트의 시작 동기\n   ' +
        ' - 왜 이 서비스를 만드시고 싶은지 적어주세요 \n' +
        ' (ex - 기존에 찾기 어려운 여행정보를 한번에 모아서 보여줄 예정입니다) \n' +
        ' - 어떤 사용자들을 타겟하고 있는지 적어주세요 \n' +
        ' (ex - 혼자 여행하는 것에 꺼리낌이 없는 30대 이상의 미혼 남녀를 대상으로 합니다) \n' +
        '\n' +
        '2. 회의 진행/모임 방식\n' +
        ' - 1주에 몇번정도 회의나 모임을 진행할 계획인가요? \n' +
        ' (ex - 1주일에 1회/2회 정도 정기적으로 회의합니다)\n' +
        ' - 온/오프라인 회의 진행시 진행방식을 적어주세요 \n' +
        ' (ex - 온라인은 줌을 활용하고, 오프라인은 강남역 카페등을 대관할예정입니다, 커뮤니케이션은 슬랙을 위주로 사용합니다 )\n   ' +
        '3. 그외 자유기재 \n' +
        '\n' +
        '-  2번까지의 내용을 포함할 수 있도록 작성해주세요(형식은 달라도 상관없습니다)\n' +
        '-  신청시 기타사항과 질문내용 등을 삭제한 후 답변만 등록해주세요. \n' +
        '   (그외의 내용은 자유롭게 기입해주세요(영상/이미지 포함) \n' +
        '-  상세 검수가이드라인은 공지사항을 참고해주세요. https://letspl.me/notice/80'
});








//써머노트 로딩
$(document).ready(function () {
    $('#summernote').summernote({
        height: 300,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",					// 한글 설정
        placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
    });
});
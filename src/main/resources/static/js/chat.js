/* chatting */

$("div.chattingOpen").on("click", function () {
    $(this).removeClass("open");
    $("div.chatting").addClass("open");
})

$("div.foldChatButton").on("click", function () {
    $(this).parents("div.chatting").removeClass("open");
    $("div.chattingOpen").addClass("open");
})


//userNickName 세션 담기
let mysession = document.getElementById("userNickName").value;

sessionStorage.setItem("mysession", mysession);

$(document).ready(function () {
    채팅방연결(mysession)
    채팅방내이름지우기(mysession)

})


//전체 회원 목록

let users = "";
$.ajax({
    url: "/list",
    dataType: "json",
    type: "get",
    async: false,
    success: function (data) {
        users = data
    },
    error: function () {
        alert("회원 목록 가져오기 실패");
    }
});


//회원목록 맵핑
let ulclass = document.getElementById('ulclass')
// ?는 준비됐니?
users?.map((v) => {
    ulclass.innerHTML += `
            <li  class="username" >${v}</li> 
        `
})
let username = document.querySelectorAll('.username')
for (let i = 0; i < username.length; i++) {

    username[i].innerText.split(" ")[0] === mysession ? username[i].style.display = "none" : ""


}


//채팅내역있으면 보여주기
let chatList = [];
$.ajax({
    url: `/chatList/${mysession}/${mysession}`,
    dataType: "json",
    type: "get",
    async: false,
    success: function (data) {
        chatList = data
    },
    error: function () {
    }
});


//채팅내역 렝스가 0 이면  존재하지않음 출력  => 0이상 방이름 생성
let chatLists = document.getElementById('chatLists')
if (chatList.length === 0) {
    chatLists.innerHTML += '<li class="nametd">채팅내역이 존재하지 않음</li>'
    document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 40%;'>채팅을 시작해보세요</div>"
} else {
    chatList?.map((v) => {
        chatLists.innerHTML += `<li data-room=${v.roomName} class="nametd" style="font-weight: 500;font-size: 15px;color: #333;" >
                <a>${v.roomName}</a><span class="thischat"> 채팅하기<input type="hidden" id="valuehidden" value="${v.roomName}"></span></li>`
        document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 70px;'>채팅을시작하려면 상대방을 선택해주세요</div>"

    })
}

//처음 대화 시작
ulclass.addEventListener('click', function (e) {
    if (e.target.tagName === "LI") {
        other = e.target.innerText
        처음대화(mysession, other)
    }
})

const 채팅방연결 = (mysession) => {


    chatLists.addEventListener('click', function (e) {
        if (e.target.tagName === "LI") {
            roomNames = e.target.dataset.room
            roomNames.split("&")[0] === mysession ? 방만들기(roomNames) : 기존방연결(roomNames)
        }
    })
}

//채팅방에서 내이름 빼기
const 채팅방내이름지우기 = (mysession) => {
    let nametd = document.querySelectorAll('.nametd');
    //얘는 변수 바꿔도댐
    for (let i = 0; i < nametd.length; i++) {
        let receiverName = nametd[i].innerText
        let matchname = receiverName.match(mysession)
        let finl = receiverName.replace(matchname, '');
        let endremove = finl.match("&")
        let endfinal = finl.replace(endremove, '');
        let final = finl.split(' ')[0];
        final === mysession ? nametd[i].innerText = "나와의 채팅" : nametd[i].innerText = endfinal
    }
}


const 기존방연결 = (roomNames) => {
    other = roomNames.split("&")[0]
    sessionStorage.setItem("other", other)
    sessionStorage.setItem("roomNames", roomNames)
    console.log(roomNames)
    $("#chatWrapSecond").load(`/rooms/${roomNames}`);
}


const 방만들기 = (roomNames) => {
    $.ajax({
        type: "POST",
        url: ` /room/new `,
        data: roomNames,
        contentType: "application/json",
        success: function () {
            let endremove = roomNames.match("&")
            let endfinal = roomNames.replace(endremove, '');
            let others = endfinal.match(mysession)
            let other = endfinal.replace(mysession, '');
            console.log(other + "방만들기에서 나온 other")
            sessionStorage.setItem("other", other)
            sessionStorage.setItem("roomNames", roomNames)
            $("#chatWrapSecond").load(`/rooms/${roomNames}`);
        },
        error: function () {
            alert("방생성 실패 ");
        }
    })
}


const 처음대화 = (mysession, other) => {

    $.ajax({
        type: "POST",
        url: `/chatHistory/${mysession}/${other}`,
        contentType: "application/json",

        success: function () {

            let result = "";
            $.ajax({
                url: `/connectRoom/${mysession}/${other}`,
                dataType: "json",
                type: "get",
                async: false,
                success: function (data) {
                    result = data
                    let roomNames = result[0].roomName;
                    console.log(roomNames)

                    방만들기(roomNames);
                },
            });
        },
        error: function () {
            let roomNames = mysession + "&" + other
            console.log(roomNames + "에러타입")
            방만들기(roomNames);
        }
    })
};


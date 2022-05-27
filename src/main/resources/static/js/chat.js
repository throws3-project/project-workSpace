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
let myName = document.getElementById("userNickName").value;

sessionStorage.setItem("myName", myName);


//세션가져오기
let v = sessionStorage.getItem("myName");


//전체 회원 목록 ※필요없슴※

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
            <li class="username" style="margin-top: 10px; ">${v}<span class="thischat"> 채팅하기<input type="hidden" id="valuehidden" value="${v}"></span></li> 
        `
})
let username = document.querySelectorAll('.username')
for (let i = 0; i < username.length; i++) {

    username[i].innerText.split(" ")[0] === myName ? username[i].style.display = "none" : ""


}



//채팅내역있으면 보여주기
let chatList = [];
$.ajax({
    url: `/chatList/${myName}/${myName}`,
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
chatLists = document.getElementById('chatLists')
if (chatList.length === 0) {
    chatLists.innerHTML += '<li class="nametd">채팅내역이 존재하지 않음</li>'
    document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 40%;'>채팅을 시작해보세요</div>"
} else {
    chatList?.map((v) => {
        chatLists.innerHTML += `<li class="nametd"  >${v.roomName}</li>`
        document.getElementById('chatWrapSecond').innerHTML = "<div style='position: absolute;top: 40%;left: 70px;'>채팅을시작하려면 상대방을 선택해주세요</div>"

    })
}
removesession();

//채팅방에서 내이름 빼기
function removesession() {
    //얘는 변수 바꿔도댐
    let nametd = document.querySelectorAll('.nametd');

    for (i = 0; i < nametd.length; i++) {

        let receiverName = nametd[i].innerText
        let matchname = receiverName.match(v)
        let finl = receiverName.replace(matchname, '');

        nametd[i].innerText = finl

    }

}



let thischat = document.querySelectorAll(".thischat");


ulclass.addEventListener('click', function (e) {
    if (e.target.tagName === "SPAN") {

        const other = e.target.lastChild.value;

        //세션주기
        // sessionStorage.setItem("other", other);
        // startChat(other)
        //
        // document.getElementsByClassName('userId')[0].innerText = other;
    }
})

//대화 시작하기
//채팅방 존재 검사 후  succ => 기존이름생성 err=> 새로운 이름 생성
function startChat(other) {
    $.ajax({
        type: "POST",
        url: `/chatHistory/${v}/${other}`,
        contentType: "application/json",

        success: function () {

            let result = "";
            $.ajax({
                url: `/connectRoom/${v}/${other}`,
                dataType: "json",
                type: "get",
                async: false,
                success: function (data) {
                    result = data
                    let roomNames = result[0].roomName;

                    makeRoom(roomNames);
                },

            });
        },
        error: function () {
            let roomNames = v + other
            makeRoom(roomNames);
        }
    });
}


//방생성 하기!
const makeRoom = (roomNames) => {
    $.ajax({
        type: "POST",
        url: `/room/new `,
        data: roomNames,
        contentType: "application/json",
        success: function () {
            sessionStorage.setItem("roomNames", roomNames);
            $("#chatWrapSecond").load(`/rooms/${roomNames}`);
            // window.open(`/rooms/${roomNames}`, "_blank", "채팅", "width:300px  height: 400px, top=10, left=10");
        },
        error: function () {
            console.log(roomNames)
            alert("방 생성 실패");
        }
    })
}
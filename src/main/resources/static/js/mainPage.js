const btns = document.querySelectorAll("button.btn");
const lis = document.querySelectorAll("li.dot");
const littleBtns = document.querySelectorAll("li.dot");
const banner = document.querySelector("div.banner");
const bannerM = document.querySelector("div.bannerM");
const arrows = document.querySelectorAll("div.arrow");
let count = 0;

// btns.forEach(function(value, index, ar){
//     ar[index].addEventListener("click", function(){
//         count = index;
//         banner.style.transform = "translate(-" + count * 100 + "vw)";
//     })
// });

// 배너 버튼 클릭시 배너 사진 변경
lis.forEach(function(value,index,ar){
    ar[index].addEventListener("click", function(){
        count = index;
        banner.style.transform = "translate(-" + count * 100 + "vw)";
        bannerM.style.transform = "translate(-" + count * 414 + "px)";
        $("li.dot").removeClass("selected");
        $($("li.dot").get(count)).addClass("selected");
    })
})

// 배너 화살표 클릭시 배너 사진 변경
arrows.forEach((arrow) => {
    arrow.addEventListener("click", function () {
        let arrowType = arrow.classList[1];
        if(arrowType == 'prev' && count != 0){
            count--;
        }else if(arrowType == 'next' && count != lis.length -1){
            count++;
        }else{
            if(count == lis.length -1){
                count = 0;
            }else{
                count = lis.length -1;
            }
        }
        $("li.dot").removeClass("selected");
        $($("li.dot").get(count)).addClass("selected");
        banner.style.transform = "translate(-" + count * 100 + "vw)";
        bannerM.style.transform = "translate(-" + count * 414 + "px)";
    });
});


// 3초마다 배너 사진 변경
setInterval(function(){
    count++;
    count = count == 2 ? 0 : count;
    banner.style.transform = "translate(-" + count * 100 + "vw)";
    bannerM.style.transform = "translate(-" + count * 414 + "px)";
    $("li.dot").removeClass("selected");
    $($("li.dot").get(count)).addClass("selected");
}, 3000);

// setInterval(function(){
//     count++;
//     count = count == 2 ? 0 : count;
//     bannerM.style.transform = "translate(-" + count * 414 + "px)";
//     $("li.dot").removeClass("selected");
//     $($("li.dot").get(count)).addClass("selected");
// }, 3000);
// 모달

// $('.modalBtn').each(function(i, btn){
//     $(btn).on("click", function(){
//         $($(".modalWindow").get(i)).show();
//     });
// });
//
// $('.modal_close_btn').each(function(i, btn){
//     $(btn).on("click", function(){
//         $($(".modalWindow").get(i)).hide();
//     });
// });


// 모달 확인 누를 시 모달창 꺼짐.
$('.complete').each(function(i, btn){
    $(btn).on("click", function(){
        $($(".modalWindow").get(i)).hide();
    });
});
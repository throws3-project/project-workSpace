// $("p#v").on("click",function () {
//     $("p#v").css("transform","scaleY(-1)");
//     $("p#v").css("transition",".3s");
// })

/*faq열고 닫기*/
let count = [];
count.length = $(".tableCell").length;
for (let i = 0; i < count.length; i++) {
    count[i] = 0;
}
$(".tableCell").each(function (i, cell) {
    $(cell).on("click", function () {
        count[i]++;
        count[i] == 2 ? count[i] = 0 : count[i] = 1;
        if (count[i] == 1) {
            $($(".open").get(i)).css("transform", "scaleY(-1)");
            $($(".open").get(i)).css("transition", ".3s");
            $($(".close").get(i)).show();
        }else{

            $($(".open").get(i)).css("transform", "scaleY(1)");
            $($(".open").get(i)).css("transition", ".3s");
            $($(".close").get(i)).hide();
        }
    })
})

$($(".navBorder").get(0)).css("background-color","black");
$($(".nav").get(0)).css("color","white");
$(".navBorder").each(function (i,nav) {
    $(nav).on("click",function (e) {
        e.preventDefault();
        $(".faqSection").hide();
        $(".navBorder").css("background-color","white ");
        $(".nav").css("color","black ");
        $($(".faqSection").get(i)).show();
        $($(".nav").get(i)).css("color","white ");
        $($(".navBorder").get(i)).css("background-color","black ");
    })
    $(nav).on("mouseover",function () {
        $($(".nav").get(i)).addClass("color");
        $($(".navBorder").get(i)).addClass("back");
    })
    $(nav).on("mouseout",function () {
        $($(".nav").get(i)).removeClass("color");
        $($(".navBorder").get(i)).removeClass("back");
    })
})


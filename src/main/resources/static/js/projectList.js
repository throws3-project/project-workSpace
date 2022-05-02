$(document).ready(function () {
    $("#header").load('../../templates/fix/header.html');
    $("#footer").load('../../templates/fix/footer.html');
});
// banner-button
let arrows = document.querySelectorAll("button.banner-button");
let li = document.querySelectorAll("li.slide");
let banner = document.querySelector("ul.slider");
let count = 0;

// banner
arrows.forEach((arrow) => {
    arrow.addEventListener("click", function () {
        let arrowType = arrow.classList[1];
        if (arrowType === 'prev-arrow' && count !== 0) {
            count--;
            $(".slide").removeClass("selected");
            li[count].classList.add("selected");
        } else if (arrowType === 'next-arrow' && count !== li.length - 1) {
            count++;
            $(".slide").removeClass("selected");
            li[count].classList.add("selected");
        } else {
            if (count === li.length - 1) {
                count = 0;
                $(".slide").removeClass("selected");
                li[count].classList.add("selected");
            } else {
                count = li.length - 1;
                $(".slide").removeClass("selected");
                li[count].classList.add("selected");
            }
        }

        banner.style.transform = "translate3d(-" + count * 100 + "%, 0px, 0px)";
    });
});

// recruitModel display
$("div.recruitStatus").on("mouseover", function () {
    $(this).parent().children().closest("div.recruitModel").css("display", "block");
})

$("div.recruitStatus").on("mouseout", function () {
    $(this).parent().children().closest("div.recruitModel").css("display", "none");
})

$("div.recruitModel").on("mouseover", function () {
    $(this).css("display", "block");
})

$("div.recruitModel").on("mouseout", function () {
    $(this).css("display", "none");
})

// heart click

// move content

// move site
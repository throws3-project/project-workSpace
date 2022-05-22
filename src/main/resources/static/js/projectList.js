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

// Auto Slide
// setInterval(function() {
//     if (count == li.length - 1) {
//         count = 0;
//         $(".slide").removeClass("selected");
//         li[count].classList.add("selected");
//     }else {
//         count++;
//     }
//     banner.style.transform = "translate3d(-" + count * 100 + "%, 0px, 0px)";
// }, 5000);



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


$(".filters").each(function (i,filter) {
$(filter).on("change",function () {
    let formData = new FormData();
    $($(".filter").get(i)).val($(this).val());
    if($("#checkFilter").is(":checked")==true){
        $($(".filter").get(2)).val("1");
    }else{
        $($(".filter").get(2)).val("0")
    }

    formData.append("locationFilter", $($(".filter").get(0)).val());
    formData.append("skillFilter", $($(".filter").get(1)).val());
    formData.append("statusFilter", $($(".filter").get(2)).val());

    $.ajax({
        url: "/project/projectFilter",
        data: formData,
        type: "POST",
        // 현재 설정된 헤더 설정을 기본 방식으로 변경하지 못하도록 false로 설정
        processData: false,
        contentType: false,
        success: function (result) {
            projectList(result);
        }
    });
})
})

// String locationFilter;
// String skillFilter;
// Long statusFilter;
// console.log(projects);
projectList(projects);

function projectList(result) {
    let str = '';
if(!result.length){ $(".projectGridView").html("");}
else if(result.length) {
    $(result).each(function (i, project) {
        let imgName = "";
        if(project.projectImgPath){
            imgName= '/project/display?fileName=' + project.projectImgPath + '/' + project.projectImgUuid + '_' + project.projectImg;
        }else if(!project.projectImgPath){imgName='/images/'+project.projectImg; }

        let status = "";
        if(project.projectStatus==1){status="모집중";}
        else if(project.projectStatus==2){status="모집완료";}

        str += '<div class="projectGridWrap">'
        str += '<a href="/project/projectDetail/project/'+project.projectNum+'">'
        str += '<div class="projectTopInfo">'
        str += '<div class="topInfo">'
        str += '<div class="box-wrap">'
        str += '<div class="box green">'
        str += '<span>NEW</span>'
        str += '</div>'
        str += '<div class="box black">'
        str += '<span>사이드프로젝트</span>'
        str += '</div>'
        str += '</div>'
        str += '<div class="favorite"></div>'
        str += '</div>'
        str += '<div class="projectImg">'
        str += '<img src="'+imgName+'">'
        str += '</div>'
        str += '</div>'
        str += '<div class="projectMiddleInfo"> '
        str += '<p class="category">' + project.projectPart + '</p> '
        str += '<p class="categoryText">[' + project.projectLocation + '] ' + project.projectName + '</p>'
        str += '</div>'
        str += '<div class="projectBottomInfo">'
        str += '<div class="middleWrap">'
        str += '<div class="left">'
        str += '<div class="heart">'
        str += '<img src="https://letspl.me/assets/images/ic-favorite-empty-white.svg">'
        str += '<span class="heartCount">0</span>'
        str += '</div>'
        str += '</div>'
        str += '<div class="right">'
        str += '<div>'
        str += '<span>' + project.projectReadCount + '</span>'
        str += '</div>'
        str += '</div>'
        str += '</div>'
        str += '</a>'
        str += '<div class="bottomWrap"> '
        str += '<div class="recruit"> '
        str += '<div class="recruitStatus"> '
        str += '<span>' + status + '</span>'
        str += '<span>0/' + project.projectTotal + '</span>'
        str += '<div>'
        str += '<img src="https://letspl.me/assets/images/ic-arrow-up.svg">'
        str += '</div>'
        str += '</div>'
        str += '<div class="recruitModel">'
        str += '<ul>'
        str += '<li>'
        str += '<span>UI/UX기획</span>'
        str += '<span>1명</span>'
        str += '</li>'
        str += '</ul>'
        str += '</div>'
        str += '</div>'
        str += '</div>'
        str += '</div>'
        str += '</div>'
        $(".projectGridView").html(str);
    })
}
}
// 스토리 동적쿼리
$("select.storyPart").on("change",function () {
    let storyPart = $(this).val();
    console.log(storyPart);
    storyService.selectList(storyPart, function (storyVO, userVO, storyTagVOs, storyLikeSize, storyReplySize) {
        let str ="";

        console.log(storyVO);
        if (storyVO == null || storyVO.length == 0) {
                    console.log("들어옴");
            $("ul.storyTimeUl").html(str);
                    return;
                }

       for(let i = 0; i<storyVO.length;i++) {
           str += '<li class="storyTimeLi">';
           str += '<div class="storyTimeLineLeft">';
           str += '<div class="storyTimeLineImg">';
           str += '<img src="/story/display?fileName='+ storyVO[i].storyImgPath + '/' + storyVO[i].storyImgUuid + '_' + storyVO[i].storyImgName + '">';
           str += '</div>';
           str += '<div class="storyTimeLineContents">';
           str += '<div class="timeLineTitWrap">';
           str += '<span class="timeLintCategory">'+ userVO[i].userNickName +'</span>';
           str += '<p class="timeLineTit">['+ storyVO[i].storyPart +'] ' + storyVO[i].storyTitle + '</p>';
           str += '</div>';
           str += '<div class="timeLineTxt">' + storyVO[i].storyContent;
           str += '</div>';
           str += '<div class="timeLineTagWrap">';


           if (storyTagVOs[i] == null || storyTagVOs[i].length == 0) {
               for(let j = 0; j<storyTagVOs[i].length; j++) {
                   str += '<span>#'+ storyTagVOs[i][j].tagName +'</span> ';
               }
           }

           str += '</div>';
           str += '</div>';
           str += '</div>';
           str += '<div class="storyTimeLineRight">';
           str += '<div class="TimeLineStatusWrap">';
           str += '<p class="storyTimeLineStatusDiv" style="margin-right: 16px !important;">';
           str += '<img class="storyTimeLineDivImg" src="/images/eye.png">';
           str += '<span class="divFooterTxt">'+ storyVO[i].storyReadCount +'</span>';
           str += '</p>';
           str += '<p class="storyTimeLineStatusDiv" style="margin-right: 16px !important;">';
           str += '<img class="storyTimeLineDivImg" src="/images/msg.png">';
           str += '<span class="divFooterTxt">'+ storyReplySize[i] +'</span>';
           str += '</p>';
           str += '<p class="storyTimeLineStatusDiv" style="margin-right: 16px !important;">';
           str += '<img class="storyTimeLineDivImg" src="/images/likeup.png">';
           str += '<span class="divFooterTxt">'+ storyLikeSize[i] +'</span>';
           str += '</p>';
           str += '</div>';
           str += '</div>';
           str += '</li>';
       }
       $("ul.storyTimeUl").html(str);
    })
})


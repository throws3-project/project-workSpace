let storyService = (function () {
    function selectList(storyPart, callback) {
        console.log(storyPart);
        $.ajax({
            type:"GET",
            url:"/story/selectList/" + storyPart,
            success: function (storyDTO) {
                console.log(storyDTO);
                if (callback) {
                    callback(storyDTO.storyVO, storyDTO.userVO, storyDTO.storyTagVOs, storyDTO.storyLikeSize, storyDTO.storyReplySize);
                }
            },
            error: function (xhr, status, error) {
                if (error) {
                }
            }
        })
    }
    return {selectList: selectList}
})();
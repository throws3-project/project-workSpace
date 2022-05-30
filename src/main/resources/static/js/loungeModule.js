let loungeService = (function () {
    //댓글 목록
    function getList(loungeNum, callback){
        $.ajax({
            type:"GET",
            url:"/lounge/reply/" + loungeNum,
            success: function (loungeReplyDTO) {
                if (callback) {
                    callback(loungeReplyDTO.userNickNames, loungeReplyDTO.replies);
                }
            },
            error: function (xhr, status, error) {
                if (error) {
                }
            }
        });
    }
    
    function insertLounge(param, callback) {
        $.ajax({
            type:"GET",
            url:"/lounge/"+ param.loungeContent + "/" + param.userNum,
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, error) {
                if (error) {
                }
            }
        })
    }

    function insertReply(param, callback) {
        $.ajax({
            type:"GET",
            url:"/lounge/loungeInsert/"+ param.replyContent + "/" + param.userNum + "/" + param.loungeNum,
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, error) {
                if (error) {
                }
            }
        })
    }

    function deleteLounge(loungeNum, callback) {
        $.ajax({
            type:"GET",
            url:"/lounge/loungeDelete/"+ loungeNum,
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, error) {
                if (error) {
                    alert("실패");
                }
            }
        })
    }

    function updateLounge(param, callback) {
        $.ajax({
            type:"GET",
            url:"/lounge/loungeUpdate/"+ param.loungeNum +"/" + param.loungeContent,
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, error) {
                if (error) {
                }
            }
        })
    }

    return {getList: getList, insertLounge:insertLounge, insertReply:insertReply, deleteLounge:deleteLounge, updateLounge:updateLounge}
})();
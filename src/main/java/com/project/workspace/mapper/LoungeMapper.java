package com.project.workspace.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoungeMapper {
    public void insertLounge(Long userNum, String loungeContent);
    public void insertLikeLounge(Long loungeNum, Long userNum);
    public void insertLoungeReply(Long loungeNum, Long userNum,String loungeReplyContent);
}

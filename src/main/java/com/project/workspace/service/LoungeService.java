package com.project.workspace.service;

import org.springframework.stereotype.Service;

@Service
public interface LoungeService {
    public void insertLounge(Long userNum, String loungeContent);
    public void insertLikeLounge(Long loungeNum, Long userNum);
    public void insertLoungeReply(Long loungeNum, Long userNum,String loungeReplyContent);
}

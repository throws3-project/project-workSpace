package com.project.workspace.service;

import com.project.workspace.domain.dao.LoungeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoungeServiceImpl implements LoungeService{
    private final LoungeDAO loungeDAO;

    @Override
    public void insertLounge(Long userNum, String loungeContent) {
        loungeDAO.insertLounge(userNum, loungeContent);
    }

    @Override
    public void insertLikeLounge(Long loungeNum, Long userNum) {
        loungeDAO.insertLikeLounge(loungeNum, userNum);
    }

    @Override
    public void insertLoungeReply(Long loungeNum, Long userNum, String loungeReplyContent) {
        loungeDAO.insertLoungeReply(loungeNum, userNum, loungeReplyContent);
    }
}

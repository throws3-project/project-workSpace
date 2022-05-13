package com.project.workspace.domain.dao;

import com.project.workspace.mapper.LoungeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoungeDAO {
    private final LoungeMapper loungeMapper;

    public void insertLounge(Long userNum, String loungeContent){loungeMapper.insertLounge(userNum, loungeContent);}
    public void insertLikeLounge(Long loungeNum, Long userNum){loungeMapper.insertLikeLounge(loungeNum, userNum);}
    public void insertLoungeReply(Long loungeNum, Long userNum,String loungeReplyContent){loungeMapper.insertLoungeReply(loungeNum, userNum, loungeReplyContent);}
}

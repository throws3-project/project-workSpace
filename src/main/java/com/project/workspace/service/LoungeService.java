package com.project.workspace.service;

import com.project.workspace.domain.vo.LoungeLikeVO;
import com.project.workspace.domain.vo.LoungeVO;
import com.project.workspace.domain.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoungeService {
    public void insertLounge(Long userNum, String loungeContent);
    public void insertLikeLounge(Long loungeNum, Long userNum);
    public void insertLoungeReply(Long loungeNum, Long userNum,String loungeReplyContent);
    public List<UserVO> selectLikes();
}

package com.project.workspace.service;

import com.project.workspace.domain.dao.LoungeDAO;
import com.project.workspace.domain.repository.LoungeLikeRepository;
import com.project.workspace.domain.repository.LoungeReplyRepository;
import com.project.workspace.domain.vo.LoungeLikeVO;
import com.project.workspace.domain.vo.LoungeReplyVO;
import com.project.workspace.domain.vo.LoungeVO;
import com.project.workspace.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoungeServiceImpl implements LoungeService{
    private final LoungeDAO loungeDAO;
    private final LoungeReplyRepository loungeReplyRepository;
    private final LoungeLikeRepository loungeLikeRepository;

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

    @Override
    public List<UserVO> selectLikes() {
        return loungeLikeRepository.selectByLoungeVO();
    }
}

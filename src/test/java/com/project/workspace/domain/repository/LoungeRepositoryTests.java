package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.LoungeLikeVO;
import com.project.workspace.domain.vo.LoungeReplyVO;
import com.project.workspace.domain.vo.LoungeVO;
import com.project.workspace.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class LoungeRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoungeRepository loungeRepository;
    @Autowired
    private LoungeReplyRepository loungeReplyRepository;
    @Autowired
    private LoungeLikeRepository loungeLikeRepository;

    // 라운지

//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        loungeRepository.save(LoungeVO.builder().loungeContent("1").userVO(userVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest() {
//        userRepository.findById(1L).get().getLounges().stream().map(LoungeVO::toString).forEach(log::info);
//    }

    // 라운지 좋아요

//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        LoungeVO loungeVO = loungeRepository.findById(1L).get();
//        loungeLikeRepository.save(LoungeLikeVO.builder().loungeVO(loungeVO).userVO(userVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest() {
//        userRepository.findById(1L).get().getLoungeLikes().stream().map(LoungeLikeVO::toString).forEach(log::info);
//    }

    // 라운지 리플라이

//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        LoungeVO loungeVO = loungeRepository.findById(1L).get();
//        loungeReplyRepository.save(LoungeReplyVO.builder().loungeReplyContent("1").loungeReplyStatus("1").loungeVO(loungeVO).userVO(userVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest() {
//        loungeRepository.findById(1L).get().getReplies().stream().map(LoungeReplyVO::toString).forEach(log::info);
//        userRepository.findById(1L).get().getLoungeReplies().stream().map(LoungeReplyVO::toString).forEach(log::info);
//    }
}

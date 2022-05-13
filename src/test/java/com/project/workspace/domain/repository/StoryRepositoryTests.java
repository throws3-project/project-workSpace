package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class StoryRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private StoryTagRepository storyTagRepository;
    @Autowired
    private StoryReplyRepository storyReplyRepository;
    @Autowired
    private StorySeriesRepository storySeriesRepository;
    @Autowired
    private StoryLikeRepository storyLikeRepository;

    // 스토리
//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        storyRepository.save(StoryVO.builder().storyPart("안녕").storyContent("11").storyImgName("11").storyImgPath("1").storyImgUuid("1").storyTitle("123").userVO(userVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
////        log.info(storyRepository.findById(1L).get().toString());
//       userRepository.getById(1L).getStories().stream().map(StoryVO::toString).forEach(log::info);
//    }

    // 스토리 태그
//    @Test
//    public void insertTest(){
//        StoryVO storyVO = storyRepository.findById(1L).get();
//        storyTagRepository.save(StoryTagVO.builder().tagName("xml").storyVO(storyVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
////        log.info(storyRepository.findById(1L).get().toString());
//       storyRepository.getById(1L).getTags().stream().map(StoryTagVO::toString).forEach(log::info);
//    }

    // 스토리 리플라이

//    @Test
//    public void insertTest(){
//        StoryVO storyVO = storyRepository.findById(1L).get();
//        UserVO userVO = userRepository.findById(1L).get();
//        storyReplyRepository.save(StoryReplyVO.builder().storyReply("1").status("1").storyVO(storyVO).userVO(userVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
//        storyRepository.getById(1L).getReplies().stream().map(StoryReplyVO::toString).forEach(log::info);
//    }

    // 스토리 시리즈
//    @Test
//    public void insertTest(){
//        StoryVO storyVO = storyRepository.findById(1L).get();
//        UserVO userVO = userRepository.findById(1L).get();
//        storySeriesRepository.save(StorySeriesVO.builder().seriesName("아").storyVO(storyVO).userVO(userVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
//        storyRepository.getById(1L).getSeries().stream().map(StorySeriesVO::toString).forEach(log::info);
//    }

    // 스토리 좋아요
//    @Test
//    public void insertTest(){
//        StoryVO storyVO = storyRepository.findById(1L).get();
//        UserVO userVO = userRepository.findById(1L).get();
//        storyLikeRepository.save(StoryLikeVO.builder().storyVO(storyVO).userVO(userVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
//        storyRepository.getById(1L).getLikes().stream().map(StoryLikeVO::toString).forEach(log::info);
//    }

}

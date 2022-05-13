package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StudyKeywordVO;
import com.project.workspace.domain.vo.StudyMemberVO;
import com.project.workspace.domain.vo.StudyVO;
import com.project.workspace.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
@Slf4j
public class StudyRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudyRepository studyRepository;
    @Autowired
    private StudyKeywordRepository studyKeywordRepository;
    @Autowired
    private StudyMemberRepository studyMemberRepository;

    // 스터디

//    @Test
//    public void studyInsertTest(){
//        UserVO userVO = userRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
//        String title = "같";
//        String part = "java";
//        String location = "2";
//        String on = "1";
//        Long max = 10L;
//        String content = "안녕";
//        String status = "1";
//        Long count = 1L;
//        studyRepository.save(StudyVO.builder().studyTitle(title).studyPart(part).studyLocation(location).studyOnOff(on).studyMax(max).studyContent(content).studyStatus(status).studyReadCount(count).userVO(userVO).build());
//    }

//    @Test
//    public void selectTest(){
//        log.info(studyRepository.findById(1L).get().toString());
//    }

    //스터디 키워드

//    @Test
//    public void insertTest(){
//        StudyVO studyVO = studyRepository.getById(1L);
//        studyKeywordRepository.save(StudyKeywordVO.builder().studyKeyword("java").studyVO(studyVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
////       log.info(studyKeywordRepository.findById(1L).get().toString());
//       studyRepository.getById(1L).getKeywords().stream().map(StudyKeywordVO::toString).forEach(log::info);
//    }

    //스터디 멤버

//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        StudyVO studyVO = studyRepository.findById(1L).get();
//        studyMemberRepository.save(StudyMemberVO.builder().studyMemberStatus("1").studyMotive("우에").userVO(userVO).studyVO(studyVO).build());
//    }

//        @Test
//    @Transactional
//    public void selectTest(){
////       log.info(studyKeywordRepository.findById(1L).get().toString());
//       studyRepository.getById(1L).getMembers().stream().map(StudyMemberVO::toString).forEach(log::info);
//    }

}

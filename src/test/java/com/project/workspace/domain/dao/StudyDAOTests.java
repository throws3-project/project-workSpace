package com.project.workspace.domain.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyDAOTests {
    @Autowired
    private StudyDAO studyDAO;


//    @Test
//    public void TestInsertStudy(){
//        studyDAO.insertStudy(1L,"공부하자CSS","a","b","c","css공부를 합니다.");
//    }

//    @Test
//    public void testGetPortList(){
//    studyDAO.getStudyList().forEach(studyVO -> log.info(studyVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void TestInsertStudyKeyword(){
//        studyDAO.insertKeyword(1L,"자바");
//    }

//    @Test
//    public void testGetPortList(){
//    studyDAO.getKeywordList().forEach(studyKeywordVO -> log.info(studyKeywordVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void TestInsertStudyMember(){
//        studyDAO.insertMember(1L,1L, "열심히 하겠습니다.");
//    }

//    @Test
//    public void testGetStudyMember(){
//    studyDAO.getMemberList().forEach(studyMemberVO -> log.info(studyMemberVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }
}

package com.project.workspace.domain.repository;

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
public class studyRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudyRepository studyRepository;

    @Test
    public void studyInsertTest(){
        UserVO userVO = userRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
        String title = "같";
        String part = "java";
        String location = "2";
        String on = "1";
        Long max = 10L;
        String content = "안녕";
        String status = "1";
        Long count = 1L;
        studyRepository.save(StudyVO.builder().studyTitle(title).studyPart(part).studyLocation(location).studyOnOff(on).studyMax(max).studyContent(content).studyStatus(status).studyReadCount(count).userVO(userVO).build());
    }
}

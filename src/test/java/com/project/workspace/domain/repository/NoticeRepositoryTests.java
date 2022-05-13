package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class NoticeRepositoryTests {
    @Autowired
    private NoticeRepository noticeRepository;

//    @Test
//    public void insertTest(){
//        noticeRepository.save(NoticeVO.builder().noticeImgUuid("1").noticeImg("1").noticeImgPath("1").noticeContent("1").noticeTitle("1").build());
//    }
//    @Test
//    @Transactional
//    public void select(){
//        log.info(noticeRepository.findById(1L).get().toString());
//    }
}

package com.project.workspace.domain.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDAOTests {
    @Autowired
    private UserDAO userDAO;


//    @Test
//    public void testUserGetList(){
//        userDAO.getList().forEach(userVO -> log.info(userVO.toString()));
//    }

//    @Test
//    public void testUserGetInfo(){
//        Long userNum = 1L;
//        log.info(userDAO.getInfo(userNum).toString());
//    }

//    @Test
//    public void insertUserPort(){
//        Long userNum=1L;
//        String portUrl = "tkdgur1996";
//        userDAO.insertPortfolio(userNum,portUrl);
//    }

//    @Test
//    public void testGetPortList(){
//    userDAO.getPortList().forEach(portfolioVO -> log.info(portfolioVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testGetPortInfo(){
//    Long userNum = 1L;
//    log.info(userDAO.getPortInfo(userNum).toString());
//    log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testInsertUserTag(){
//        Long userNum = 1L;
//        String tagName="o2o";
//        userDAO.insertUserTag(userNum,tagName);
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testGetTagList(){
//        userDAO.getTagList().forEach(userTagVO -> log.info(userTagVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"    `);
//    }
//    @Test
//    public void testGetTagList(){
//        userDAO.getTagList().forEach(userTagVO -> log.info(userTagVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"    `);
//    }

//    @Test
//    public void testInsertInterest(){
//        Long userNum = 1L;
//        String interest="o2o";
//        userDAO.insertInterest(userNum,interest);
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testGetInterestList(){
//        userDAO.getInterestList().forEach(userTagVO -> log.info(userTagVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testInsertFollow(){
//        Long followerUser = 1L;
//        Long followingUser=4L;
//        userDAO.insertFollow(followerUser,followingUser);
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testGetFollowList(){
//        userDAO.getFollowList().forEach(followVO -> log.info(followVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testInsertAlert(){
//        Long userNum = 1L;
//        Long numbers=4L;
//        String alertPart = "프로젝트";
//        String alertType = "글삭제";
//        userDAO.insertAlert(userNum,alertPart,numbers,alertType);
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }

//    @Test
//    public void testGetAlertList(){
//        userDAO.getAlertList().forEach(alertVO -> log.info(alertVO.toString()));
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//    }





}

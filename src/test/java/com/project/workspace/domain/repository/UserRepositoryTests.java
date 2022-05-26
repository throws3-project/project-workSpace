package com.project.workspace.domain.repository;

import com.project.workspace.domain.repository.*;
import com.project.workspace.domain.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFollowRepository userFollowRepository;
    @Autowired
    private UserAlertRepository userAlertRepository;
    @Autowired
    private UserInterestRepository userInterestRepository;
    @Autowired
    private UserPortfolioRepository userPortfolioRepository;
    @Autowired
    private UserTagRepository userTagRepository;

    // 유저 생성
//    @Test
//    public void userVOTests(){
//        String id = "hsk123";
//        String location = "서울시";
//        String nickname = "만두";
//        String phone = "01087223322";
//        String mainSkill = "1";
//        String mainDetail = "1";
//        String userMainLevel = "1";
//        String userSubSkill = "2";
//        String userSubDetail = "21";
//        String userSubLevel = "1";
//        String userOnOff = "1";
//        String userTime = "1";
//        String userCode = "1422";
//        Long userPrice = 3L;
//        String socialType="1";
//        String userStatus="0";
//        String userImgUuid="12";
//        String userImgName="2";
//        String userImgPath="2";
//        userRepository.save(UserVO.builder().userId(id).userLocation(location).userNickName(nickname).userPhone(phone).userMainSkill(mainSkill).userMainDetail(mainDetail).userMainLevel(userMainLevel).userSubSkill(userSubSkill).userSubDetail(userSubDetail).userSubLevel(userSubLevel).userOnOff(userOnOff).userTime(userTime).userCode(userCode).userPrice(userPrice).socialType(socialType).userStatus(userStatus).userImgUuid(userImgUuid).userImgName(userImgName).userImgPath(userImgPath).build());
//    }

    // 유저 아이디로 검색
//    @Test
//    public void userVOTests(){
//       log.info(userRepository.findById(1L).get().toString());
//    }

    // 팔로우 유저 생성
//    @Test
//    public void followUserTests(){
//        Long followerUser = 3L;
//        Long followingUser = 1L;
//        userFollowRepository.save(UserFollowVO.builder().followerUser(followerUser).followingUser(followingUser).build());
//    }

    // 팔로우 유저 검색
//    @Test
//    @Transactional
//    public void followUserTests(){
//        userRepository.findById(1L).get().getUsers().stream().map(UserFollowVO::toString).forEach(log::info);
//    }

    // 유저 태그 생성
//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        userTagRepository.save(UserTagVO.builder().tagName("java").userVO(userVO).build());
//    }

//    @Test
//    public void selectTest(){
//        log.info(userTagRepository.findById(1L).get().toString());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
//        userRepository.getById(1L).getTags().stream().map(UserTagVO::toString).forEach(log::info);
//    }


    // 유저 포르폴리오 생성
//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        userPortfolioRepository.save(UserPortfolioVO.builder().portUrl("423").userVO(userVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
//        userRepository.getById(1L).getPorts().stream().map(UserPortfolioVO::toString).forEach(log::info);
//    }


    // 유저 흥미
//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        userInterestRepository.save(UserInterestVO.builder().interest("java").userVO(userVO).build());
//    }

//        @Test
//    @Transactional
//    public void selectTest(){
//        userRepository.getById(1L).getInterests().stream().map(UserInterestVO::toString).forEach(log::info);
//    }

    // 유저 알림
//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        userAlertRepository.save(UserAlertVO.builder().alertPart("java").numbers(1L).alertType("웹").userVO(userVO).build());
//    }

//    @Test
//    @Transactional
//    public void selectTest(){
//        userRepository.getById(1L).getAlerts().stream().map(UserAlertVO::toString).forEach(log::info);
//    }
}

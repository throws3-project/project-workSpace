package com.project.workspace.domain.vo;

import com.project.workspace.domain.repository.UserFollowRepository;
import com.project.workspace.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class VOTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFollowRepository userFollowRepository;

    // 유저 생성
    @Test
    public void userVOTests(){
        String id = "hsk12345";
        String name = "홍승근";
        String gender = "m";
        String location = "서울시";
        String nickname = "만두";
        String phone = "01087275322";
        String mainSkill = "1";
        String mainDetail = "1";
        String userMainLevel = "1";
        String userSubSkill = "2";
        String userSubDetail = "21";
        String userSubLevel = "1";
        String userOnOff = "1";
        String userTime = "1";
        String userCode = "122";
        Long level = 1L;
        Long userExp = 100L;
        Long userPoint = 1L;
        Long userPrice = 3L;
        String socialType="1";
        String userStatus="0";
        String userImgUuid="124";
        String userImgName="1";
        String userImgPath="1";
        userRepository.save(UserVO.builder().userId(id).userName(name).userGender(gender).userLocation(location).userNick_name(nickname).userPhone(phone).userMainSkill(mainSkill).userMainDetail(mainDetail).userMainLevel(userMainLevel).userSubSkill(userSubSkill).userSubDetail(userSubDetail).userSubLevel(userSubLevel).userOnOff(userOnOff).userTime(userTime).userCode(userCode).userLevel(level).userExp(userExp).userPoint(userPoint).userPrice(userPrice).socialType(socialType).userStatus(userStatus).userImgUuid(userImgUuid).userImgName(userImgName).userImgPath(userImgPath).build());
    }

    // 유저 아이디로 검색
//    @Test
//    public void userVOTests(){
//       log.info(userRepository.findById(1L).get().toString());
//    }

//    @Test
//    public void followUserTests(){
//        Long followerUser = 3L;
//        Long followingUser = 1L;
//        userFollowRepository.save(UserFollowVO.builder().followerUser(followerUser).followingUser(followingUser).build());
//    }

    @Test
    @Transactional
    public void User(){
        log.info(userRepository.getById(1L).getUsers().toString());
    }

}

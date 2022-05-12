package com.project.workspace.mapper;


import com.project.workspace.domain.vo.*;
import com.project.workspace.domain.vo.UserPortfolioVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    public List<UserVO> getList();
    public UserVO getInfo(Long userNum);

    public void insertPortfolio(Long userNum, String portUrl);
    public UserPortfolioVO getPortInfo(Long userNum);
    public List<UserPortfolioVO> getPortList();

    public void insertUserTag(Long userNum, String tagName);
    public List<UserTagVO> getTagList();

    public void insertInterest(Long userNum , String interest);
    public List<UserInterestVO> getInterestList();

    public void insertFollow(Long followerUser , Long followingUser);
    public List<UserFollowVO> getFollowList();

    public void insertAlert(Long userNum , String alertPart, Long numbers, String alertType);
    public List<UserAlertVO> getAlertList();
}

package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StoryLikeVO;
import com.project.workspace.domain.vo.StoryVO;
import com.project.workspace.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryLikeRepository extends JpaRepository<StoryLikeVO,Long> {
    StoryLikeVO findByUserVOAndStoryVO(UserVO userNum, StoryVO storyVO);
}

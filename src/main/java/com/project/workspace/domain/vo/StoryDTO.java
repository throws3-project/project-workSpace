package com.project.workspace.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
@AllArgsConstructor
public class StoryDTO {
    List<StoryVO> storyVO;
    List<UserVO> userVO;
    List<List<StoryTagVO>> storyTagVOs;
    List<Integer> storyLikeSize;
    List<Integer> storyReplySize;

    public StoryDTO() {;}
}

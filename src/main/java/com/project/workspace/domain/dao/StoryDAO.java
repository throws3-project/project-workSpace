package com.project.workspace.domain.dao;

import com.project.workspace.mapper.StoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StoryDAO {
    private final StoryMapper storyMapper;
    public void insertStory(Long userNum, String storyPart, String storyTitle, String storyContent, String storyImgName, String storyImgUuid , String storyImgPath){storyMapper.insertStory(userNum, storyPart, storyTitle, storyContent, storyImgName, storyImgUuid, storyImgPath);}
    public void insertSeries(Long storyNum, Long userNum, String seriesName){storyMapper.insertSeries(storyNum, userNum, seriesName);}
    public void insertStoryReply(Long storyNum,String storyReply, Long userNum){storyMapper.insertStoryReply(storyNum, storyReply, userNum);}
    public void insertStoryTag(Long storyNum, String tagName){storyMapper.insertStoryTag(storyNum, tagName);}
    public void insertLikeStory(Long storyNum, Long userNum){storyMapper.insertLikeStory(storyNum, userNum);}

}

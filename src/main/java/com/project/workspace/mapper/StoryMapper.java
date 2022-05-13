package com.project.workspace.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoryMapper {
    public void insertStory(Long userNum, String storyPart, String storyTitle, String storyContent, String storyImgName, String storyImgUuid , String storyImgPath);
    public void insertSeries(Long storyNum, Long userNum, String seriesName);
    public void insertStoryReply(Long storyNum,String storyReply, Long userNum);
    public void insertStoryTag(Long storyNum, String tagName);
    public void insertLikeStory(Long storyNum, Long userNum);
}

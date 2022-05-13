package com.project.workspace.service;

import com.project.workspace.domain.dao.StoryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryDAO storyDAO;

    @Override
    public void insertStory(Long userNum, String storyPart, String storyTitle, String storyContent, String storyImgName, String storyImgUuid, String storyImgPath) {
        storyDAO.insertStory(userNum, storyPart, storyTitle, storyContent, storyImgName, storyImgUuid, storyImgPath);
    }

    @Override
    public void insertSeries(Long storyNum, Long userNum, String seriesName) {
        storyDAO.insertSeries(storyNum, userNum, seriesName);
    }

    @Override
    public void insertStoryReply(Long storyNum, String storyReply, Long userNum) {
        storyDAO.insertStoryReply(storyNum, storyReply, userNum);
    }

    @Override
    public void insertStoryTag(Long storyNum, String tagName) {
        storyDAO.insertStoryTag(storyNum, tagName);
    }

    @Override
    public void insertLikeStory(Long storyNum, Long userNum) {
        storyDAO.insertLikeStory(storyNum, userNum);
    }
}

package com.project.workspace.controller;

import com.project.workspace.domain.repository.StoryReplyRepository;
import com.project.workspace.domain.repository.StoryRepository;
import com.project.workspace.domain.repository.StorySeriesRepository;
import com.project.workspace.domain.vo.StoryVO;
import com.project.workspace.service.StoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/story/*")
public class StoryController {
    private final StoryService storyService;
    private final StoryRepository storyRepository;
    private final StorySeriesRepository storySeriesRepository;

    @GetMapping("/storyDetail")
    public void storyDetail(){

    }
    @GetMapping("/storyList")
    public void storyList(){
        List<StoryVO> storyVO = storyRepository.findAll();

        log.info("-------------------------------");
        log.info(storyVO.toString());
        log.info("-------------------------------");
    }
    @GetMapping("/storyModify")
    public void storyModify(){

    }
    @GetMapping("/storyRegister")
    public void storyRegister(){

    }


}

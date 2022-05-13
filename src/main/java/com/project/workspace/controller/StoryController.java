package com.project.workspace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/story/*")
public class StoryController {
    @GetMapping("/storyDetail")
    public void storyDetail(){

    }
    @GetMapping("/storyList")
    public void storyList(){

    }
    @GetMapping("/storyModify")
    public void storyModify(){

    }
    @GetMapping("/storyRegister")
    public void storyRegister(){

    }


}

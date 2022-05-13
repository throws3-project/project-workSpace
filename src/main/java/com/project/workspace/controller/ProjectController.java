package com.project.workspace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/project/*")
public class ProjectController {
    @GetMapping("/projectDetail")
    public void projectDetail(){

    }

    @GetMapping("/projectList")
    public void projectList(){

    }

    @GetMapping("/projectRegister")
    public void projectRegister(){

    }
}

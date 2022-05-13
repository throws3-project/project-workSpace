package com.project.workspace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notice/*")
public class NoticeController {

    @GetMapping("/faq")
    public void faq(){

    }

    @GetMapping("/noticeList")
    public void noticeList(){

    }

    @GetMapping("/noticeDetail")
    public void noticeDetail(){

    }

    @GetMapping("/noticeRegister")
    public void noticeRegister(){

    }

    @GetMapping("/noticeUpdate")
    public void noticeUpdate(){

    }
}

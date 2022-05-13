package com.project.workspace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    @GetMapping("/admin")
    public void admin(){

    }
    @GetMapping("/index")
    public void index(){

    }

    @GetMapping("/userDetail")
    public void userDetail(){

    }
    @GetMapping("/userList")
    public void userList(){

    }
    @GetMapping("/joinForm")
    public void joinForm(){

    }
    @GetMapping("/joinPlus")
    public void joinPlus(){

    }
    @GetMapping("/joinSuccess")
    public void joinSuccess(){

    }


}

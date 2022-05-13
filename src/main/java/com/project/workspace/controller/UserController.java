package com.project.workspace.controller;


import com.project.workspace.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {

    private final UserService userService;

    @GetMapping("/joinForm")
    public void joinForm(){

    }
    @GetMapping("/joinPlus")
    public void joinPlus(){

    }
    @GetMapping("/joinSuccess")
    public void joinSuccess(){

    }
    @GetMapping("/payment")
    public void payment(){

    }

}

















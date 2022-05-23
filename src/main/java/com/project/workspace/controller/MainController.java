package com.project.workspace.controller;

import com.project.workspace.domain.repository.UserRepository;
import com.project.workspace.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final UserRepository userRepository;

    @GetMapping("/admin")
    public void admin(){

    }
    @GetMapping("/index")
    public void index(){

    }
    @GetMapping("/userDetail/{userNum}")
    public String userDetail(@PathVariable("userNum") Long userNum, Model model){
        UserVO userVO = userRepository.getById(userNum);
        log.info(userVO.toString());
        model.addAttribute("user",userVO);
        return "main/userDetail";
    }
    @GetMapping("/userList")
    public void userList(){

    }
    @GetMapping("/privacyTerm")
    public void privacyTerm(){

    }
    @GetMapping("/refundTerm")
    public void refundTerm(){

    }
    @GetMapping("/serviceTerm")
    public void serviceTerm(){

    }
    @GetMapping("/tradeTerm")
    public void tradeTerm(){

    }
}

package com.project.workspace.controller;

import com.project.workspace.domain.repository.LoungeLikeRepository;
import com.project.workspace.domain.repository.LoungeReplyRepository;
import com.project.workspace.domain.repository.LoungeRepository;
import com.project.workspace.domain.vo.LoungeLikeVO;
import com.project.workspace.domain.vo.LoungeReplyVO;
import com.project.workspace.domain.vo.LoungeVO;
import com.project.workspace.domain.vo.UserVO;
import com.project.workspace.service.LoungeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoungeController {

    private final LoungeService loungeService;
    private final LoungeRepository loungeRepository;
    private final LoungeReplyRepository loungeReplyRepository;
    private final LoungeLikeRepository loungeLikeRepository;

    @GetMapping("/lounge")
    public String lounge(Model model){
        List<LoungeVO> loungeVO = loungeRepository.findAll();
        List<UserVO> loungeLikes = loungeService.selectLikes();

        log.info("-------------------------------");
        log.info(loungeVO.toString());
        log.info(String.valueOf(loungeLikes));
        log.info("-------------------------------");

        model.addAttribute("LoungeVO", loungeVO);
        return "/lounge/lounge";
    }

    @PostMapping("/lounge")
    public void insertLounge(LoungeReplyVO replyVO){

    }
}

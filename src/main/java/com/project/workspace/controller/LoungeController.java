package com.project.workspace.controller;

import com.project.workspace.domain.repository.LoungeLikeRepository;
import com.project.workspace.domain.repository.LoungeReplyRepository;
import com.project.workspace.domain.repository.LoungeRepository;
import com.project.workspace.domain.vo.LoungeReplyDTO;
import com.project.workspace.domain.vo.LoungeReplyVO;
import com.project.workspace.domain.vo.LoungeVO;
import com.project.workspace.domain.vo.UserVO;
import com.project.workspace.service.LoungeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoungeController {

    private final LoungeService loungeService;
    private final LoungeRepository loungeRepository;
    private final LoungeReplyRepository loungeReplyRepository;
    private final LoungeLikeRepository loungeLikeRepository;

    @GetMapping("/lounge")
    public String lounge(Model model) {
        List<LoungeVO> loungeVOs = loungeRepository.findAll();

        List<String> loungeUserNickNames = loungeVOs.stream()
                .map(loungeVO -> loungeVO.getUserVO().getUserNickname())
                .collect(Collectors.toList());

        List<String> userLikeNickNames = loungeVOs.stream()
                .sorted(comparing(this::getLikeSize).reversed())
                .filter(loungeVO -> loungeVO.getLikes().size() > 0)
                .limit(3)
                .map(loungeVO -> loungeVO.getUserVO().getUserNickname())
                .collect(Collectors.toList());

        List<String> userReplyNickNames = loungeVOs.stream()
                .sorted(comparing(this::getReplySize).reversed())
                .filter(loungeVO -> loungeVO.getReplies().size() > 0)
                .limit(3)
                .map(loungeVO -> loungeVO.getUserVO().getUserNickname())
                .collect(Collectors.toList());

        List<Integer> loungeLikesNum = loungeVOs.stream().map(loungeVO -> loungeVO.getLikes().size())
                .collect(Collectors.toList());

        List<Integer> loungeRepliesNum = loungeVOs.stream().map(loungeVO -> loungeVO.getReplies().size())
                .collect(Collectors.toList());

        Collections.reverse(loungeVOs);
        Collections.reverse(loungeUserNickNames);
        Collections.reverse(loungeLikesNum);
        Collections.reverse(loungeRepliesNum);

        log.info("-------------------------------");
        log.info(loungeVOs.toString());
        log.info(userLikeNickNames.toString());
        log.info(userReplyNickNames.toString());
        log.info(loungeLikesNum.toString());
        log.info(loungeRepliesNum.toString());
        log.info(loungeUserNickNames.toString());
        log.info("-------------------------------");


        model.addAttribute("loungeVOs", loungeVOs);
        model.addAttribute("loungeLikesNum", loungeLikesNum);
        model.addAttribute("loungeRepliesNum", loungeRepliesNum);
        model.addAttribute("loungeUserNickNames", loungeUserNickNames);
        model.addAttribute("userLikeNickNames", userLikeNickNames);
        model.addAttribute("userReplyNickNames", userReplyNickNames);
        return "lounge/lounge";
    }

    private int getLikeSize(LoungeVO loungeVO) {
        return loungeVO.getLikes().size();
    }
    private int getReplySize(LoungeVO loungeVO) {
        return loungeVO.getReplies().size();
    }

    // 댓글 보기
    @ResponseBody
    @GetMapping("/lounge/reply/{loungeNum}")
    public LoungeReplyDTO likeAndReply(@PathVariable("loungeNum") Long loungeNum) {
        LoungeVO loungeVO = loungeRepository.findById(loungeNum).get();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<LoungeReplyVO> replies = loungeVO.getReplies();
        List<String> userNickNames = replies.stream().map(UserVO -> UserVO.getUserVO().getUserNickname()).collect(Collectors.toList());
        log.info(replies.toString());
        log.info(userNickNames.toString());
        //service 집에서 하기

        return new LoungeReplyDTO(userNickNames,replies);
    }

    // 라운지 글작성
    @ResponseBody
    @GetMapping("/lounge/{loungeContent}/{userNum}")
    public String insertLounge(@PathVariable("loungeContent") String loungeContent, @PathVariable("userNum") UserVO userNum){
        loungeRepository.save(LoungeVO.builder().userVO(userNum).loungeContent(loungeContent).build());
        return "success";
    }

    // 댓글 작성
    @ResponseBody
    @GetMapping("/lounge/loungeInsert/{replyContent}/{userNum}/{loungeNum}")
    public String insertReply(@PathVariable("replyContent") String replyContent, @PathVariable("userNum") UserVO userNum, @PathVariable("loungeNum") LoungeVO loungeNum){
        loungeReplyRepository.save(LoungeReplyVO.builder().loungeReplyContent(replyContent).loungeVO(loungeNum).userVO(userNum).build());
        return "success";
    }

    //라운지 삭제
    @ResponseBody
    @GetMapping("/lounge/loungeDelete/{loungeNum}")
    public String deleteLounge(@PathVariable("loungeNum") Long loungeNum){
        loungeRepository.deleteById(loungeNum);
        return "success";
    }

    //라운지 수정
    @ResponseBody
    @GetMapping("/lounge/loungeUpdate/{loungeNum}/{loungeContent}")
    public String updateLounge(@PathVariable("loungeNum") Long loungeNum, @PathVariable("loungeContent") String loungeContent){
        UserVO userVO = loungeRepository.findById(loungeNum).get().getUserVO();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        LoungeVO loungeVO= loungeRepository.save(LoungeVO.builder().loungeContent(loungeContent).loungeDate(sdf.format(date)).loungeNum(loungeNum).userVO(userVO).build());
        return "success";
    }
}

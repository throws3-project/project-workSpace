package com.project.workspace.controller;

import com.project.workspace.domain.repository.UserInterestRepository;
import com.project.workspace.domain.repository.UserPortfolioRepository;
import com.project.workspace.domain.repository.UserRepository;
import com.project.workspace.domain.repository.UserTagRepository;
import com.project.workspace.domain.vo.*;
import com.project.workspace.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor

public class MyPageController {

    private final UserRepository userRepository;
    private final UserPortfolioRepository userPortfolioRepository;
    private final UserTagRepository userTagRepository;
    private final UserInterestRepository userInterestRepository;
    private final UserService userService;


    @GetMapping("/myPage")
    public String myPage(Long userNum,Model model){

        UserVO userVO = userRepository.findById(userNum).get();
        List<UserPortfolioVO> userPortfolioVO = userPortfolioRepository.findByUserVO(userVO);
        List<UserTagVO> userTagVO = userTagRepository.findByUserVO(userVO);
        List<UserInterestVO> userInterestVO = userInterestRepository.findByUserVO(userVO);
        List<String> interests = new ArrayList<>();
        for (UserInterestVO a : userInterestVO){
            interests.add(a.getInterest());
        }
        model.addAttribute("userVO", userVO);
        model.addAttribute("userPortfolioVO", userPortfolioVO);
        model.addAttribute("userTagVO", userTagVO);
        model.addAttribute("interests", interests);

        log.info("------------------------------------");
        log.info(userVO.toString());
        log.info("------------------------------------");

        return "/myPage/myPage";
    }

//    @PostMapping("/myPage")
//    public String myPage(UserVO userVO, Model model){
//        log.info("------------------------------------");
//        log.info(userVO.toString());
//        log.info("------------------------------------");
//
//        return "/myPage/myPage";
//    }

//    @PostMapping("/mypage")
//    public String userEdit(Long userNum) {
//        UserVO userVO = userRepository.findById(userNum).get();
////        List<UserPortfolioVO> userPortfolioVO = userPortfolioRepository.findByUserVO(userVO);
////        List<UserTagVO> userTagVO = userTagRepository.findByUserVO(userVO);
////        List<UserInterestVO> userInterestVO = userInterestRepository.findByUserVO(userVO);
////        List<String> interests = new ArrayList<>();
////        for (UserInterestVO a : userInterestVO){
////            interests.add(a.getInterest());
////        }
////        model.addAttribute("userVO", userVO);
////        model.addAttribute("userPortfolioVO", userPortfolioVO);
////        model.addAttribute("userTagVO", userTagVO);
////        model.addAttribute("interests", interests);
//
//
////        userRepository.(userVO.getUsername(), form.getName(), form.getEmail());
////        userVO.save(userVO.getUserNickName(),userVO.getUserPhone(),userVO.getUserMainSkill(),userVO.getUserMainDetail(),userVO.getUserMainLevel(),
////        userVO.getUserSubSkill(),userVO.getUserSubDetail(),userVO.getUserSubLevel(),userVO.getUserOnOff(),userVO.getUserTime(),userVO.getUserContent(),
////        userVO.getUserPrice(),userVO.getUserImgName(),userVO.getUserImgPath(),userVO.getUserImgUuid());
////        currentMember.setUsername(form.getName());
////        currentMember.setEmail(form.getEmail());
//
//        userVO.setUserNickName(userVO.getUserNickName()); //닉네임
//        userVO.setUserPhone(userVO.getUserPhone()); //폰
//        userVO.setUserMainSkill(userVO.getUserMainSkill()); //메인스킬
//        userVO.setUserMainDetail(userVO.getUserMainDetail()); //메인스킬상세
//        userVO.setUserMainLevel(userVO.getUserMainLevel()); //메인스킬레벨
//        userVO.setUserSubSkill(userVO.getUserSubSkill());  //세부스킬
//        userVO.setUserSubDetail(userVO.getUserSubDetail()); //세부상세
//        userVO.setUserSubLevel(userVO.getUserSubLevel()); //세부스킬레벨
//        userVO.setUserPrice(userVO.getUserPrice()); //대화가격
//        userVO.setUserOnOff(userVO.getUserOnOff()); //오프라인온라인
//        userVO.setUserTime(userVO.getUserTime()); //시간
//        userVO.setUserContent(userVO.getUserContent()); //소개
//        userVO.setUserImgName(userVO.getUserImgName());
//        userVO.setUserImgPath(userVO.getUserImgPath());
//        userVO.setUserImgUuid(userVO.getUserImgUuid());
//
//        return "/myPage/myPage";
//    }

//    @PostMapping("/modify")
//    public RedirectView modify(UserVO userVO, Criteria criteria, RedirectAttributes rttr){
//        String result = null;
//
////        Redirect로 전송 시
////        addAttribute()를 사용하면 컨트롤러에 파라미터가 전달되고 그걸 통해서 화면으로 간다.
////        addFlashAttribute()를 사용하면 컨트롤러에 전달되지 않고 바로 화면으로 간다.
//        rttr.addAttribute("result", userService.modify(userVO) ? "success" : "failure");
//        rttr.addAttribute("pageNum", criteria.getPageNum());
//        rttr.addAttribute("amount", criteria.getAmount());
//        rttr.addAttribute("type", criteria.getType());
//        rttr.addAttribute("keyword", criteria.getKeyword());
//        return new RedirectView("list");
//    }

//    @PostMapping("/modify")
//    public String userEdit(UserVO.UserForm form, BindingResult result, @AuthenticationPrincipal User currentMember) {
//        if(result.hasErrors()) {
//            return "redirect:/modify";
//        }
//
//        userService.updateInfo(currentMember.getUsername(), form.getName(), form.getEmail());
//        currentMember.setUsername(form.getName());
//        currentMember.setEmail(form.getEmail());
//
//        return "redirect:/modify";
//    }

    @PostMapping("/modify")
    public String userModify(UserVO userVO){

//        UserVO userVos = userService.getInfo(1L);
//        userVO = userService.getInfo(1L);
//        userVO.setUserId(userVO.getUserId());
        userVO.setUserNickName(userVO.getUserNickName()); //닉네임
        userVO.setUserPhone(userVO.getUserPhone()); //폰
        userVO.setUserMainSkill(userVO.getUserMainSkill()); //메인스킬
        userVO.setUserMainDetail(userVO.getUserMainDetail()); //메인스킬상세
        userVO.setUserMainLevel(userVO.getUserMainLevel()); //메인스킬레벨
        userVO.setUserSubSkill(userVO.getUserSubSkill());  //세부스킬
        userVO.setUserSubDetail(userVO.getUserSubDetail()); //세부상세
        userVO.setUserSubLevel(userVO.getUserSubLevel()); //세부스킬레벨
        userVO.setUserPrice(userVO.getUserPrice()); //대화가격
        userVO.setUserOnOff(userVO.getUserOnOff()); //오프라인온라인
        userVO.setUserTime(userVO.getUserTime()); //시간
        userVO.setUserContent(userVO.getUserContent()); //소개
        userVO.setUserImgName(userVO.getUserImgName());
        userVO.setUserImgPath(userVO.getUserImgPath());
        userVO.setUserImgUuid(userVO.getUserImgUuid());

//        model.addAttribute("userVO", userVos);

            userRepository.save(userVO);
            System.out.println(userRepository.save(userVO).toString());

        return "/myPage/myPage";

        }
//    @RequestMapping(value = "/modify", method = RequestMethod.POST)
//    public void userUpdate(UserVO userVO, Model model) {
//        System.out.println(userVO.getUserName());
//        System.out.println(userVO.getUserId());
//    }


}

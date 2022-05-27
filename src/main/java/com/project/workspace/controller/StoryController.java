package com.project.workspace.controller;

import com.project.workspace.domain.repository.*;
import com.project.workspace.domain.vo.*;
import com.project.workspace.service.StoryService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/story/*")
public class StoryController {
    private final StoryService storyService;
    private final StoryRepository storyRepository;
    private final StoryReplyRepository storyReplyRepository;
    private final StoryTagRepository storyTagRepository;
    private final JPAQueryFactory queryFactory;
    private final StoryQueryRepository storyQueryRepository;
    private final StoryLikeRepository storyLikeRepository;
    private final UserRepository userRepository;

    @GetMapping("/storyDetail")
    public void storyDetail(@RequestParam("storyNum") Long storyNum, Model model){
        StoryVO storyVO = storyRepository.findById(storyNum).get();
        storyVO.setStoryReadCount(storyVO.getStoryReadCount() + 1);
        storyRepository.save(storyVO);
        // 이사람의 모든 스토리를 들고옴
        List<StoryVO> myList = storyRepository.findAllByUserVOAndStoryNumNot(storyVO.getUserVO(), storyNum);
        List<StoryVO> otherStoryList = storyRepository.findAllByStoryNumNot(storyNum);
        List<String> tags = storyVO.getTags().stream().map(StoryTagVO::getTagName).collect(Collectors.toList());
        Random rd = new Random();
        Collections.reverse(myList);
        List<StoryVO> recommendList = new ArrayList<>();

        if(otherStoryList.size() > 5) {
            for (int i = 0; i<5; i++){
                recommendList.add(otherStoryList.get(rd.nextInt(otherStoryList.size())));
                for(int j=0; j<i; j++){
                    if(recommendList.get(i) == recommendList.get(j)){
                        recommendList.remove(i);
                        i--;
                    }
                }
            }
        }else{
            recommendList = otherStoryList;
        }
        log.info(String.valueOf(recommendList.size()));
        model.addAttribute("storyVO", storyVO);
        model.addAttribute("myList", myList);
        model.addAttribute("tags", tags);
        model.addAttribute("recommendList", recommendList);
    }

    @GetMapping("/storyList")
    public void storyList(Model model){
        Random rd = new Random();
        List<StoryVO> topStoryList = storyRepository.findTop4ByOrderByStoryReadCountDesc();
        List<StoryVO> allStoryList = storyRepository.findAll();
        List<Long> userNums = allStoryList.stream().map(storyVO -> storyVO.getUserVO().getUserNum()).distinct().collect(Collectors.toList());
        List<Long> users = new ArrayList<>();
        List<List<StoryVO>> randomList = new ArrayList<>();
        if(userNums.size() > 2) {
            for (int i = 0; i<2; i++){
                users.add(userNums.get(rd.nextInt(userNums.size())));
                for(int j=0; j<i; j++){
                    if(users.get(i) == users.get(j)){
                        users.remove(i);
                        i--;
                    }
                }
            }
        }else{
            users = userNums;
        }

        for (int i = 0; i<users.size(); i++){
            randomList.add(storyRepository.findTop10ByUserVO_UserNum(users.get(i)));
        }

        model.addAttribute("topStoryList", topStoryList);
        model.addAttribute("allStoryList", allStoryList);
        model.addAttribute("randomList", randomList);
    }

    @ResponseBody
    @GetMapping("/selectList/{storyPart}")
    public StoryDTO selectStory(@PathVariable("storyPart") String storyPart){
        List<StoryVO> storyVO = storyQueryRepository.search(storyPart);
        List<UserVO> userVO = storyVO.stream().map(StoryVO::getUserVO).collect(Collectors.toList());
        List<List<StoryTagVO>> storyTagVOs = storyVO.stream().map(StoryVO::getTags).collect(Collectors.toList());
        List<Integer> storyLikeSize = storyVO.stream().map(storyVO1 -> storyVO1.getLikes().size()).collect(Collectors.toList());
        List<Integer> storyReplySize = storyVO.stream().map(storyVO1 -> storyVO1.getReplies().size()).collect(Collectors.toList());
        return new StoryDTO(storyVO, userVO, storyTagVOs, storyLikeSize, storyReplySize);
    }


    @GetMapping("/storyModify")
    public void storyModify(Long storyNum, Model model){
        StoryVO storyVO = storyRepository.findById(storyNum).get();

        model.addAttribute("storyVO", storyVO);
    }

    @GetMapping("/storyRegister")
    public void storyRegister(){

    }

    @PostMapping("/storyRegister")
    @Transactional(rollbackFor = {Exception.class})
    public RedirectView storyRegister(HttpServletRequest req, StoryVO storyVO, StoryTagVO storyTagVO, RedirectAttributes rttr){
        HttpSession session = req.getSession();
        UserVO userVO = userRepository.getById((Long)session.getAttribute("userNum"));
        storyVO.setUserVO(userVO);
        Long storyNum = storyRepository.save(storyVO).getStoryNum();
        if(storyTagVO.getTagName() != null){
            String[] tagName = storyTagVO.getTagName().split(",");
            for (int i = 0; i<tagName.length; i++) {
                StoryTagVO storyTagVOS = new StoryTagVO();
                storyTagVOS.setStoryVO(storyVO);
                storyTagVOS.setTagName(tagName[i]);
                storyTagRepository.save(storyTagVOS);
            }
        }
        rttr.addAttribute("storyNum", storyNum);
        return new RedirectView("storyDetail");
    }

    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public StoryVO uploadAjaxPost(MultipartFile uploadFile) {
        String uploadFolder = "C:/upload";
        StoryVO storyVO = new StoryVO();

        UUID uuid = UUID.randomUUID();
        String uploadFileName = null;

        String uploadFolderPath = getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        uploadFileName = uploadFile.getOriginalFilename();

        storyVO.setStoryImgName(uploadFileName);
        storyVO.setStoryImgUuid(uuid.toString());
        storyVO.setStoryImgPath(uploadFolderPath);

        //저장할 경로와 파일의 이름을 File객체에 담는다.
        File saveFile = new File(uploadPath, uuid.toString() + "_" + uploadFileName);

        try {
            //설정한 경로에 해당 파일을 업로드한다.
            uploadFile.transferTo(saveFile);

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return storyVO;
    }

    // 댓글 리스트
    @ResponseBody
    @GetMapping("/getList/{storyNum}")
    public StoryReplyDTO getList(@PathVariable("storyNum") Long storyNum){
        StoryVO storyVO = storyRepository.findById(storyNum).get();
        List<StoryReplyVO> replies = storyVO.getReplies();
        List<String> userNickNames = replies.stream().map(UserVO -> UserVO.getUserVO().getUserNickName()).collect(Collectors.toList());
        Collections.reverse(userNickNames);
        Collections.reverse(replies);

        return new StoryReplyDTO(userNickNames, replies);
    }

    // 스토리 삭제
    @ResponseBody
    @GetMapping("/deleteStory/{storyNum}")
    public void deleteStory(@PathVariable("storyNum") Long storyNum){
        storyRepository.deleteById(storyNum);
    }

    @ResponseBody
    @GetMapping("/storyInsert/{storyReply}/{userNum}/{storyNum}")
    public String insertReply(@PathVariable("storyReply") String storyReply, @PathVariable("userNum") UserVO userNum, @PathVariable("storyNum") StoryVO storyNum){
        storyReplyRepository.save(StoryReplyVO.builder().storyVO(storyNum).userVO(userNum).storyReply(storyReply).build());
        return "success";
    }

    //댓글 작성후 댓글개수 초기화
    @ResponseBody
    @GetMapping("/resetReply/{storyNum}")
    public int resetReply(@PathVariable("storyNum") Long storyNum){
        int size = storyRepository.findById(storyNum).get().getReplies().size();
        return size;
    }

    // 좋아요
    @ResponseBody
    @GetMapping("/likeStory/{userNum}/{storyNum}")
    public String likeStory(@PathVariable("userNum") UserVO userNum, @PathVariable("storyNum") StoryVO storyNum){
        StoryLikeVO byUserVOAndStoryVO = storyLikeRepository.findByUserVOAndStoryVO(userNum, storyNum);
        if(byUserVOAndStoryVO != null){
            return "fail";
        }
        storyLikeRepository.save(StoryLikeVO.builder().userVO(userNum).storyVO(storyNum).build());
        return "success";
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }

    @GetMapping("/displayTh")
    @ResponseBody
    public byte[] getFile(String storyImgPath, String storyImgUuid, String storyImgName) throws IOException {
        String fileName = storyImgPath + "/" + storyImgUuid + "_" + storyImgName;
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }

    private String getPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }


}
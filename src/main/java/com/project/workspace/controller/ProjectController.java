package com.project.workspace.controller;

import com.project.workspace.domain.vo.ProjectVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/project/*")
public class ProjectController {
    @GetMapping("/projectDetail")
    public void projectDetail() {
        ;
    }

    @GetMapping("/projectList")
    public void projectList() {
        ;
    }

    @GetMapping("/projectRegister")
    public void projectRegister() {
        ;
    }

    @PostMapping("/projectRegister")
    public String projectRegister(ProjectVO projectVO) {
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        log.info(projectVO.toString());
        log.info("온오프" + projectVO.getProjectOnOff());
        log.info("제목" + projectVO.getProjectName());
        log.info("파트" + projectVO.getProjectPart());
        log.info("플랫폼" + projectVO.getProjectPlatform());
        log.info("내용" + projectVO.getProjectContent());
        log.info("파일이름" + projectVO.getProjectImg());
        log.info("파일경로" + projectVO.getProjectImgPath());
        log.info("uuid" + projectVO.getProjectImgUuid());
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return "/project/projectRegister";
    }


    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public ProjectVO uploadAjaxPost(MultipartFile uploadFile) {
        String uploadFolder = "C:/upload";
        ProjectVO projectVO = new ProjectVO();
//        UUID(Universally unique identifier) : 범용 고유 식별자
//        네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//        중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
//        UUID의 개수는 10의 38승입니다.

        UUID uuid = UUID.randomUUID();
        String uploadFileName = null;

        String uploadFolderPath = getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        log.info("-------------------------");
        log.info("Upload File Name : " + uploadFile.getOriginalFilename());
        log.info("Upload File Path : " + uploadFolderPath);
        log.info("Upload File Size : " + uploadFile.getSize());

        uploadFileName = uploadFile.getOriginalFilename();

        projectVO.setProjectImg(uploadFileName);
        projectVO.setProjectImgUuid(uuid.toString());
        projectVO.setProjectImgPath(uploadFolderPath);

        //저장할 경로와 파일의 이름을 File객체에 담는다.
        File saveFile = new File(uploadPath, uuid.toString()+"_"+uploadFileName);

        try {
            //설정한 경로에 해당 파일을 업로드한다.
            uploadFile.transferTo(saveFile);

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return projectVO;
    }


    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }

    private String getPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }

    private boolean checkImageType(File file) {
        try {
            //헤더에 담긴 파일의 ContentType을 가져온다.
            //startsWith()를 사용해서 image라는 문자열로 시작한다면 true리턴, 아니면 false리턴
            return Files.probeContentType(file.toPath()).startsWith("image");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}

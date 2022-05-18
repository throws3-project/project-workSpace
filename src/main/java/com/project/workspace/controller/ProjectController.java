package com.project.workspace.controller;

import com.project.workspace.domain.repository.*;
import com.project.workspace.domain.vo.*;
import com.project.workspace.service.ProjectService;
import com.project.workspace.service.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/project/*")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectService projectService;
    private final ProjectPersonRepository projectPersonRepository;
    private final ProjectSkillRepository projectSkillRepository;
    private final ProjectReferenceRepository projectReferenceRepository;
    private final StudyRepository studyRepository;
    private final StudyKeywordRepository studyKeywordRepository;


    @GetMapping("/projectDetail")
    public void projectDetail() {
        ;
    }

    @GetMapping("/projectList")
    public void projectList(Model model) {
        List<ProjectVO> projectTop4 = projectRepository.findTop4ByOrderByProjectNumDesc();
        List<ProjectVO> projectList = projectRepository.findAllByOrderByProjectNumDesc();


//        Stream.of(projectList).map(project->project.toString()).forEach(log::info);
        model.addAttribute("projectTop4",projectTop4);
        model.addAttribute("projectList",projectList);
    }

    @PostMapping("/projectFilter")
    @ResponseBody
    public List<ProjectVO> projectFilter(ProjectFilter projectFilter) {

        List<ProjectVO> projectList = projectService.getProjectList(projectFilter);

        projectList.stream().map(projectVO -> toString()).forEach(log::info);
        return projectList;
    }

    @GetMapping("/projectRegister")
    public void projectRegister() {
        ;
    }

    @PostMapping("/projectRegister")
    @Transactional
    public String projectRegister(ProjectVO projectVO, StudyVO studyVO,HttpServletRequest request) {
        String type = request.getParameter("type");
        log.info(type);
        if(type.equals("project")) {

            String[] count = request.getParameterValues("projectCount");
            String[] main = request.getParameterValues("projectMainSkill");
            String[] sub = request.getParameterValues("projectSubSkill");

            String[] urls = request.getParameterValues("projectUrl");

            String[] skill = request.getParameterValues("projectSkill");
            ProjectPersonMaker projectPersonMaker = new ProjectPersonMaker(count, main, sub);

            projectVO.setProjectTotal(projectPersonMaker.getProjectMaxCount());
            ProjectVO saveProjectVO = projectRepository.save(projectVO);

            Stream.of(skill).forEach(it -> this.saveProjectSkill(it, saveProjectVO));
            IntStream.range(0, count.length).forEach(index -> {
                ProjectPersonVO projectPersonVO = projectPersonMaker.getProjectPersonVO(index);
                projectPersonVO.setProjectVO(saveProjectVO);
                projectPersonRepository.save(projectPersonVO);
            });

            Stream.of(urls).forEach(url -> this.saveProjectUrl(url, saveProjectVO));
        }else if(type.equals("study")){
            String[] keywords = request.getParameterValues("studyKeyword");

            StudyVO saveStudyVO = studyRepository.save(studyVO);
            Stream.of(keywords).forEach(keyword -> this.saveStudyKeyword(keyword,saveStudyVO));
        }
        return "/project/projectList";
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
        File saveFile = new File(uploadPath, uuid.toString() + "_" + uploadFileName);

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
    public byte[] getFile(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }

    private String getPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }

    private void saveProjectSkill(String skill, ProjectVO projectVO) {
        ProjectSkillVO projectSkill = new ProjectSkillVO();
        projectSkill.setProjectSkill(skill);
        projectSkill.setProjectVO(projectVO);
        projectSkillRepository.save(projectSkill);
    }

    private void saveProjectUrl(String url, ProjectVO projectVO) {
        ProjectReferenceVO projectReferenceVO = new ProjectReferenceVO();
        projectReferenceVO.setProjectUrl(url);
        projectReferenceVO.setProjectVO(projectVO);
        projectReferenceRepository.save(projectReferenceVO);
    }

    private void saveStudyKeyword(String keyword, StudyVO studyVO) {
        StudyKeywordVO studyKeywordVO = new StudyKeywordVO();
        studyKeywordVO.setStudyKeyword(keyword);
        studyKeywordVO.setStudyVO(studyVO);
        studyKeywordRepository.save(studyKeywordVO);
    }
}

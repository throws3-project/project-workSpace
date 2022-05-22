package com.project.workspace.controller;

import com.project.workspace.domain.repository.*;
import com.project.workspace.domain.vo.*;
import com.project.workspace.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
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


    @GetMapping("/projectDetail/project/{projectNum}")
    public String projectDetail(@PathVariable("projectNum") Long projectNum, Model model) {
        ProjectVO project = projectRepository.getById(projectNum);
        UserVO user = project.getUserVO();
        List<ProjectSkillVO> projectSkillList = projectSkillRepository.getAllByProjectVO(project);
        List<ProjectReferenceVO> projectReferenceList = projectReferenceRepository.getAllByProjectVO(project);
        List<ProjectPersonVO> projectPersonList = projectPersonRepository.getAllByProjectVO(project);


        model.addAttribute("project",project);
        model.addAttribute("user",user);
        model.addAttribute("projectSkillList",projectSkillList);
        model.addAttribute("projectReferenceList",projectReferenceList);
        model.addAttribute("projectPersonList",projectPersonList);

        return "project/projectDetail";
    }

    @GetMapping("/projectDetail/study/{studyNum}")
    public String studyDetail(@PathVariable("studyNum") Long studyNum) {

        return "project/projectDetail";
    }

    @GetMapping("/projectList")
    public void projectList(Model model) {
        List<ProjectVO> newProjectList = projectRepository.findTop4ByOrderByProjectNumDesc();
        List<ProjectVO> projectTop3 = projectRepository.findTop3ByOrderByProjectReadCountDesc();
        List<ProjectVO> projectList = projectRepository.findAllByOrderByProjectNumDesc();


//        Stream.of(projectList).map(project->project.toString()).forEach(log::info);
        model.addAttribute("newProjectList", newProjectList);
        model.addAttribute("projectTop3", projectTop3);
        model.addAttribute("projectList", projectList);

    }

    @PostMapping("/projectFilter")
    @ResponseBody
    public List<ProjectVO> projectFilter(ProjectFilter projectFilter) {

        List<ProjectVO> projectList = projectService.getProjectList(projectFilter);


        return projectList;
    }

    @GetMapping("/projectRegister")
    public void projectRegister() {
        ;
    }

    @PostMapping("/projectRegister")
    @Transactional
    public RedirectView projectRegister(ProjectVO projectVO, StudyVO studyVO, HttpServletRequest request) {
        String type = request.getParameter("type");
        log.info(type);
        if (type.equals("project")) {

            String[] count = request.getParameterValues("projectCount");
            String[] main = request.getParameterValues("projectMainSkill");
            String[] sub = request.getParameterValues("projectSubSkill");

            String[] urls = request.getParameterValues("projectUrl");

            String[] skill = request.getParameterValues("projectSkill");
            ProjectPersonMaker projectPersonMaker = new ProjectPersonMaker(count, main, sub);

            projectVO.setProjectTotal(projectPersonMaker.getProjectMaxCount());
            ProjectVO saveProjectVO = projectRepository.save(defaultImg(projectVO));

            Stream.of(skill).forEach(it -> this.saveProjectSkill(it, saveProjectVO));
            IntStream.range(0, count.length).forEach(index -> {
                ProjectPersonVO projectPersonVO = projectPersonMaker.getProjectPersonVO(index);
                projectPersonVO.setProjectVO(saveProjectVO);
                projectPersonRepository.save(projectPersonVO);
            });

            Stream.of(urls).forEach(url -> this.saveProjectUrl(url, saveProjectVO));
        } else if (type.equals("study")) {
            String[] keywords = request.getParameterValues("studyKeyword");

            StudyVO saveStudyVO = studyRepository.save(studyVO);
            Stream.of(keywords).forEach(keyword -> this.saveStudyKeyword(keyword, saveStudyVO));
        }
        return new RedirectView("projectList");
    }


    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public ProjectVO uploadAjaxPost(MultipartFile uploadFile) {
        String uploadFolder = "C:/upload";
        ProjectVO projectVO = new ProjectVO();

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

        File saveFile = new File(uploadPath, uuid.toString() + "_" + uploadFileName);

        try {
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

    private ProjectVO defaultImg(ProjectVO projectVO) {
        Random r = new Random();
        if (projectVO.getProjectImgPath() == null) {
            int index = r.nextInt(7) + 1;
            projectVO.setProjectImg("thumb" + index + ".png");
        }
        return projectVO;

    }
}

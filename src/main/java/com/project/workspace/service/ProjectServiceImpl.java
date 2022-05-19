package com.project.workspace.service;

import com.project.workspace.domain.dao.ProjectDAO;
import com.project.workspace.domain.vo.ProjectFilter;
import com.project.workspace.domain.vo.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    private final ProjectDAO projectDAO;

    @Override
    public void insertProject(Long userNum, String projectName, String projectPart, String projectLocation, String projectOnOff, String projectPlatform, String projectContent, String projectImg, String projectImgUuid, String projectImgPath, Long projectTotal) {
        projectDAO.insertProject(userNum, projectName, projectPart, projectLocation, projectOnOff, projectPlatform, projectContent, projectImg, projectImgUuid, projectImgPath, projectTotal);
    }

    @Override
    public void insertProjectMember(Long projectNum, Long userNum, String projectPart, String projectMotive) {
        projectDAO.insertProjectMember(projectNum, userNum, projectPart, projectMotive);
    }

    @Override
    public void insertProjectPerson(Long projectNum, String projectMainSkill, String projectSubSkill, Long projectCount) {
        projectDAO.insertProjectPerson(projectNum, projectMainSkill, projectSubSkill, projectCount);
    }

    @Override
    public void insertProjectReference(Long projectNum, String projectUrl) {
        projectDAO.insertProjectReference(projectNum, projectUrl);
    }

    @Override
    public void insertProjectSkill(Long projectNum, String projectSkill) {
        projectDAO.insertProjectSkill(projectNum, projectSkill);
    }

    @Override
    public void insertLikeProject(Long projectNum, Long userNum) {
        projectDAO.insertLikeProject(projectNum, userNum);
    }

    @Override
    public List<ProjectVO> getProjectList(ProjectFilter projectFilter) {
        return projectDAO.getProjectList(projectFilter);
    }

//    @Transactional
//    @Override
//    public Long register(ProjectVO projectVO) {
//        projectDAO.insertSelectProjectNum(projectVO);
//        return projectVO.getProjectNum();
//    }
}

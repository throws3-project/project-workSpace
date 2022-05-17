package com.project.workspace.domain.dao;

import com.project.workspace.domain.vo.ProjectVO;
import com.project.workspace.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProjectDAO {
    @Autowired
    private final ProjectMapper projectMapper;

    public void insertProject(Long userNum, String projectName, String projectPart, String projectLocation, String projectOnOff,String projectPlatform,String projectContent, String projectImg, String projectImgUuid,String projectImgPath,Long projectTotal){projectMapper.insertProject(userNum, projectName, projectPart, projectLocation, projectOnOff, projectPlatform, projectContent, projectImg, projectImgUuid, projectImgPath, projectTotal);};
    public void insertProjectMember(Long projectNum, Long userNum, String projectPart, String projectMotive){projectMapper.insertProjectMember(projectNum, userNum, projectPart, projectMotive);};
    public void insertProjectPerson(Long projectNum, String projectMainSkill, String projectSubSkill, Long projectCount){projectMapper.insertProjectPerson(projectNum, projectMainSkill, projectSubSkill, projectCount);};
    public void insertProjectReference(Long projectNum, String projectUrl){projectMapper.insertProjectReference(projectNum, projectUrl);};
    public void insertProjectSkill(Long projectNum, String projectSkill){projectMapper.insertProjectSkill(projectNum, projectSkill);};
    public void insertLikeProject(Long projectNum, Long userNum){projectMapper.insertLikeProject(projectNum, userNum);};
//    public void insertSelectProjectNum(ProjectVO projectVO){projectMapper.insertSelectProjectNum(projectVO);}
}

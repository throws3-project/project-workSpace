package com.project.workspace.service;

import com.project.workspace.domain.vo.ProjectVO;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    public void insertProject(Long userNum, String projectName, String projectPart, String projectLocation, String projectOnOff,String projectPlatform,String projectContent, String projectImg, String projectImgUuid,String projectImgPath,Long projectTotal);
    public void insertProjectMember(Long projectNum, Long userNum, String projectPart, String projectMotive);
    public void insertProjectPerson(Long projectNum, String projectMainSkill, String projectSubSkill, Long projectCount);
    public void insertProjectReference(Long projectNum, String projectUrl);
    public void insertProjectSkill(Long projectNum, String projectSkill);
    public void insertLikeProject(Long projectNum, Long userNum);
//    public Long register(ProjectVO projectVO);
}

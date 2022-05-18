package com.project.workspace.mapper;

import com.project.workspace.domain.vo.ProjectFilter;
import com.project.workspace.domain.vo.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    public void insertProject(Long userNum, String projectName, String projectPart, String projectLocation, String projectOnOff,String projectPlatform,String projectContent, String projectImg, String projectImgUuid,String projectImgPath,Long projectTotal);
    public void insertProjectMember(Long projectNum, Long userNum, String projectPart, String projectMotive);
    public void insertProjectPerson(Long projectNum, String projectMainSkill, String projectSubSkill, Long projectCount);
    public void insertProjectReference(Long projectNum, String projectUrl);
    public void insertProjectSkill(Long projectNum, String projectSkill);
    public void insertLikeProject(Long projectNum, Long userNum);
    public List<ProjectVO> getProjectList(ProjectFilter projectFilter);
}

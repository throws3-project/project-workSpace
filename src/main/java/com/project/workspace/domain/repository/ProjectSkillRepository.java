package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectReferenceVO;
import com.project.workspace.domain.vo.ProjectSkillVO;
import com.project.workspace.domain.vo.ProjectVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectSkillRepository extends JpaRepository<ProjectSkillVO, Long> {
    public List<ProjectSkillVO> getAllByProjectVO(ProjectVO projectVO);
}

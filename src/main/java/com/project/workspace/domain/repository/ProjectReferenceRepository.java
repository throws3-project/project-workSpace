package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectReferenceVO;
import com.project.workspace.domain.vo.ProjectVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectReferenceRepository extends JpaRepository<ProjectReferenceVO,Long> {
    public List<ProjectReferenceVO> getAllByProjectVO(ProjectVO projectVO);
}

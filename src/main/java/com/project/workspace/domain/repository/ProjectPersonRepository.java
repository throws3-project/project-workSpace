package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectPersonVO;
import com.project.workspace.domain.vo.ProjectReferenceVO;
import com.project.workspace.domain.vo.ProjectVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectPersonRepository extends JpaRepository<ProjectPersonVO,Long> {
    public List<ProjectPersonVO> getAllByProjectVO(ProjectVO projectVO);
}

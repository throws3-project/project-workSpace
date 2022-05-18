package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<ProjectVO,Long> {
    public List<ProjectVO> findTop4ByOrderByProjectNumDesc();
    public List<ProjectVO> findAllByOrderByProjectNumDesc();
}

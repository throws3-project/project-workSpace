package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectVO,Long> {
}

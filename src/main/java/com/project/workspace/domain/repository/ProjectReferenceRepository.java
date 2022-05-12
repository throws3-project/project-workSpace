package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectReferenceVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectReferenceRepository extends JpaRepository<ProjectReferenceVO,Long> {
}

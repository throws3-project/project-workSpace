package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectLikeVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectLikeRepository extends JpaRepository<ProjectLikeVO, Long> {
}

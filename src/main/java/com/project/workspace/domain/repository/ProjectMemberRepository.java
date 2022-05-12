package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ProjectMemberVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMemberVO, Long> {
}

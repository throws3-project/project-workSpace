package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.UserInterestVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterestVO, Long> {
}

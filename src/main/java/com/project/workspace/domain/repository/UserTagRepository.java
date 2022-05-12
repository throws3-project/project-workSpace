package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.UserTagVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTagRepository extends JpaRepository<UserTagVO, Long> {
}

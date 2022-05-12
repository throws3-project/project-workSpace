package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StoryVO;
import com.project.workspace.domain.vo.UserAlertVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryVO, Long> {
}

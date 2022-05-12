package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StoryTagVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryTagRepository extends JpaRepository<StoryTagVO, Long> {
}

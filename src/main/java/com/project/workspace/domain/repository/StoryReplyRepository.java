package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StoryReplyVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryReplyRepository extends JpaRepository<StoryReplyVO, Long> {
}

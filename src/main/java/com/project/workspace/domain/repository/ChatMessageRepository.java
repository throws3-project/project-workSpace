package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.ChatMessageVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessageVO, Long> {
}

package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.LoungeReplyVO;
import com.project.workspace.domain.vo.LoungeVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoungeReplyRepository extends JpaRepository<LoungeReplyVO, Long> {
}

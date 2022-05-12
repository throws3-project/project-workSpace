package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.NoticeVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Long> {
}

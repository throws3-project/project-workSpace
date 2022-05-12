package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StudyMemberVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyMemberRepository extends JpaRepository<StudyMemberVO, Long> {
}

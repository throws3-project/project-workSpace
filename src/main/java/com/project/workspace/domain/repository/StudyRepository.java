package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StudyVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<StudyVO, Long> {
}

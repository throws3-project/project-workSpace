package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StudyKeywordVO;
import com.project.workspace.domain.vo.StudyVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyKeywordRepository extends JpaRepository<StudyKeywordVO, Long> {
    public List<StudyKeywordVO> getAllByStudyVO(StudyVO studyVO);
}

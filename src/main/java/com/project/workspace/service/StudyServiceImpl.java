package com.project.workspace.service;

import com.project.workspace.domain.dao.StudyDAO;
import com.project.workspace.domain.vo.StudyKeywordVO;
import com.project.workspace.domain.vo.StudyMemberVO;
import com.project.workspace.domain.vo.StudyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService{

    private final StudyDAO studyDAO;

    @Override
    public void insertStudy(Long userNum, String studyTitle, String studyPart, String studyLocation, String studyOnOff, String studyContent) {
        studyDAO.insertStudy(userNum, studyTitle, studyPart, studyLocation, studyOnOff, studyContent);
    }

    @Override
    public void insertKeyword(Long studyNum, String studyKeyword) {
        studyDAO.insertKeyword(studyNum, studyKeyword);
    }

    @Override
    public void insertMember(Long studyNum, Long userNum, String studyMotive) {
        studyDAO.insertMember(studyNum, userNum, studyMotive);
    }

    @Override
    public List<StudyVO> getStudyList() {
        return studyDAO.getStudyList();
    }

    @Override
    public List<StudyKeywordVO> getKeywordList() {
        return studyDAO.getKeywordList();
    }

    @Override
    public List<StudyMemberVO> getMemberList() {
        return studyDAO.getMemberList();
    }
}

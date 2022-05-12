package com.project.workspace.domain.dao;


import com.project.workspace.domain.vo.StudyKeywordVO;
import com.project.workspace.domain.vo.StudyMemberVO;
import com.project.workspace.domain.vo.StudyVO;
import com.project.workspace.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyDAO {
    private final StudyMapper studyMapper;

    public void insertStudy(Long userNum,String studyTitle, String studyPart, String studyLocation, String studyOnOff, String studyContent){studyMapper.insertStudy(userNum, studyTitle, studyPart, studyLocation, studyOnOff, studyContent);}
    public void insertKeyword(Long studyNum, String studyKeyword){studyMapper.insertKeyword(studyNum, studyKeyword);}
    public void insertMember(Long studyNum, Long userNum,String studyMotive){studyMapper.insertMember(studyNum, userNum, studyMotive);}
    public List<StudyVO> getStudyList(){return studyMapper.getStudyList();}
    public List<StudyKeywordVO> getKeywordList(){return studyMapper.getKeywordList();}
    public List<StudyMemberVO> getMemberList(){return studyMapper.getMemberList();}
}


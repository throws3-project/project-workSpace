package com.project.workspace.mapper;

import com.project.workspace.domain.vo.StudyKeywordVO;
import com.project.workspace.domain.vo.StudyMemberVO;
import com.project.workspace.domain.vo.StudyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapper {
    public void insertStudy(Long userNum,String studyTitle, String studyPart, String studyLocation, String studyOnOff, String studyContent);
    public void insertKeyword(Long studyNum, String studyKeyword);
    public void insertMember(Long studyNum, Long userNum,String studyMotive);
    public List<StudyVO> getStudyList();
    public List<StudyKeywordVO> getKeywordList();
    public List<StudyMemberVO> getMemberList();
}

package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_study")
@Getter
@ToString(exclude = {"userVO", "keywords", "members" })
@NoArgsConstructor
@DynamicInsert
public class StudyVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_num")
    private Long StudyNum;
    @Column(name = "study_title")
    private String studyTitle;
    @Column(name = "study_part")
    private String studyPart;
    @Column(name = "study_location")
    private String studyLocation;
    @Column(name = "study_on_off")
    private String studyOnOff;
    @Column(name = "study_max")
    private Long studyMax;
    @Column(name = "study_content")
    private String studyContent;
    @Column(name = "study_status")
    private String studyStatus;
    @Column(name = "study_read_count")
    private Long studyReadCount;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @OneToMany(mappedBy = "studyVO")
    private List<StudyKeywordVO> keywords = new ArrayList<>();
    @OneToMany(mappedBy = "studyVO")
    private List<StudyMemberVO> members = new ArrayList<>();

    @Builder
    public StudyVO(String studyTitle, String studyPart, String studyLocation, String studyOnOff, Long studyMax, String studyContent, String studyStatus, UserVO userVO) {
        this.studyTitle = studyTitle;
        this.studyPart = studyPart;
        this.studyLocation = studyLocation;
        this.studyOnOff = studyOnOff;
        this.studyMax = studyMax;
        this.studyContent = studyContent;
        this.studyStatus = studyStatus;
        this.userVO = userVO;
    }
}

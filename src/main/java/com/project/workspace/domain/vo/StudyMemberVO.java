package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_study_member")
@Getter
@ToString(of = {"studyMemberNum","studyMemberStatus","studyMotive"})
@NoArgsConstructor
public class StudyMemberVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_member_num")
    private Long studyMemberNum;
    @Column(name = "study_member_status")
    private String studyMemberStatus;
    @Column(name = "study_motive")
    private String studyMotive;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;
    @ManyToOne
    @JoinColumn(name = "study_num")
    private StudyVO studyVO;

    @Builder
    public StudyMemberVO(String studyMemberStatus, String studyMotive, UserVO userVO, StudyVO studyVO) {
        this.studyMemberStatus = studyMemberStatus;
        this.studyMotive = studyMotive;
        this.userVO = userVO;
        this.studyVO = studyVO;
    }
}

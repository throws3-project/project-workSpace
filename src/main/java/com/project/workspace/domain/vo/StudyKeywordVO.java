package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_study_keyword")
@Getter
@ToString
@NoArgsConstructor
public class StudyKeywordVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_keyword_num")
    private Long studyKeywordNum;
    @Column(name = "study_keyword")
    private String studyKeyword;

    @ManyToOne
    @JoinColumn(name = "study_num")
    private StudyVO studyVO;

    @Builder
    public StudyKeywordVO(String studyKeyword, StudyVO studyVO) {
        this.studyKeyword = studyKeyword;
        this.studyVO = studyVO;
    }
}

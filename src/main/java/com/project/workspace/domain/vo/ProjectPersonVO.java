package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_project_person")
@Getter
@ToString(exclude = {"projectVO"})
@NoArgsConstructor
public class ProjectPersonVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_person_num")
    private Long projectPersonNum;
    @Column(name = "project_main_skill")
    private String projectMainSkill;
    @Column(name = "project_sub_skill")
    private String projectSubSkill;
    @Column(name = "project_count")
    private Long projectCount;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private ProjectVO projectVO;

    @Builder
    public ProjectPersonVO(String projectMainSkill, String projectSubSkill, Long projectCount, ProjectVO projectVO) {
        this.projectMainSkill = projectMainSkill;
        this.projectSubSkill = projectSubSkill;
        this.projectCount = projectCount;
        this.projectVO = projectVO;
    }
}

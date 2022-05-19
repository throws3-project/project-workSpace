package com.project.workspace.domain.vo;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "tbl_project_person")
@Getter
@Setter
@ToString(exclude = {"projectVO"})
@DynamicInsert
@AllArgsConstructor
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
    public ProjectPersonVO(String projectMainSkill, String projectSubSkill, Long projectCount) {
        this.projectMainSkill = projectMainSkill;
        this.projectSubSkill = projectSubSkill;
        this.projectCount = projectCount;
    }

    public ProjectPersonVO(){;}
}

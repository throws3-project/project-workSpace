package com.project.workspace.domain.vo;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "tbl_project_skill")
@Setter
@Getter
@ToString(exclude = {"projectVO"})
@DynamicInsert
@AllArgsConstructor
public class ProjectSkillVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_num")
    private Long projectSkillNum;
    @Column(name = "project_skill")
    private String projectSkill;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private ProjectVO projectVO;

    @Builder
    public ProjectSkillVO(String projectSkill, ProjectVO projectVO) {
        this.projectSkill = projectSkill;
        this.projectVO = projectVO;
    }
    public ProjectSkillVO(){;}
}

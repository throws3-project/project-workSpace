package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_project_skill")
@Getter
@ToString(exclude = {"projectVO"})
@NoArgsConstructor
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
}

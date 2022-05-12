package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_project_referenece")
@Getter
@ToString(exclude = {"projectVO"})
@NoArgsConstructor
public class ProjectReferenceVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_reference_num")
    private Long projectReferenceNum;
    @Column(name = "project_url")
    private String projectUrl;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private ProjectVO projectVO;

    @Builder
    public ProjectReferenceVO(String projectUrl, ProjectVO projectVO) {
        this.projectUrl = projectUrl;
        this.projectVO = projectVO;
    }
}

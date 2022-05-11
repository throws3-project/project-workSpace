package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_project_referenece")
@Getter
@ToString
@NoArgsConstructor
public class ProjectReference {
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
    public ProjectReference(Long projectReferenceNum, String projectUrl, ProjectVO projectVO) {
        this.projectReferenceNum = projectReferenceNum;
        this.projectUrl = projectUrl;
        this.projectVO = projectVO;
    }
}

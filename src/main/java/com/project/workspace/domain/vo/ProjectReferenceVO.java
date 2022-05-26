package com.project.workspace.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "tbl_project_reference")
@Component
@Setter
@Getter
@ToString(exclude = {"projectVO"})
@AllArgsConstructor
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
    public ProjectReferenceVO(String projectUrl)  {
        this.projectUrl = projectUrl;
    }
}

package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_like_project")
@Getter
@ToString
@NoArgsConstructor
public class ProjectLikeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_like_num")
    private Long projectLikeNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private ProjectVO projectVO;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder
    public ProjectLikeVO(Long projectLikeNum, ProjectVO projectVO, UserVO userVO) {
        this.projectLikeNum = projectLikeNum;
        this.projectVO = projectVO;
        this.userVO = userVO;
    }
}

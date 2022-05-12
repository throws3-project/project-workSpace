package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_project")
@Getter
@ToString(exclude = { "userVO", "skills", "persons", "references", "members", "likes" })
@NoArgsConstructor
@DynamicInsert
public class ProjectVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_num")
    private Long projectNum;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_part")
    private String projectPart;
    @Column(name = "project_location")
    private String projectLocation;
    @Column(name = "project_on_off")
    private String projectOnOff;
    @Column(name = "project_platform")
    private String projectPlatform;
    @Column(name = "project_content")
    private String projectContent;
    @Column(name = "project_status")
    private String projectStatus;
    @Column(name = "project_img")
    private String projectImg;
    @Column(name = "project_img_uuid")
    private String projectImgUuid;
    @Column(name = "project_img_path")
    private String projectImgPath;
    @Column(name = "project_total")
    private Long projectTotal;
    @Column(name = "project_read_count")
    private Long projectReadCount;
    @Column(name = "login_count")
    private Long loginCount;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @OneToMany(mappedBy = "projectVO")
    private List<ProjectSkillVO> skills = new ArrayList<>();
    @OneToMany(mappedBy = "projectVO")
    private List<ProjectPersonVO> persons = new ArrayList<>();
    @OneToMany(mappedBy = "projectVO")
    private List<ProjectReferenceVO> references = new ArrayList<>();
    @OneToMany(mappedBy = "projectVO")
    private List<ProjectMemberVO> members = new ArrayList<>();
    @OneToMany(mappedBy = "projectVO")
    private List<ProjectLikeVO> likes = new ArrayList<>();

    @Builder
    public ProjectVO(String projectName, String projectPart, String projectLocation, String projectOnOff, String projectPlatform, String projectContent, String projectStatus, String projectImg, String projectImgUuid, String projectImgPath, Long projectTotal, Long loginCount, UserVO userVO) {
        this.projectName = projectName;
        this.projectPart = projectPart;
        this.projectLocation = projectLocation;
        this.projectOnOff = projectOnOff;
        this.projectPlatform = projectPlatform;
        this.projectContent = projectContent;
        this.projectStatus = projectStatus;
        this.projectImg = projectImg;
        this.projectImgUuid = projectImgUuid;
        this.projectImgPath = projectImgPath;
        this.projectTotal = projectTotal;
        this.loginCount = loginCount;
        this.userVO = userVO;
    }
}

package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_story")
@ToString
@Getter
@NoArgsConstructor
public class StoryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_num")
    private Long storyNum;
    @Column(name = "story_part")
    private String storyPart;
    @Column(name = "story_title")
    private String storyTitle;
    @Column(name = "story_content")
    private String storyContent;
    @Column(name = "story_img_name")
    private String storyImgName;
    @Column(name = "story_img_uuid")
    private String storyImgUuid;
    @Column(name = "story_img_path")
    private String storyImgPath;
    @Column(name = "story_read_count")
    private Long storyReadCount;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder
    public StoryVO(Long storyNum, String storyPart, String storyTitle, String storyContent, String storyImgName, String storyImgUuid, String storyImgPath, Long storyReadCount, UserVO userVO) {
        this.storyNum = storyNum;
        this.storyPart = storyPart;
        this.storyTitle = storyTitle;
        this.storyContent = storyContent;
        this.storyImgName = storyImgName;
        this.storyImgUuid = storyImgUuid;
        this.storyImgPath = storyImgPath;
        this.storyReadCount = storyReadCount;
        this.userVO = userVO;
    }
}

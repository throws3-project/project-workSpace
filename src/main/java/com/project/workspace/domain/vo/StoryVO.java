package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_story")
@ToString(exclude = { "userVO", "tags", "replies",  "series", "likes" })
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

    @OneToMany(mappedBy = "storyVO")
    private List<StoryTagVO> tags = new ArrayList<>();
    @OneToMany(mappedBy = "storyVO")
    private List<StoryReplyVO> replies = new ArrayList<>();
    @OneToMany(mappedBy = "storyVO")
    private List<StorySeriesVO> series = new ArrayList<>();
    @OneToMany(mappedBy = "storyVO")
    private List<StoryLikeVO> likes = new ArrayList<>();

    @Builder
    public StoryVO(String storyPart, String storyTitle, String storyContent, String storyImgName, String storyImgUuid, String storyImgPath, Long storyReadCount, UserVO userVO) {
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

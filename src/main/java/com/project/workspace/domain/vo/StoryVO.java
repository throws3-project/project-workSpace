package com.project.workspace.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_story")
@ToString(exclude = { "userVO", "tags", "replies",  "series", "likes" })
@Getter @Setter
@NoArgsConstructor
@DynamicInsert
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
    @Column(name = "story_date")
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date storyDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @JsonIgnore
    @OneToMany(mappedBy = "storyVO")
    private List<StoryTagVO> tags = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "storyVO")
    private List<StoryReplyVO> replies = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "storyVO")
    private List<StorySeriesVO> series = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "storyVO")
    private List<StoryLikeVO> likes = new ArrayList<>();

    @Builder
    public StoryVO(String storyPart, String storyTitle, String storyContent, String storyImgName, String storyImgUuid, String storyImgPath, String storyDate, UserVO userVO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.storyPart = storyPart;
        this.storyTitle = storyTitle;
        this.storyContent = storyContent;
        this.storyImgName = storyImgName;
        this.storyImgUuid = storyImgUuid;
        this.storyImgPath = storyImgPath;
        try {
            if(storyDate!=null){this.storyDate = sdf.parse(storyDate);}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.userVO = userVO;
    }
}

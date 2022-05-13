package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@Table(name = "tbl_story_reply")
@ToString(exclude = {"userVO","storyVO"})
@Getter
@NoArgsConstructor
@DynamicInsert
public class StoryReplyVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_reply_num")
    private Long storyReplyNum;
    @Column(name = "story_reply")
    private String storyReply;
    @Column(name = "reply_time")
    private Date replyTime;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @ManyToOne
    @JoinColumn(name = "story_num")
    private StoryVO storyVO;

    @Builder
    public StoryReplyVO(String storyReply, String status, UserVO userVO, StoryVO storyVO) {
        this.storyReply = storyReply;
        this.status = status;
        this.userVO = userVO;
        this.storyVO = storyVO;
    }
}

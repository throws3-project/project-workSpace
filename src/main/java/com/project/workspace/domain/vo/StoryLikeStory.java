package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_like_story")
@ToString
@Getter
@NoArgsConstructor
public class StoryLikeStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_num")
    private Long likeNum;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;
    @ManyToOne
    @JoinColumn(name = "story_num")
    private StoryVO storyVO;

    @Builder
    public StoryLikeStory(Long likeNum, UserVO userVO, StoryVO storyVO) {
        this.likeNum = likeNum;
        this.userVO = userVO;
        this.storyVO = storyVO;
    }
}

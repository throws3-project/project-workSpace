package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_like_story")
@ToString(of = {"likeNum"})
@Getter
@NoArgsConstructor
public class StoryLikeVO {
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
    public StoryLikeVO(UserVO userVO, StoryVO storyVO) {
        this.userVO = userVO;
        this.storyVO = storyVO;
    }
}

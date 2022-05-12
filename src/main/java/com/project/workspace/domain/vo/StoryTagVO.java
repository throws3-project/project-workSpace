package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_story_tag")
@ToString(of = {"storyTagNum","tagName"})
@Getter
@NoArgsConstructor
public class StoryTagVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_tag_num")
    private Long storyTagNum;
    @Column(name = "tag_name")
    private String tagName;

    @ManyToOne
    @JoinColumn(name = "story_num")
    private StoryVO storyVO;

    @Builder
    public StoryTagVO(String tagName, StoryVO storyVO) {
        this.tagName = tagName;
        this.storyVO = storyVO;
    }
}

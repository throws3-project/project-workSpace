package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_story_tag")
@ToString
@Getter
@NoArgsConstructor
public class StoryTag {
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
    public StoryTag(Long storyTagNum, String tagName, StoryVO storyVO) {
        this.storyTagNum = storyTagNum;
        this.tagName = tagName;
        this.storyVO = storyVO;
    }
}

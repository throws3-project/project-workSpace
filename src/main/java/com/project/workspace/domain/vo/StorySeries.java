package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_series")
@ToString
@Getter
@NoArgsConstructor
public class StorySeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_num")
    private Long seriesNum;
    @Column(name = "series_name")
    private Long seriesName;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;
    @ManyToOne
    @JoinColumn(name = "story_num")
    private StoryVO storyVO;

    @Builder
    public StorySeries(Long seriesNum, Long seriesName, UserVO userVO, StoryVO storyVO) {
        this.seriesNum = seriesNum;
        this.seriesName = seriesName;
        this.userVO = userVO;
        this.storyVO = storyVO;
    }
}

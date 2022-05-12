package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "tbl_series")
@ToString(of={"seriesNum","seriesName"})
@Getter
@NoArgsConstructor
public class StorySeriesVO {
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
    public StorySeriesVO(Long seriesName, UserVO userVO, StoryVO storyVO) {
        this.seriesName = seriesName;
        this.userVO = userVO;
        this.storyVO = storyVO;
    }
}

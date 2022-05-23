package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.StorySeriesVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StorySeriesRepository extends JpaRepository<StorySeriesVO, Long> {
    @Query(value = "select * from tbl_story s1 join tbl_series s2\n" +
            "on s1.story_num = s2.story_num order by story_read_count desc", nativeQuery=true)
    List<StorySeriesVO> findAllBySeriesName();
}

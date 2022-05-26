package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.QStoryVO;
import com.project.workspace.domain.vo.StoryVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class StoryQueryRepository {

    @Autowired
    JPAQueryFactory factory;

    public List<StoryVO> search(String storyPart){
        QStoryVO storyVO = QStoryVO.storyVO;
        BooleanBuilder builder = new BooleanBuilder();

        if(!storyPart.equals("선택")){
            builder.and(storyVO.storyPart.eq(storyPart));
        }

        List<StoryVO> fetched = factory.select(storyVO)
                .from(storyVO)
                .where(builder).fetch();

        return fetched;
    }




}

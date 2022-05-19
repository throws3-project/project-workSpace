package com.project.workspace.domain.vo;

import java.util.stream.Stream;

public class ProjectPersonMaker {

    private String[] count;
    private String[] main;
    private String[] sub;

    public ProjectPersonMaker(String[] count, String[] main, String[] sub) {
        this.count = count;
        this.main = main;
        this.sub = sub;
    }

    public ProjectPersonVO getProjectPersonVO(int index) {

        ProjectPersonVO projectPersonVO = new ProjectPersonVO();
        projectPersonVO.setProjectMainSkill(main[index]);
        projectPersonVO.setProjectSubSkill(sub[index]);
        projectPersonVO.setProjectCount(Long.valueOf(count[index]));

        return projectPersonVO;
    }

    public Long getProjectMaxCount() {

        return Stream.of(this.count).mapToLong(Long::valueOf)
                .sum();
    }
}

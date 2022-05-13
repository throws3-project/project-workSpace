package com.project.workspace.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
    public void insertNotice(String noticeTitle, String noticeContent,  String noticeImg, String noticeImgUuid, String noticeImgPath);
}

package com.project.workspace.domain.dao;

import com.project.workspace.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NoticeDAO {
    private final NoticeMapper noticeMapper;

    public void insertNotice(String noticeTitle, String noticeContent,  String noticeImg, String noticeImgUuid, String noticeImgPath){noticeMapper.insertNotice(noticeTitle, noticeContent, noticeImg, noticeImgUuid, noticeImgPath);}
}

package com.project.workspace.service;

import com.project.workspace.domain.dao.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
    private final NoticeDAO noticeDAO;


    @Override
    public void insertNotice(String noticeTitle, String noticeContent, String noticeImg, String noticeImgUuid, String noticeImgPath) {
        noticeDAO.insertNotice(noticeTitle, noticeContent, noticeImg, noticeImgUuid, noticeImgPath);
    }
}

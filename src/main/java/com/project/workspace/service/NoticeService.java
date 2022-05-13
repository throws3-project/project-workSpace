package com.project.workspace.service;

import org.springframework.stereotype.Service;

@Service
public interface NoticeService {
    public void insertNotice(String noticeTitle, String noticeContent,  String noticeImg, String noticeImgUuid, String noticeImgPath);
}

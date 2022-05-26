package com.project.workspace.service;

import com.project.workspace.domain.repository.NoticeRepository;
import com.project.workspace.domain.vo.NoticeVO;
import com.project.workspace.domain.vo.PageableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {

    public void insertNotice(String noticeTitle, String noticeContent,  String noticeImg, String noticeImgUuid, String noticeImgPath);
    public Page<NoticeVO> noticeList(Pageable pageable);
}

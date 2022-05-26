package com.project.workspace.service;

import com.project.workspace.domain.dao.NoticeDAO;
import com.project.workspace.domain.repository.NoticeRepository;
import com.project.workspace.domain.vo.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
    private final NoticeDAO noticeDAO;
    private final NoticeRepository noticeRepository;

    @Override
    public void insertNotice(String noticeTitle, String noticeContent, String noticeImg, String noticeImgUuid, String noticeImgPath) {
        noticeDAO.insertNotice(noticeTitle, noticeContent, noticeImg, noticeImgUuid, noticeImgPath);
    }

    @Override
    public Page<NoticeVO> noticeList(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}

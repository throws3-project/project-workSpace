package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_notice")
@Getter
@ToString
@NoArgsConstructor
public class NoticeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_num")
    private Long noticeNum;
    @Column(name = "notice_title")
    private String noticeTitle;
    @Column(name = "notice_content")
    private String noticeContent;
    @Column(name = "notice_date")
    private Date noticeDate;
    @Column(name = "notice_read_count")
    private Long noticeReadCount;
    @Column(name = "notice_img")
    private String noticeImg;
    @Column(name = "notice_img_uuid")
    private String noticeImgUuid;
    @Column(name = "notice_img_path")
    private String noticeImgPath;

    @Builder
    public NoticeVO(String noticeTitle, String noticeContent, Date noticeDate, Long noticeReadCount, String noticeImg, String noticeImgUuid, String noticeImgPath) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
        this.noticeReadCount = noticeReadCount;
        this.noticeImg = noticeImg;
        this.noticeImgUuid = noticeImgUuid;
        this.noticeImgPath = noticeImgPath;
    }
}

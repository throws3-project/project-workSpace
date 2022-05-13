package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@Table(name = "tbl_notice")
@Getter
@ToString
@NoArgsConstructor
@DynamicInsert
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
    public NoticeVO(String noticeTitle, String noticeContent, String noticeImg, String noticeImgUuid, String noticeImgPath) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeImg = noticeImg;
        this.noticeImgUuid = noticeImgUuid;
        this.noticeImgPath = noticeImgPath;
    }
}

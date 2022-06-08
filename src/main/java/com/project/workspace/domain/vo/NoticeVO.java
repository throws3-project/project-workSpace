package com.project.workspace.domain.vo;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Component
@Table(name = "tbl_notice")
@Getter @Setter
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
    @Generated(GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date noticeDate;
    @Column(name = "notice_read_count")
    private Long noticeReadCount;

    @Builder
    public NoticeVO(String noticeTitle, String noticeContent, String noticeDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        try {
            if(noticeDate!=null){this.noticeDate = sdf.parse(noticeDate);}
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

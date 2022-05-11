package com.project.workspace.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_lounge_reply")
@ToString
@Getter
@NoArgsConstructor
public class LoungeReplyVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lounge_reply_num")
    private Long loungeReplyNum;
    @Column(name = "lounge_reply_content")
    private String loungeReplyContent;
    @Column(name = "lounge_reply_date")
    private Date loungeReplyDate;
    @Column(name = "lounge_reply_status")
    private String loungeReplyStatus;

    @ManyToOne
    @JoinColumn(name = "lounge_num")
    private LoungeVO loungeVO;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;
}

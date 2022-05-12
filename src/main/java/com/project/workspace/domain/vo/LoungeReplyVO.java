package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_lounge_reply")
@ToString(exclude = {"loungeVO", "userVO"})
@Getter
@NoArgsConstructor
@DynamicInsert
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

    @Builder
    public LoungeReplyVO(String loungeReplyContent, String loungeReplyStatus, LoungeVO loungeVO, UserVO userVO) {
        this.loungeReplyContent = loungeReplyContent;
        this.loungeReplyStatus = loungeReplyStatus;
        this.loungeVO = loungeVO;
        this.userVO = userVO;
    }
}

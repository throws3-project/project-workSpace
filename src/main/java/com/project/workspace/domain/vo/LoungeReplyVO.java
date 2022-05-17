package com.project.workspace.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_lounge_reply")
@ToString(exclude = {"loungeVO", "userVO"})
@Getter @Setter
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date loungeReplyDate;
    @Column(name = "lounge_reply_status")
    private String loungeReplyStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lounge_num")
    private LoungeVO loungeVO;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder
    public LoungeReplyVO(String loungeReplyContent, LoungeVO loungeVO, UserVO userVO) {
        this.loungeReplyContent = loungeReplyContent;
        this.loungeVO = loungeVO;
        this.userVO = userVO;
    }
}

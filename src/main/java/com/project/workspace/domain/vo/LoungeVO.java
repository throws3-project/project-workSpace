package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_lounge")
@ToString
@Getter
@NoArgsConstructor
public class LoungeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lounge_num")
    private Long loungeNum;
    @Column(name = "lounge_content")
    private String loungeContent;
    @Column(name = "lounge_date")
    private Date loungeDate;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder
    public LoungeVO(Long loungeNum, String loungeContent, Date loungeDate, UserVO userVO) {
        this.loungeNum = loungeNum;
        this.loungeContent = loungeContent;
        this.loungeDate = loungeDate;
        this.userVO = userVO;
    }
}

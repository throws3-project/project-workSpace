package com.project.workspace.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_lounge")
@ToString(exclude = {"userVO", "replies", "likes"})
@Getter
@Setter
@AllArgsConstructor
@DynamicInsert
public class LoungeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lounge_num")
    private Long loungeNum;
    @Column(name = "lounge_content")
    private String loungeContent;
    @Column(name = "lounge_date")
    private Date loungeDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @JsonIgnore
    @OneToMany(mappedBy = "loungeVO")
    private List<LoungeReplyVO> replies = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "loungeVO")
    private List<LoungeLikeVO> likes = new ArrayList<>();

    @Builder
    public LoungeVO(String loungeContent, UserVO userVO) {
        this.loungeContent = loungeContent;
        this.userVO = userVO;
    }

    public LoungeVO(){;}
}

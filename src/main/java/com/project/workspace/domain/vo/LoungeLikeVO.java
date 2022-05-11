package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_like_lounge")
@ToString
@Getter
@NoArgsConstructor
public class LoungeLikeVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lounge_like_num")
    private Long loungeLikeNum;

    @ManyToOne
    @JoinColumn(name = "lounge_num")
    private LoungeVO loungeVO;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder
    public LoungeLikeVO(Long loungeLikeNum, LoungeVO loungeVO, UserVO userVO) {
        this.loungeLikeNum = loungeLikeNum;
        this.loungeVO = loungeVO;
        this.userVO = userVO;
    }
}


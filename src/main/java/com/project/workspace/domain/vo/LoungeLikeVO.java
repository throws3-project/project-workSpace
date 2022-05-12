package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_like_lounge")
@ToString(of = {"loungeLikeNum"})
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
    public LoungeLikeVO(LoungeVO loungeVO, UserVO userVO) {
        this.loungeVO = loungeVO;
        this.userVO = userVO;
    }
}


package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_userInterest")
@Getter
@ToString(of = {"interestNum","interest"})
@NoArgsConstructor
public class UserInterestVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_num")
    private Long interestNum;
    @Column(name = "interest")
    private String interest;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder
    public UserInterestVO(String interest, UserVO userVO) {
        this.interest = interest;
        this.userVO = userVO;
    }
}

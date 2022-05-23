package com.project.workspace.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@Table(name = "tbl_user_exp")
@Getter @Setter
@ToString(of = {"expNum","expDate","expValue","expHistory"})
@NoArgsConstructor
public class UserExpVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_num")
    private Long expNum;
    @Column(name = "exp_date")
    private Date expDate;
    @Column(name = "exp_value")
    private int expValue;
    @Column(name = "exp_history")
    private String expHistory;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

   @Builder
    public UserExpVO(Long expNum, int expValue, String expHistory, UserVO userVO) {
        this.expNum = expNum;
        this.expValue = expValue;
        this.expHistory = expHistory;
        this.userVO = userVO;
    }
}

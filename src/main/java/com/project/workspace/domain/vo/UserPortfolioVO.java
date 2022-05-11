package com.project.workspace.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "tbl_portfolio")
@Getter
@ToString
@NoArgsConstructor
public class UserPortfolioVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "port_num")
    private Long portNum;
    @Column(name = "port_url")
    private String portUrl;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder

    public UserPortfolioVO(Long portNum, String portUrl, UserVO userVO) {
        this.portNum = portNum;
        this.portUrl = portUrl;
        this.userVO = userVO;
    }
}

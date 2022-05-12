package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_userAlert")
@Getter
@ToString(exclude = {"userVO"})
@NoArgsConstructor
public class UserAlertVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_num")
    private Long alertNum;
    @Column(name = "alert_part")
    private String alertPart;
    @Column(name = "numbers")
    private Long numbers;
    @Column(name = "alert_type")
    private String alertType;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

    @Builder
    public UserAlertVO(String alertPart, Long numbers, String alertType, UserVO userVO) {
        this.alertPart = alertPart;
        this.numbers = numbers;
        this.alertType = alertType;
        this.userVO = userVO;
    }
}

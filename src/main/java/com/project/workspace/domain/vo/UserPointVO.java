package com.project.workspace.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
@Table(name = "tbl_user_point")
@Getter @Setter
@ToString(of = {"pointNum","pointDate","pointValue","pointHistory","pointStatus"})
@NoArgsConstructor
public class UserPointVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_num")
    private Long pointNum;
    @Column(name = "point_date")
    private Date pointDate;
    @Column(name = "point_value")
    private int pointValue;
    @Column(name = "point_history")
    private String pointHistory;
    @Column(name = "point_status")
    private String pointStatus;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

   @Builder
    public UserPointVO(Long pointNum, int pointValue, String pointHistory, String pointStatus, UserVO userVO) {
        this.pointNum = pointNum;
        this.pointValue = pointValue;
        this.pointHistory = pointHistory;
        this.pointStatus = pointStatus;
        this.userVO = userVO;
    }
}

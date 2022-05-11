package com.project.workspace.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_userTag")
@Getter
@ToString
@NoArgsConstructor
public class UserTagVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_num")
    private Long tagNum;
    @Column(name = "tag_name")
    private String tagName;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVO userVO;

   @Builder
    public UserTagVO(Long tagNum, String tagName, UserVO userVO) {
        this.tagNum = tagNum;
        this.tagName = tagName;
        this.userVO = userVO;
    }
}

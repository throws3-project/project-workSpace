package com.project.workspace.domain.vo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_follow_user")
@Getter
@ToString
@NoArgsConstructor
@IdClass(UserFollowID.class)
public class UserFollowVO{

    @Id
    @Column(name = "follower_user")
    private Long followerUser;

    @Id
    @Column(name = "following_user")
    private Long followingUser;

    @Builder
    public UserFollowVO(Long followerUser, Long followingUser) {
        this.followerUser = followerUser;
        this.followingUser = followingUser;
    }
}


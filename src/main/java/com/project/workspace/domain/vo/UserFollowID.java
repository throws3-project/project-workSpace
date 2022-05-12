package com.project.workspace.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Component
@NoArgsConstructor
public class UserFollowID implements Serializable {

    @Column(name = "follower_user")
    private Long followerUser;
    @Column(name = "following_user")
    private Long followingUser;

    public UserFollowID(Long followerUser, Long followingUser) {
        this.followerUser = followerUser;
        this.followingUser = followingUser;
    }
}

package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVO, Long> {
    public UserVO findByUserId(String userId);
    public UserVO findByUserNickname(String userNickName);
}

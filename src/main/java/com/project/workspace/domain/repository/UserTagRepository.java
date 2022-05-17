package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.UserPortfolioVO;
import com.project.workspace.domain.vo.UserTagVO;
import com.project.workspace.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTagRepository extends JpaRepository<UserTagVO, Long> {
    public List<UserTagVO> findByUserVO(UserVO userVO);
}

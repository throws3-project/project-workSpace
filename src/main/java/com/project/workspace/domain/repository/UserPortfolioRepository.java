package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.UserPortfolioVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPortfolioRepository extends JpaRepository<UserPortfolioVO, Long> {
}

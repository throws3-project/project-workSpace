package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.UserAlertVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAlertRepository extends JpaRepository<UserAlertVO, Long> {
}

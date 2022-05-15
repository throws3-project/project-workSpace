package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.LoungeLikeVO;
import com.project.workspace.domain.vo.LoungeReplyVO;
import com.project.workspace.domain.vo.LoungeVO;
import com.project.workspace.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoungeLikeRepository extends JpaRepository<LoungeLikeVO, Long> {
    @Query(value = "select user_nick_name from tbl_user u join " + "(select count(lounge_num) likeCount, user_num  from tbl_like_lounge group by lounge_num order by likeCount desc)" + " l on u.user_num = l.user_num", nativeQuery = true)
    List<UserVO> selectByLoungeVO();
}

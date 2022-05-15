package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.LoungeReplyVO;
import com.project.workspace.domain.vo.LoungeVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoungeReplyRepository extends JpaRepository<LoungeReplyVO, Long> {
    @Query(value = "sselect user_nick_name from tbl_user u join" +
            " (select count(lounge_num) replyCount, user_num  from tbl_lounge_reply" +
            " group by lounge_num order by replyCount desc) r" +
            " on u.user_num = r.user_num", nativeQuery = true)
    List<LoungeReplyVO> findAllByLoungeVO();
}

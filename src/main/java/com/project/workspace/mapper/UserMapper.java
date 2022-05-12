package com.project.workspace.mapper;


import com.project.workspace.domain.vo.UserPortfolioVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    public List<UserPortfolioVO> getInfo();
}

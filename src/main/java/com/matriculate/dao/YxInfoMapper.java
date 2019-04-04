package com.matriculate.dao;

import com.matriculate.entity.YxInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface YxInfoMapper {
    int insert(YxInfo record);

    int insertSelective(YxInfo record);
}
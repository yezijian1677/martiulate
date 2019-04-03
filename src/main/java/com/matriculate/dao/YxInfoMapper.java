package com.matriculate.dao;

import com.matriculate.entity.YxInfo;

public interface YxInfoMapper {
    int insert(YxInfo record);

    int insertSelective(YxInfo record);
}
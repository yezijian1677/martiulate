package com.matriculate.dao;

import com.matriculate.entity.SchoolMajorInfo;

public interface SchoolMajorInfoMapper {
    int insert(SchoolMajorInfo record);

    int insertSelective(SchoolMajorInfo record);
}
package com.matriculate.dao;

import com.matriculate.entity.SchoolAllMajor;

public interface SchoolAllMajorMapper {
    int insert(SchoolAllMajor record);

    int insertSelective(SchoolAllMajor record);
}
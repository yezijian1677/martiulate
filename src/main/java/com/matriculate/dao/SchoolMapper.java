package com.matriculate.dao;

import com.matriculate.entity.School;

public interface SchoolMapper {
    int insert(School record);

    int insertSelective(School record);
}
package com.matriculate.dao;

import com.matriculate.entity.School;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolMapper {
    int insert(School record);

    int insertSelective(School record);
}
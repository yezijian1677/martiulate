package com.matriculate.dao;

import com.matriculate.entity.SchoolAllMajor;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolAllMajorMapper {
    int insert(SchoolAllMajor record);

    int insertSelective(SchoolAllMajor record);
}
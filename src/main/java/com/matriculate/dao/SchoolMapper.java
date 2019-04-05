package com.matriculate.dao;

import com.matriculate.entity.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolMapper {
    int insert(School record);

    int insertSelective(School record);

    List<School> EquivalentCandidates(@Param("pm")Integer pm, @Param("klmc") String klmc);
}
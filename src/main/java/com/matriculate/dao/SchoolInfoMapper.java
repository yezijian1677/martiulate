package com.matriculate.dao;

import com.matriculate.entity.SchoolInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolInfoMapper {
    int insert(SchoolInfo record);

    int insertSelective(SchoolInfo record);

    List<SchoolInfo> selectByRankAndSubject(@Param("pm") Integer pm,@Param("klmc") String klmc);

    List<SchoolInfo> listAll();
}
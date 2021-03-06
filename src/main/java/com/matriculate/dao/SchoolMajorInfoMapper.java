package com.matriculate.dao;

import com.matriculate.entity.SchoolMajorInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolMajorInfoMapper {
    int insert(SchoolMajorInfo record);

    int insertSelective(SchoolMajorInfo record);

    List<SchoolMajorInfo> selectByRankAndMajor(@Param("pm") Integer pm, @Param("zymc")String zymc);

    List<SchoolMajorInfo> selectByRankAndMajorAndCity(@Param("pm") Integer pm, @Param("major") String major, @Param("city") String city);

}
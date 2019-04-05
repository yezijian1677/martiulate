package com.matriculate.dao;

import com.matriculate.entity.School;
import com.matriculate.entity.SchoolShort;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolMapper {
    int insert(School record);

    int insertSelective(School record);

    /**
     * 同位次考生去向
     * @param pm
     * @param klmc
     * @return
     */
    List<SchoolShort> equivalentCandidates(@Param("pm")Integer pm, @Param("klmc") String klmc);

    /**
     * 同位次考生
     * @param pm
     * @param klmc
     * @return
     */
    List<School> equivalentCandidatesAll(@Param("pm")Integer pm, @Param("klmc") String klmc);
}
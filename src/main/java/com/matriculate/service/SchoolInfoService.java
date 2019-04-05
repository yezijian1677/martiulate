package com.matriculate.service;

import com.matriculate.common.ServerResponse;
import com.matriculate.entity.SchoolInfo;
import com.matriculate.entity.SchoolMajorInfo;

import java.util.List;


public interface SchoolInfoService {

    ServerResponse<List<SchoolInfo>> selectByRankAndSubject(Integer pm, String klmc);

    ServerResponse<List<SchoolInfo>> listAll();

    ServerResponse<List<SchoolInfo>> selectByRankAndCityAndKlmc(Integer pm, String city, String klmc);
}

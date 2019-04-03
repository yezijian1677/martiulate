package com.matriculate.service;

import com.matriculate.common.ServerResponse;
import com.matriculate.entity.SchoolMajorInfo;

import java.util.List;

public interface SchoolMajorService {

    ServerResponse<List<SchoolMajorInfo>> selectByRankAndMajor(Integer pm, String zymc);
    ServerResponse<List<SchoolMajorInfo>> selectByRankAndCity(Integer pm, String city, String klmc);
}

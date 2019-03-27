package com.matriculate.service;

import com.matriculate.common.ServerResponse;
import com.matriculate.entity.SchoolInfo;

import java.util.List;


public interface SchoolInfoService {

    ServerResponse<List<SchoolInfo>> selectByRankAndSubject(Integer pm, String klmc);

    ServerResponse<List<SchoolInfo>> listAll();
}

package com.matriculate.service;

import com.matriculate.common.ServerResponse;
import com.matriculate.entity.School;
import com.matriculate.entity.SchoolShort;

import java.util.List;

public interface SchoolService {

    ServerResponse<List<SchoolShort>> equivalentCandidates(Integer pm, String klmc);
}

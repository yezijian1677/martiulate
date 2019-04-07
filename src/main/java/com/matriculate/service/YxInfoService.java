package com.matriculate.service;

import com.matriculate.common.ServerResponse;
import com.matriculate.entity.YxInfo;


public interface YxInfoService {

    ServerResponse<YxInfo> SelectYxByYxdm(String yxdm);
}

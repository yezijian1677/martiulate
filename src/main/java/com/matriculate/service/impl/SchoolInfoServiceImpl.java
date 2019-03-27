package com.matriculate.service.impl;

import com.matriculate.common.ResponseCode;
import com.matriculate.common.ServerResponse;
import com.matriculate.dao.SchoolInfoMapper;
import com.matriculate.entity.SchoolInfo;
import com.matriculate.service.SchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public ServerResponse<List<SchoolInfo>> selectByRankAndSubject(Integer pm, String klmc) {
        if (pm == null || klmc == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        //获取数据
        List<SchoolInfo> schoolInfoList = schoolInfoMapper.selectByRankAndSubject(pm, klmc);
        if (schoolInfoList == null){
            return ServerResponse.createByErrorMessage("未找到符合志愿信息");
        }

        return ServerResponse.createBySuccess(schoolInfoList);
    }

    @Override
    public ServerResponse<List<SchoolInfo>> listAll() {
        List<SchoolInfo> schoolInfoList = schoolInfoMapper.listAll();
        if (schoolInfoList==null){
            return ServerResponse.createByErrorMessage("未找到符合志愿信息");
        }
        return ServerResponse.createBySuccess(schoolInfoList);
    }
}

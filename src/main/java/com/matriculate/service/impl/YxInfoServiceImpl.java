package com.matriculate.service.impl;

import com.matriculate.common.Const;
import com.matriculate.common.ResponseCode;
import com.matriculate.common.ServerResponse;
import com.matriculate.dao.YxInfoMapper;
import com.matriculate.entity.YxInfo;
import com.matriculate.service.YxInfoService;
import com.matriculate.util.JsonUtil;
import com.matriculate.util.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YxInfoServiceImpl implements YxInfoService {

    @Autowired
    private YxInfoMapper yxInfoMapper;

    @Override
    public ServerResponse<YxInfo> SelectYxByYxdm(String yxdm) {

        if (yxdm == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        YxInfo yxInfo;
        String redisName = yxdm;
        String obj = RedisPoolUtil.get(redisName);
        if (obj == null || obj.length() == 0){
            yxInfo = yxInfoMapper.selectYxByYxdm(yxdm);
            RedisPoolUtil.setEx(redisName, JsonUtil.obj2String(yxInfo), 100);
        } else {
            yxInfo = JsonUtil.string2Obj(obj, YxInfo.class);
        }

        if (yxInfo == null){
            return ServerResponse.createByErrorMessage("未找到院校信息");
        }

        return ServerResponse.createBySuccess(yxInfo);
    }
}

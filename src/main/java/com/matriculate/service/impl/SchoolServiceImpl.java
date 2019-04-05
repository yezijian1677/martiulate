package com.matriculate.service.impl;

import com.matriculate.common.Const;
import com.matriculate.common.ResponseCode;
import com.matriculate.common.ServerResponse;
import com.matriculate.dao.SchoolMapper;
import com.matriculate.entity.School;
import com.matriculate.entity.SchoolShort;
import com.matriculate.service.SchoolService;
import com.matriculate.util.JsonUtil;
import com.matriculate.util.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;


    /**
     * 找到同位次考生的去向
     * @param pm
     * @param klmc
     * @return
     */
    @Override
    public ServerResponse<List<SchoolShort>> equivalentCandidates(Integer pm, String klmc) {

        if (pm == null || klmc == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<SchoolShort> schools;
        String pmStr = String.valueOf(pm);
        String klmcStr = Const.getKlmcName(klmc);
        String redisName = "Candidates"+pmStr+klmcStr;

        //判断redis中是否存在该数据 若有则使用redis中的数据
        String rankSubjectList = RedisPoolUtil.get(redisName);

        if (rankSubjectList == null){
            schools = schoolMapper.equivalentCandidates(pm, klmc);
            RedisPoolUtil.setEx(redisName, JsonUtil.obj2String(schools), 120);
        } else {
            schools = JsonUtil.string2Obj(rankSubjectList, List.class, School.class);

        }
        //获取数据
        if (schools == null){
            return ServerResponse.createByErrorMessage("未找到符合志愿信息");
        }

        return ServerResponse.createBySuccess(schools);
    }

    @Override
    public ServerResponse<List<School>> equivalentCandidatesAll(Integer pm, String klmc) {

        if (pm == null || klmc == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<School> schools;
        String pmStr = String.valueOf(pm);
        String klmcStr = Const.getKlmcName(klmc);
        String redisName = "CandidatesAll"+pmStr+klmcStr;

        //判断redis中是否存在该数据 若有则使用redis中的数据
        String rankSubjectList = RedisPoolUtil.get(redisName);

        if (rankSubjectList == null){
            schools = schoolMapper.equivalentCandidatesAll(pm, klmc);
            RedisPoolUtil.setEx(redisName, JsonUtil.obj2String(schools), 120);
        } else {
            schools = JsonUtil.string2Obj(rankSubjectList, List.class, School.class);

        }
        //获取数据
        if (schools == null){
            return ServerResponse.createByErrorMessage("未找到符合志愿信息");
        }

        return ServerResponse.createBySuccess(schools);
    }


}

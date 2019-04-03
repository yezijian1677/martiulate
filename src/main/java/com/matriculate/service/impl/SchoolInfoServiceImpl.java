package com.matriculate.service.impl;

import com.matriculate.common.Const;
import com.matriculate.common.ResponseCode;
import com.matriculate.common.ServerResponse;
import com.matriculate.dao.SchoolInfoMapper;
import com.matriculate.entity.SchoolInfo;
import com.matriculate.service.SchoolInfoService;
import com.matriculate.util.JsonUtil;
import com.matriculate.util.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {



    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    /**
     * 根据排名和文理科选取学校
     * @param pm
     * @param klmc
     * @return
     */
    @Override
    public ServerResponse<List<SchoolInfo>> selectByRankAndSubject(Integer pm, String klmc) {

        if (pm == null || klmc == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<SchoolInfo> schoolInfoList;
        String pmStr = String.valueOf(pm);
        String klmcStr = Const.getKlmcName(klmc);
        String redisName = "rankSubjectList"+pmStr+klmcStr;
        //判断redis中是否存在该数据 若有则使用redis中的数据
        String rankSubjectList = RedisPoolUtil.get(redisName);

        if (rankSubjectList == null){
            schoolInfoList = schoolInfoMapper.selectByRankAndSubject(pm, klmc);
            RedisPoolUtil.setEx(redisName, JsonUtil.obj2String(schoolInfoList), 120);
        } else {
            schoolInfoList = JsonUtil.string2Obj(rankSubjectList, List.class, SchoolInfo.class);

        }
        //获取数据
        if (schoolInfoList == null){
            return ServerResponse.createByErrorMessage("未找到符合志愿信息");
        }

        return ServerResponse.createBySuccess(schoolInfoList);
    }

    /**
     * 返回所有学校
     * @return
     */
    @Override
    public ServerResponse<List<SchoolInfo>> listAll() {
        List<SchoolInfo> schoolInfoList = schoolInfoMapper.listAll();
        if (schoolInfoList==null){
            return ServerResponse.createByErrorMessage("未找到符合志愿信息");
        }
        return ServerResponse.createBySuccess(schoolInfoList);
    }
}

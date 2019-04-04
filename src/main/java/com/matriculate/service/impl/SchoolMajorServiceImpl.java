package com.matriculate.service.impl;

import com.matriculate.common.ResponseCode;
import com.matriculate.common.ServerResponse;
import com.matriculate.dao.SchoolMajorInfoMapper;
import com.matriculate.entity.SchoolMajorInfo;
import com.matriculate.service.SchoolMajorService;
import com.matriculate.util.JsonUtil;
import com.matriculate.util.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolMajorServiceImpl implements SchoolMajorService {

    @Autowired
    private SchoolMajorInfoMapper schoolMajorInfoMapper;

    /**
     * 根据排名和专业选择学校
     * @param pm
     * @param zymc
     * @return
     */
    @Override
    public ServerResponse<List<SchoolMajorInfo>> selectByRankAndMajor(Integer pm, String zymc) {
        if (pm == null || zymc == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<SchoolMajorInfo> schoolMajorInfos;
        String pmStr = String.valueOf(pm);
        String redisName = "rankSubjectList"+pmStr+zymc;
        //判断redis中是否存在该数据 若有则使用redis中的数据
        String rankMajorList = RedisPoolUtil.get(redisName);

        if (rankMajorList == null){
            schoolMajorInfos = schoolMajorInfoMapper.selectByRankAndMajor(pm, zymc);
            RedisPoolUtil.setEx(redisName, JsonUtil.obj2String(schoolMajorInfos), 120);
        }else {
            schoolMajorInfos = JsonUtil.string2Obj(RedisPoolUtil.get(redisName),List.class, SchoolMajorInfo.class);
        }

        if (schoolMajorInfos == null){
            return ServerResponse.createByErrorMessage("未找到符合条件信息");
        }
        return ServerResponse.createBySuccess(schoolMajorInfos);
    }

    /**
     * 根据排名专业城市
     * @param pm
     * @param major
     * @param city
     * @return
     */
    @Override
    public ServerResponse<List<SchoolMajorInfo>> selectByRankAndMajorAndCity(Integer pm, String major, String city) {
        if (pm == null || major == null || city == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<SchoolMajorInfo> schoolMajorInfos;
        String pmStr = String.valueOf(pm);
        String redisName = "rankSubjectList"+pmStr+major+city;
        //判断redis中是否存在该数据 若有则使用redis中的数据
        String rankMajorList = RedisPoolUtil.get(redisName);

        if (rankMajorList == null){
            schoolMajorInfos = schoolMajorInfoMapper.selectByRankAndMajorAndCity(pm, major, city);
            RedisPoolUtil.setEx(redisName, JsonUtil.obj2String(schoolMajorInfos), 120);
        }else {
            schoolMajorInfos = JsonUtil.string2Obj(RedisPoolUtil.get(redisName),List.class, SchoolMajorInfo.class);
        }

        if (schoolMajorInfos == null){
            return ServerResponse.createByErrorMessage("未找到符合条件信息");
        }
        return ServerResponse.createBySuccess(schoolMajorInfos);
    }


}

package com.matriculate.service.impl;

import com.matriculate.common.Const;
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
     * 根绝排名 城市 和 科类名称选择学校
     * @param pm
     * @param city
     * @param klmc
     * @return
     */
    @Override
    public ServerResponse<List<SchoolMajorInfo>> selectByRankAndCity(Integer pm, String city, String klmc) {
        if (pm == null || city == null || klmc == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<SchoolMajorInfo> schoolMajorInfos;
        String pmStr = String.valueOf(pm);
        String redisName = "rankSubjectList"+pmStr+city+klmc;
        //判断redis中是否存在该数据 若有则使用redis中的数据
        String rankMajorList = RedisPoolUtil.get(redisName);

        if (rankMajorList == null){
            schoolMajorInfos = schoolMajorInfoMapper.selectByRankAndCity(pm, city, klmc);
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

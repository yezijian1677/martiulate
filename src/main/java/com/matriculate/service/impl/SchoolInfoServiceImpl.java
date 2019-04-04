package com.matriculate.service.impl;

import com.matriculate.common.Const;
import com.matriculate.common.ResponseCode;
import com.matriculate.common.ServerResponse;
import com.matriculate.dao.SchoolInfoMapper;
import com.matriculate.entity.SchoolInfo;
import com.matriculate.entity.SchoolMajorInfo;
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


    /**
     * 根绝排名 城市 和 科类名称选择学校
     * @param pm
     * @param city
     * @param klmc
     * @return
     */
    @Override
    public ServerResponse<List<SchoolInfo>> selectByRankAndCity(Integer pm, String city, String klmc) {
        if (pm == null || city == null || klmc == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<SchoolInfo> schoolMajorInfos;
        String pmStr = String.valueOf(pm);
        String redisName = "rankSubjectList"+pmStr+city+klmc;
        //判断redis中是否存在该数据 若有则使用redis中的数据
        String rankMajorList = RedisPoolUtil.get(redisName);

        if (rankMajorList == null){
            schoolMajorInfos = schoolInfoMapper.selectByRankAndCity(pm, city, klmc);
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

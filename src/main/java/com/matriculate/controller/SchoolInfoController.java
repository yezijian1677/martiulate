package com.matriculate.controller;

import com.matriculate.common.ServerResponse;
import com.matriculate.entity.SchoolInfo;
import com.matriculate.entity.SchoolMajorInfo;
import com.matriculate.service.SchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/schoolInfo")
public class SchoolInfoController {


    @Autowired
    private SchoolInfoService schoolInfoService;


    /**
     * 根据排名和科类来查询符合院校
     * @return
     */
    @RequestMapping("/listByRankAndSubject.do")
    @ResponseBody
    public ServerResponse listByRankAndSubject(@RequestParam(value = "pm", required = true) Integer pm, @RequestParam(value = "klmc", required = true) String klmc){

        return schoolInfoService.selectByRankAndSubject(pm, klmc);

    }

    /**
     * 列出全部院校
     * @return
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public ServerResponse listAll(){

        return schoolInfoService.listAll();

    }

    /**
     * 排名城市科类
     * @param pm
     * @param city
     * @param klmc
     * @return
     */
    @RequestMapping("/selectByRankAndCityAndKlmc")
    @ResponseBody
    public ServerResponse<List<SchoolInfo>> selectByRankAndCityAndKlmc(Integer pm, String city, String klmc){
        return schoolInfoService.selectByRankAndCityAndKlmc(pm, city, klmc);
    }

}

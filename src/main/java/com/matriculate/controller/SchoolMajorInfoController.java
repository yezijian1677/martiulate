package com.matriculate.controller;

import com.matriculate.common.ServerResponse;
import com.matriculate.entity.SchoolMajorInfo;
import com.matriculate.service.SchoolMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/schoolMajorInfo")
public class SchoolMajorInfoController {

    @Autowired
    private SchoolMajorService schoolMajorService;

    @RequestMapping("/selectByRankAndMajor")
    @ResponseBody
    public ServerResponse<List<SchoolMajorInfo>> selectByRankAndMajor(Integer pm, String zymc){
        return schoolMajorService.selectByRankAndMajor(pm, zymc);
    }

    @RequestMapping("/selectByRankAndCityAndKlmc")
    @ResponseBody
    public ServerResponse<List<SchoolMajorInfo>> selectByRankAndCityAndKlmc(Integer pm, String city, String klmc){
        return schoolMajorService.selectByRankAndCity(pm, city, klmc);
    }
}

package com.matriculate.controller;

import com.matriculate.common.ServerResponse;
import com.matriculate.service.YxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/yxinfo")
public class YxInfoController {

    @Autowired
    private YxInfoService yxInfoService;

    @RequestMapping("/selectYxByYxdm")
    @ResponseBody
    public ServerResponse selectYxByYxdm(String yxdm){
        return yxInfoService.SelectYxByYxdm(yxdm);
    }
}

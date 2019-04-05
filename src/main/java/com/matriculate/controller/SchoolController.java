package com.matriculate.controller;

import com.matriculate.common.ServerResponse;
import com.matriculate.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/candidates.do")
    @ResponseBody
    public ServerResponse equivalentCandidates(Integer pm, String klmc){
        return schoolService.equivalentCandidates(pm, klmc);
    }
}

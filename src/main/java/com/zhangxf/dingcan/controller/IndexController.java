package com.zhangxf.dingcan.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
	
	@RequestMapping("/")
    public String login(HashMap<String,Object> map){
        map.put("index","index");
        return "index";
    }
}

package com.atguigu.springboot.controller;

import org.omg.CORBA.Object;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author tangjun
 * @Description
 * @date 2018/4/21/02117:28
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){

        return "Hello World";
    }

    //查出一些数据在页面展示
    @RequestMapping("/success")
    public String success(Map<String, java.lang.Object> map){
        map.put("hello","你好");
        return "success";
    }
}

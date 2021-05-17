package com.chris.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制器
 *
 * @author zhangh
 * @date 2021/05/17
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("---index---");
        return "index";
    }
}

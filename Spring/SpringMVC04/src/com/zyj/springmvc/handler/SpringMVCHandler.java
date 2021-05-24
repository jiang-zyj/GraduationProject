package com.zyj.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SpringMVCHandler
 * @Auther: YaJun
 * @Date: 2021 - 04 - 17 - 21:17
 * @Description: com.zyj.springmvc.handler
 * @version: 1.0
 */
@Controller
public class SpringMVCHandler {

    @RequestMapping("hello")
    public String hello() {
        return "success";
    }

}

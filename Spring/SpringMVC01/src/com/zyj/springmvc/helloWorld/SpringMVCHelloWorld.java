package com.zyj.springmvc.helloWorld;

/**
 * @ClassName SpringMVCHandler
 * @Auther: YaJun
 * @Date: 2021 - 03 - 27 - 14:31
 * @Description: com.zyj.springmvc
 * @version: 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求处理器 / 控制器
 */
@Controller
public class SpringMVCHelloWorld {

    /**
     * 处理客户端的请求：http://localhost:8080/SpringMVC01/hello
     *
     * @RequestMapping：完成请求与请求处理方法的映射
     */
    @RequestMapping(value = "hello")
    public String handleHello() {
        System.out.println("Hello SpringMVC");
        // 通过视图解析器解析得到具体的视图，再转发去往该视图
        return "success";   // 视图解析器
    }

}

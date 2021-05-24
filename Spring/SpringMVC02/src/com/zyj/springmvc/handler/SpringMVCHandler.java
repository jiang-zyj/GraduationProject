package com.zyj.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName SpringMVCHandler02
 * @Auther: YaJun
 * @Date: 2021 - 04 - 10 - 12:47
 * @Description: com.zyj.springmvc.handler
 * @version: 1.0
 */
@Controller
public class SpringMVCHandler {

    /**
     * testView
     * @return
     */
    @RequestMapping("/testView")
    public String testView() {
        return "success";
    }

    /**
     * Model
     * @return
     */
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        // 模型数据：loginMsg = 用户名或者密码错误
        System.out.println(model.getClass().getName());
        model.addAttribute("loginMsg", "用户名或者密码错误");
        return "success";
    }

    /**
     * Map
     * 结论：SpringMVC 会把 Map 中的模型数据存放到 request 域对象中
     *      SpringMVC 在调用完请求处理方法后，不管方法的返回值是什么类型，都会处理
     *      成一个 ModelAndView 对象
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map) {
        // 模型数据：password = 123456
        System.out.println(map.getClass().getName());
        map.put("password", "123456");
        return "success";
    }

    /**
     * ModelAndView
     * 结论：SpringMVC会把 ModelAndView 的数据模型存放到 request 域对象中
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        // 模型数据：username = admin
        ModelAndView mav = new ModelAndView();
        mav.addObject("username", "admin");

        // 设置视图信息
        mav.setViewName("success");
        return mav;
    }

}

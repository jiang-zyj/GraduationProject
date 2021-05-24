package com.zyj.spring.annotation.controller;

import com.zyj.spring.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName UserController
 * @Auther: YaJun
 * @Date: 2021 - 03 - 18 - 15:00
 * @Description: com.zyj.spring.annotation.controller
 * @version: 1.0
 */

/**
 * @Controller 注解的作用：
 * 相当于在 xml 文件中做了以下配置：
 * <bean id = "userController" class = "com.zyj.spring.annotation.controller.UserController"></bean>
 *
 * 注解默认的 id 值就是 类名的首字母小写，可以在注释中手动指定 id 值：
 * @Controller(value = "id值")
 * 可以简写为 @Controller("id值")
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    public void register() {
        userService.handleAddUser();
    }
}

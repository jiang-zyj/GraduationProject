package com.zyj.springmvc.interceptor;

/**
 * @ClassName MyFirstInterceptor
 * @Auther: YaJun
 * @Date: 2021 - 04 - 17 - 19:53
 * @Description: com.zyj.springmvc.interceptor
 * @version: 1.0
 */

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
//@Component
public class MyFirstInterceptor implements HandlerInterceptor {

    /**
     * 多个拦截器执行顺序原理
     *
     * preHandle 是从小往大迭代，所以看到的是一个正序的过程
     * postHandle 以及 afterCompletion 是从大往小迭代，所以看到的是一个倒序的过程
     *
     * 第一个拦截器在 preHandle 方法返回 true 之后，后续的方法不会再执行
     */


    /**
     * 1.是在 DispatcherServlet 的 939行，在请求处理方法之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyFirstInterceptor  preHandle");
        return true;
    }

    /**
     * 2.在 DispatcherServlet 959行，请求处理方法之后，视图处理之前执行。
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor  postHandle");
    }

    /**
     * 3.
     *  [1].在 DispatcherServlet 的 1030行，视图处理之后执行。（转发/重定向后执行）
     *  [2].当某个拦截器的 preHandle 返回 false 后，也会执行当前拦截器之前拦截器的 afterCompletion 方法
     *  [3].当 DispatcherServlet 的 doDispatcher 方法抛出异常，也可能会执行拦截器的 afterCompletion 方法
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyFirstInterceptor  afterCompletion");
    }
}


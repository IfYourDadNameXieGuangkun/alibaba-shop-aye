package com.aye.product.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TestHandlerInterceptor
 * @Description 拦截器
 * @Author Aye
 * @Date 2020/9/8 15:48
 * @Version 1.0
 */
@Slf4j
public class TestHandlerInterceptor implements HandlerInterceptor {

    /**
     * 请求方法执行之前
     * 返回true则通过
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        StringBuffer requestURL = request.getRequestURL();
        log.info("preHandle请求URL：" + requestURL.toString());
        return true;
    }

    /**
     * 返回modelAndView之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("postHandle返回modelAndView之前");
    }

    /**
     * 执行Handler完成执行此方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("afterCompletion执行完请求方法完全返回之后");
    }
}
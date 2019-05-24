package com.example.sell.handler;

import com.example.sell.config.ProjectUrlConfig;
import com.example.sell.exception.SellAuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 捕获到SellAuthorizeException，跳转页面
 * @Author: ShaoPing
 * @Data:2019\5\24 0024 14:33
 */
@ControllerAdvice
@Slf4j
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = SellAuthorizeException.class)
    public ModelAndView handlerAuthorize(){
        log.warn("无权访问");
        //跳转登录页
        String url = projectUrlConfig.getSell()+"/sell/seller/qrAuthorize";
        return new ModelAndView("redirect:"+url);
    }
}

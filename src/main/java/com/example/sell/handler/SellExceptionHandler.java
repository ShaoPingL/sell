package com.example.sell.handler;

import com.example.sell.VO.ResultVO;
import com.example.sell.config.ProjectUrlConfig;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.ResponseBankException;
import com.example.sell.exception.SellAuthorizeException;
import com.example.sell.exception.SellException;
import com.example.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.RequestWrapper;

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
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorize(){
        log.warn("无权访问");
        //跳转登录页
        //String url = projectUrlConfig.getSell()+"/sell/seller/qrAuthorize";
        return new ModelAndView("common/login");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSell(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBank(){

    }
}

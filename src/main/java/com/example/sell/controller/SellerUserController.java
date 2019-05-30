package com.example.sell.controller;

import com.example.sell.config.ProjectUrlConfig;
import com.example.sell.constant.CookieConstant;
import com.example.sell.constant.RedisConstant;
import com.example.sell.entity.SellerInfo;
import com.example.sell.enums.ResultEnum;
import com.example.sell.service.SellerService;
import com.example.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ShaoPing
 * @Data:2019\5\23 0023 18:02
 */
@RequestMapping("/seller")
@RestController
@Slf4j
public class SellerUserController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openId") String openId, HttpServletResponse response, Map<String, Object> map){
        //1.验证openId
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openId);
        if (sellerInfo == null){
            map.put("mes", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        //2.把token存到redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openId,expire, TimeUnit.SECONDS);

        //3.把token存到cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        log.info(projectUrlConfig.getSell());
        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response, Map<String, Object> map){
        //1.从cookie里面查询
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie != null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response,cookie.getName(),"",0);
        }
        map.put("mes", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");

    }
    //没有商户和开发平台 所以跳转不到登录二维码页面
//    @GetMapping("/qrAuthorize")
//    public ModelAndView qrAuthorize(){
//        return new ModelAndView("common/login");
//    }

}

package com.example.sell.controller;

import com.example.sell.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShaoPing
 * @Data:2019\5\25 0025 14:56
 * 秒杀 压测
 */
@RestController
@RequestMapping("/skill")
@Slf4j
public class SecKillControllrt {

    @Autowired
    private SecKillService secKillService;


    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId){
        return secKillService.querySecKillProductInfo(productId);
    }

    @GetMapping("/skill/{productId}")
    public String skill(@PathVariable String productId){
        log.info("@skill request, productId:"+productId);
        secKillService.orderProductMockDiffUser(productId);
        return secKillService.querySecKillProductInfo(productId);
    }

}

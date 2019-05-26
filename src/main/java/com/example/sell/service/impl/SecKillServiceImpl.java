package com.example.sell.service.impl;


import com.example.sell.exception.SellException;
import com.example.sell.service.RedisLock;
import com.example.sell.service.SecKillService;
import com.example.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 秒杀 压测
 * @Author: ShaoPing
 * @Data:2019\5\25 0025 15:00
 */
@Service
@Slf4j
public class SecKillServiceImpl implements SecKillService {

    private static final int TIMEOUT = 10*1000;//超时时间10

    @Autowired
    private RedisLock redisLock;

    private int num;

    static Map<String,Integer> products;
    static Map<String,Integer> stock;
    static Map<String,String> orders;
    static{
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456",100000);
        stock.put("123456",100000);
    }

    private String queryMap(String productId){
        return "儿童节活动，棒棒糖特价，限量"
                +products.get(productId)
                +" 还剩:"+stock.get(productId)+"份"
                +" 该商品成功下单："
                +orders.size()+" 人";
    }
    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    //synchronized 只能适用于单机   不够细粒
    @Override
    public void orderProductMockDiffUser(String productId) {
        //加锁
        Long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLock.lock(productId,String.valueOf(time))){
            throw new SellException(101,"人太多了，换个姿势再试试~~");
        }
        //查询库存
        int stockNum = stock.get(productId);
        if (stockNum == 0){
            throw new SellException(100,"活动结束");
        }else{
            num ++;
            log.info("第"+num+"抢到的");
            //下单
            orders.put(KeyUtil.genUniqueKey(),productId);
            //减库存
            stockNum = stockNum-1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }
        //解锁
        redisLock.unlock(productId,String.valueOf(time));
    }
}

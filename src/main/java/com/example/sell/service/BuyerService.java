package com.example.sell.service;

import com.example.sell.DTO.OrderDTO;

/**
 * @Author: ShaoPing
 * @Data:2019\5\12 0012 22:08
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消一个订单
    OrderDTO cancelOrder(String openid,String orderId);
}

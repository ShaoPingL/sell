package com.example.sell.service;

import com.example.sell.DTO.OrderDTO;

/**
 * @Author: ShaoPing
 * @Data:2019\5\24 0024 22:23
 */
public interface PushMessageService {

    void OrderStatus(OrderDTO orderDTO);
}

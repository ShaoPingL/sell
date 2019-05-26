package com.example.sell.service;

/**
 * @Author: ShaoPing
 * @Data:2019\5\25 0025 14:57
 */
public interface SecKillService {

    String querySecKillProductInfo(String productId);

    void orderProductMockDiffUser(String productId);
}

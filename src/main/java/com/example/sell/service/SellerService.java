package com.example.sell.service;

import com.example.sell.entity.SellerInfo;

/**
 * @Author: ShaoPing
 * @Data:2019\5\23 0023 12:21
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}

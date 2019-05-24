package com.example.sell.service.impl;

import com.example.sell.entity.SellerInfo;
import com.example.sell.repository.SellerInfoRepository;
import com.example.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ShaoPing
 * @Data:2019\5\23 0023 12:22
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findSellerInfoByOpenid(openid);
    }
}

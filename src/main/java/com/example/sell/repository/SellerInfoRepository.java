package com.example.sell.repository;

import com.example.sell.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ShaoPing
 * @Data:2019\5\23 0023 12:16
 */
@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findSellerInfoByOpenid(String openid);
}

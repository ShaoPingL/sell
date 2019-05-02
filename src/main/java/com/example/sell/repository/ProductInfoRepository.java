package com.example.sell.repository;

import com.example.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: ShaoPing
 * @Data:2019\4\18 0018 22:19
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

        List<ProductInfo> findByProductStatus(Integer status);
}

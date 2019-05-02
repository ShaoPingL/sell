package com.example.sell.service;

import com.example.sell.DTO.CartDTO;
import com.example.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: ShaoPing
 * @Data:2019\4\18 0018 22:22
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);
    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);




}

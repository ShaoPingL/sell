package com.example.sell.service;

import com.example.sell.entity.ProductCategory;

import java.util.List;

/**
 * @Author: ShaoPing
 * @Data:2019\4\18 0018 21:00
 */
public interface CategoryService {

    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> idList);

    ProductCategory save(ProductCategory productCategory);
}

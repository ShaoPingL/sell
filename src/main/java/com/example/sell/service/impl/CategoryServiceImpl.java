package com.example.sell.service.impl;

import com.example.sell.entity.ProductCategory;
import com.example.sell.repository.ProductCategoryRepository;
import com.example.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ShaoPing
 * @Data:2019\4\18 0018 21:05
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> idList) {
        return productCategoryRepository.findByCategoryTypeIn(idList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}

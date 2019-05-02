package com.example.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: ShaoPing
 * @Data:2019\4\12 0012 21:39
 */
@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;
}

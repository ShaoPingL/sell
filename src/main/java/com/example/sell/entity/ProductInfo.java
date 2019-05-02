package com.example.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: ShaoPing
 * @Data:2019\4\18 0018 22:03
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**
     * 名字
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     *库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 状态 0正常1下架
     */
    private Integer productStatus;

    /**
     * 商品类目
     */
    private Integer categoryType;


}

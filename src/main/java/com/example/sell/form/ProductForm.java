package com.example.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: ShaoPing
 * @Data:2019\5\23 0023 0:05
 */
@Data
public class ProductForm {

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
     * 商品类目
     */
    private Integer categoryType;
}

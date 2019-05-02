package com.example.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 * @Author: ShaoPing
 * @Data:2019\4\18 0018 22:34
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "上架"),
    DOWN(1, "下架")
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

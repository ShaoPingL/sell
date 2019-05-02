package com.example.sell.enums;

import lombok.Getter;

/**
 * @Author: ShaoPing
 * @Data:2019\4\25 0025 22:26
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

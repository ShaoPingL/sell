package com.example.sell.enums;

import lombok.Getter;

/**
 * @Author: ShaoPing
 * @Data:2019\4\25 0025 22:26
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),

    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.example.sell.exception;

import com.example.sell.enums.ResultEnum;

/**
 * @Author: ShaoPing
 * @Data:2019\4\27 0027 14:54
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException (ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

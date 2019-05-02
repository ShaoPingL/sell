package com.example.sell.VO;

import lombok.Data;

/**
 * @Author: ShaoPing
 * @Data:2019\4\19 0019 23:04
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;
}

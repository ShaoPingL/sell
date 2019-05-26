package com.example.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ShaoPing
 * @Data:2019\4\19 0019 23:04
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3938626101358237007L;
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

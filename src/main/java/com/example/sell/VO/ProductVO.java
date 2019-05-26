package com.example.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: ShaoPing
 * @Data:2019\4\19 0019 23:21
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -5447535631819490819L;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}

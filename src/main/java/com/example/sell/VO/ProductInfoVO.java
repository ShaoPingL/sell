package com.example.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: ShaoPing
 * @Data:2019\4\18 0018 22:03
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -2700720274478603065L;
    @JsonProperty("id")
    private String productId;


    @JsonProperty("name")
    private String productName;


    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}

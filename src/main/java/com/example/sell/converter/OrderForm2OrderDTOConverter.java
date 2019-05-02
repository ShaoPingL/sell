package com.example.sell.converter;

import com.example.sell.DTO.OrderDTO;
import com.example.sell.entity.OrderDetail;
import com.example.sell.enums.ResultEnum;
import com.example.sell.exception.SellException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.example.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ShaoPing
 * @Data:2019\5\2 0002 0:54
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

}

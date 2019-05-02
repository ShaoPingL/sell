package com.example.sell.service.impl;

import com.example.sell.DTO.OrderDTO;
import com.example.sell.entity.OrderDetail;
import com.example.sell.enums.OrderStatusEnum;
import com.example.sell.enums.PayStatusEnum;
import com.example.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: ShaoPing
 * @Data:2019\4\27 0027 18:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private final String openid = "winxinid001";

    private final String orderid = "1556363196442809491";
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("清河");
        orderDTO.setBuyerName("闹闹");
        orderDTO.setBuyerPhone("13512000001");
        orderDTO.setBuyerOpenid(openid);
        //订单详情
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail detail1 = new OrderDetail();
        detail1.setProductId("123546");
        detail1.setProductQuantity(1);
        orderDetailList.add(detail1);

        OrderDetail detail2 = new OrderDetail();
        detail2.setProductId("123546");
        detail2.setProductQuantity(2);
        orderDetailList.add(detail2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(orderid);
        log.info("【查询单个订单】result={}",orderDTO);
        Assert.assertEquals(orderid,orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, PageRequest.of(0,2));
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(orderid);
        OrderDTO updateResult = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),updateResult.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(orderid);
        OrderDTO updateResult = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),updateResult.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(orderid);
        OrderDTO updateResult = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),updateResult.getPayStatus());
    }

    @Test
    public void findList1() {
    }
}
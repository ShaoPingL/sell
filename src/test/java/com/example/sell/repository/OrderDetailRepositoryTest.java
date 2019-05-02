package com.example.sell.repository;

import com.example.sell.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: ShaoPing
 * @Data:2019\4\27 0027 12:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("654322");
        orderDetail.setOrderId("111");
        orderDetail.setProductIcon("http://asas.jpg");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductId("11");
        orderDetail.setProductPrice(new BigDecimal(2.3));
        orderDetail.setProductQuantity(1);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId(){
        List<OrderDetail> list = orderDetailRepository.findByOrderId("111");
        Assert.assertNotEquals(0,list.size());
    }
}
package com.example.sell.repository;

import com.example.sell.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @Author: ShaoPing
 * @Data:2019\4\27 0027 12:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
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
//        List<OrderDetail> list = orderDetailRepository.findByOrderId("1558695450878332710");
//        Assert.assertNotEquals(0,list.size());
//        Boolean b1 = Boolean.valueOf("true");
//        Boolean b2 = Boolean.valueOf("True");
//        log.info("==="+(b1==b2));

//        String g = "a1";
//        String h = "a" + 1;
//        System.out.println((g == h));
//
//        StringBuffer sb1 = null;
//        String string = new String();
//        int a = 1;
//        int b = 2;
//        System.out.println(a<<1);
//        System.out.println(b<<1);
//
//        Map
//        List<String> list = new LinkedList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        System.out.println(list.size());


    }
}
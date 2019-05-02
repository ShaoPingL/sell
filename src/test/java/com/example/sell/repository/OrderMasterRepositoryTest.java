package com.example.sell.repository;

import com.example.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: ShaoPing
 * @Data:2019\4\27 0027 11:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("闹闹");
        orderMaster.setBuyerAddress("北街家园");
        orderMaster.setBuyerOpenid("123");
        orderMaster.setBuyerPhone("13512007282");
        orderMaster.setOrderId("123458");
        orderMaster.setOrderAmount(new BigDecimal(5));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid(){
        PageRequest pageRequest = PageRequest.of(1,2);
        Page<OrderMaster> page = orderMasterRepository.findByBuyerOpenid("123",pageRequest);
        Assert.assertNotEquals(0,page.getTotalElements());
    }
}
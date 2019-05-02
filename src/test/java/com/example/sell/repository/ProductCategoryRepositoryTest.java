package com.example.sell.repository;

import com.example.sell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ShaoPing
 * @Data:2019\4\12 0012 21:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(1);
        repository.save(productCategory);
    }

    @Test
    public void findAll(){
        List list = repository.findAll();
        System.out.println(list.toString());
    }

    @Test
    //@Transactional//事务回滚
    public void findOne(){
        ProductCategory productCategory = repository.findById(1).get();
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findByType() {
        log.error("error==========findByType");
        log.info("info==========findByType");
        List<Integer> list = Arrays.asList(1,2,3,4);
        List resultList = repository.findByCategoryTypeIn(list);
        System.out.println(resultList);
    }

    @Test
    public void lambdaTest(){


    }
}


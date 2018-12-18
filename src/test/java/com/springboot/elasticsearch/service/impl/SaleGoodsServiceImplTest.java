package com.springboot.elasticsearch.service.impl;

import com.springboot.elasticsearch.service.SaleGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleGoodsServiceImplTest {

    @Autowired
   private  SaleGoodsService saleGoodsService;

    @Test
    public void saleGoodsList() {
        saleGoodsService.SaleGoodsList();
    }

    @Test
    public void SaleGoodsText(){
        saleGoodsService.SaleGoodsTest();
    }
}
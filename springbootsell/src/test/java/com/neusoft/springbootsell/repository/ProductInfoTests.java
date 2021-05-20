package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoTests {
    @Autowired
   ProductInfoRepository repository;

    @Test
    public void saveTest(){

        ProductInfo productInfo= new ProductInfo();
        productInfo.setProductId("24865");
        productInfo.setProductName("西米露");
        productInfo.setProductPrice(new BigDecimal((6.9)));
        productInfo.setProductStock(777);
        productInfo.setProductDescription("很棒");
        productInfo.setProductIcon("http");
        productInfo.setCategoryType(2);

        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);




    }
}

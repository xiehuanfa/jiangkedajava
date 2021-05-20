package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTests {
    @Autowired
    ProductCategoryRepository repository;
    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(10);
        productCategory.setCategoryName("老师专享");
        productCategory.setCategoryType(88);





        ProductCategory result=repository.save(productCategory);

        Assert.assertNotNull(result);
    }
}

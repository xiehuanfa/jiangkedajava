package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderDetailRepositoryTests {
    @Autowired
    OrderDetailRepository repository;

    @Test
    public void saveTest() {


        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("147258369");
        orderDetail.setOrderId("159357");
        orderDetail.setProductId("193758");
        orderDetail.setProductIcon("hhh：//xxx.png");
        orderDetail.setProductName("辣子鸡");
        orderDetail.setProductPrice(new BigDecimal((3.30)));
        orderDetail.setProductQuantity(2);

        OrderDetail result=repository.save(orderDetail);

        Assert.assertNotNull(result);

    }
}

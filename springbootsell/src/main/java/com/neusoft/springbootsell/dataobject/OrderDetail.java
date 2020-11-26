package com.neusoft.springbootsell.dataobject;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

//订单详情
@Entity
@Data
public class OrderDetail {
@Id
    private String detailId;
//       订单id
    private String orderId;
//       商品id
    private String productId;
//       商品名称
    private String productName;
//       商品单价
    private BigDecimal productPrice;
//       商品数量
    private Integer productQuantity;

    private String productIcon;

}

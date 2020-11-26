package com.nuesoft.redbag;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class LuckyMoney {
    @Id
    @GeneratedValue
    private  Integer id;

    private BigDecimal money;

    private  String producer;

    private  String consumer;


}



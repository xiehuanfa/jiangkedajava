package com.nuesoft.redbag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//(exclude = DataSourceAutoConfiguration)
@SpringBootApplication

public class RedbagApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedbagApplication.class, args);
    }

}

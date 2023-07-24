package com.qydp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.qydp.mapper")
@SpringBootApplication
public class QyDianPingApplication {

    public static void main(String[] args) {
        SpringApplication.run(QyDianPingApplication.class, args);
    }

}

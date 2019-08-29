package com.haina.flight.price;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@MapperScan("com.haina.flight.price.dao")
@EnableEurekaServer
@SpringBootApplication
public class FlightApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlightApplication.class,args);
    }
}

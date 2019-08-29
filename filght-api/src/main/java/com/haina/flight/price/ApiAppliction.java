package com.haina.flight.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.haina.flight.price"})
public class ApiAppliction {

    public static void main(String[] args) {
        SpringApplication.run(ApiAppliction.class,args);
    }

}

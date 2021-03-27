package com.haina.flight.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.haina.flight.price"})
public class ApiAppliction {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAppliction.class);

    public static void main(String[] args) {
        LOGGER.info("ApiAppliction run start up");
        SpringApplication.run(ApiAppliction.class, args);
    }
}

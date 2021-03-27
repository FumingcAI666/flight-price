package com.haina.flight.price;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@MapperScan("com.haina.flight.price.dao")
@EnableEurekaServer
@SpringBootApplication
public class FlightApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightApplication.class);

    public static void main(String[] args) {
        LOGGER.info("FlightApplication run start up");
        SpringApplication.run(FlightApplication.class,args);
    }
}

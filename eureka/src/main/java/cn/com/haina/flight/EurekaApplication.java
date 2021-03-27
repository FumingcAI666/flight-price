package cn.com.haina.flight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        LOGGER.info("EurekaApplication run start up");
        SpringApplication.run(EurekaApplication.class,args);
    }
}

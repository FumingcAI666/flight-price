package com.haina.flight.price;

import com.haina.flight.price.service.FlightQueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FlightApplication.class})
public class RedisTest {
    @Resource
    private FlightQueryService flightQueryService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testFlightQueryService() {
        String orgign = "";
        String dest = "";
        String departDate = " ";
        flightQueryService.getFligthByODAnfDepartDate(orgign, dest, departDate);
    }

    @Test
    public void test() {
        //redisTemplate.opsForValue().set("aaa","aaa");
        System.out.println(redisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test01() {
        List<String> languages = Arrays.asList("java", "scala", "python");
        languages.forEach(x -> System.out.println(x));
    }


}

package com.utopia.demo;

import com.utopia.demo.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.event.TransactionalEventListener;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisService redisService;
    @Test
    public void redisTest() {

        redisService.set("stone", "stone");
        System.out.println(redisService.get("stone"));

        redisTemplate.opsForValue().set("test:set1", "testValue1");
        redisTemplate.opsForSet().add("test:set2", "asdf");
        redisTemplate.opsForHash().put("hash1", "name1", "lms1");
        redisTemplate.opsForHash().put("hash1", "name2", "lms2");
        redisTemplate.opsForHash().put("hash1", "name3", "lms3");
        System.out.println(redisTemplate.opsForValue().get("test:set1"));
        System.out.println(redisTemplate.opsForHash().get("hash1", "name1"));

    }


}

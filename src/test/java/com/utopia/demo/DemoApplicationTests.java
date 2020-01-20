package com.utopia.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@RestController
class DemoApplicationTests {


    @Test
    @GetMapping(value = "/auth")
    public String JWT_test() {
        return  "hello auth";
    }

}

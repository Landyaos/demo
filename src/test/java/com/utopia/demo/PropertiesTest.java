package com.utopia.demo;

import com.utopia.demo.component.ElasticsearchProperties;
import com.utopia.demo.component.JwtProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertiesTest {

    @Autowired
    private ElasticsearchProperties elasticsearchProperties;
    @Autowired
    private JwtProperties jwtProperties;

    @Test
    public void EsPropertiesTest() {
        System.out.println(jwtProperties);
        System.out.println(elasticsearchProperties);

    }




}

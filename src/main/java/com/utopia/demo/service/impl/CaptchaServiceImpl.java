package com.utopia.demo.service.impl;

import com.utopia.demo.service.CaptchaService;
import com.utopia.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private RedisService redisService;

    @Override
    public String generateCaptcha(String username) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        redisService.set("captcha" + username, stringBuilder.toString());
        redisService.expire("captcha" + username, 120);
        return stringBuilder.toString();
    }

    @Override
    public Boolean verifyCaptcha(String username, String captcha) {

        if (StringUtils.isEmpty(captcha) || redisService.get("captcha" + username) == null) {
            return false;
        }
        return redisService.get("captcha" + username).equals(captcha);
    }

}

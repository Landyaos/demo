package com.utopia.demo.service;

import com.utopia.demo.common.CommonResult;

public interface CaptchaService {
    /**
     *
     * @param username
     * @return
     */
    String generateCaptcha(String username);

    /**
     *
     * @param username
     * @param captcha
     * @return
     */
    Boolean verifyCaptcha(String username, String captcha);

}

package com.utopia.demo.component;

import com.alibaba.druid.pool.ha.selector.StickyRandomDataSourceSelector;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    /**
     * tokenHeader: Authorization # JWT 请求头
     * secret: recommendSystem # 加密密钥
     * expiration: 604800 #　过期时间：60*60*24( 1 day　)
     * tokenHead: Bearer
     */
    private String tokenHeader;
    private String secret;
    private Long expiration;
    private String tokenHead;

    @Override
    public String toString() {
        return "JwtProperties{" +
                "tokenHeader='" + tokenHeader + '\'' +
                ", secret='" + secret + '\'' +
                ", expiration=" + expiration +
                ", tokenHead='" + tokenHead + '\'' +
                '}';
    }

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }
}

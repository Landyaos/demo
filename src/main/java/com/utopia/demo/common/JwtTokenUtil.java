package com.utopia.demo.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.utopia.demo.service.impl.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Tool class to generate JWT token
 * Token format： header.payload.signature
 * header format: （algorithm，type）
 * {
 * "alg":"HS512",
 * "typ":"JWT",
 * }
 * payload format: (sub， birth, expired)
 * {
 * "username":"Stone",
 * "created": xx,
 * "expired":xx,
 * }
 * signature generated algorithm:
 * HMACSHA512(base64UrlEncode(header)+"."+base64UrlEncode(payload),secret)
 */
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    /**
     * func: generate JWT token
     * <p>
     * JwtBuilder builder = Jwts.builder()         //这里其实就是new一个JwtBuilder，设置jwt的body
     * .setClaims(claims)          //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
     * .setId(id)                  //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
     * .setIssuedAt(now)           //iat: jwt的签发时间
     * .setSubject(subject)        //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
     * .signWith(signatureAlgorithm, key);//设置签名使用的签名算法和签名使用的秘钥
     */
    public String generateToken(UserDetailsImpl userDetailsImpl) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userDetailsImpl.getUsername());
        claims.put("created", new Date());

        return generateToken(claims);
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("created", new Date());

        return generateToken(claims);
    }


    public String getUsername(String token) {
        Claims claims = null;
        String username = null;
        try {
            claims = getClaims(token);
            username = claims.get("username", String.class);

            System.out.println("isExp : " + isExpired(token));

        } catch (Exception e) {
            System.out.println(e);
        }
        return username;
    }

    public boolean validateToken(String token, UserDetailsImpl userDetails) {
        String username = getUsername(token);
        return username.equals(userDetails.getUsername()) && !isExpired(token);
    }

    public String refreshToken(String token) {
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        String token_refresh = token.substring(tokenHeader.length());

        if (StrUtil.isEmpty(token_refresh)) {
            return null;
        }

        Claims claims = getClaims(token_refresh);
        if (claims == null || isExpired(token_refresh) ){

            return null;
        }
        if (isRefreshRecent(token_refresh, 30 * 60)) {
            return token_refresh;
        } else {
            claims.put("created", new Date());
            return generateToken(claims);
        }

    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private boolean isRefreshRecent(String token, int time) {
        Claims claims = getClaims(token);
        Date created = claims.get("created", Date.class);
        Date refreshDate = new Date();
        if (refreshDate.after(created) && refreshDate.before(DateUtil.offsetSecond(created, time))) {
            return true;
        }
        return false;
    }

    private Date generateExpirationDate() {
        System.out.println(expiration);
        return new Date(
                System.currentTimeMillis() + expiration * 1000
        );
    }

    private boolean isExpired(String token) {
        Date expiredDate = getExpiredDate(token);
        return expiredDate.before(new Date());
    }

    private Claims getClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println(e);
        }
        return claims;
    }

    private Date getExpiredDate(String token) {
        return getClaims(token).getExpiration();
    }



}

package com.wendy.demo.utils;

import com.wendy.common.utils.PropertiesUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/11 22:43
 * @Version 1.0
 */
public class JwtUtils {
    private static final long EXPIRE_TIME = 86_400;

    public static String generateToken(String userName) {
        return Jwts.builder()
                .setClaims(getClaims(userName))
                .setExpiration(getExpiration())
                .signWith(SignatureAlgorithm.HS512, getSecret())
                .compact();
    }

    private static Date getExpiration() {
        return new Date(System.currentTimeMillis() + EXPIRE_TIME * 1000);
    }

    private static String getSecret() {
        return PropertiesUtils.getProperty("jwt.secret", "secret.properties");
    }

    private static Map<String, Object> getClaims(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", userName);
        return claims;
    }

    public static boolean verifyToken(String token, String userName) {
        Claims claims = Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(token).getBody();

        // 校验是否过期
        Date expiration = claims.getExpiration();
        if (expiration.before(new Date())) {
            return false;
        }

        // 校验用户
        String parsedUserName = claims.get("userName", String.class);
        if (!StringUtils.equals(userName, parsedUserName)) {
            return false;
        }
        return true;
    }

}

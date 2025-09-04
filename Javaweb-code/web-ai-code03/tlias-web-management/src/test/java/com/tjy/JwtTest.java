package com.tjy;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @date 2025/8/13 19:59
 */
public class JwtTest {

    /**
     * 生成JWT令牌
     */
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "tjy");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "dGFuZ2ppYW5neXVhbg==") // 指定加密算法，密钥(Base64)
                .addClaims(dataMap) // 添加自定义数据
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间(当前时间往后一个小时)
                .compact(); // 生成JWT令牌
        System.out.println(jwt);
    }

    /**
     * 解析JWT令牌
     */
    @Test
    public void testParseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0ankiLCJleHAiOjE3NTUwOTA3ODF9.i095w0TzwToVAlqO8gQLUXOs3TfqqsraHc77z78IMvw";
        Claims claims = Jwts.parser().setSigningKey("dGFuZ2ppYW5neXVhbg==") // 指定密钥(Base64)
                .parseClaimsJws(token) // 解析JWT令牌
                .getBody(); // 获取自定义数据
        System.out.println(claims);
    }

    @Test
    public void testGenerateJwt01() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "tjy");
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, "SldUVEVTVA==")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000 * 12))
                .compact();
        System.out.println(token);
    }

    @Test
    public void testParseJwt01() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0ankiLCJleHAiOjE3NTU0NjQ4NjZ9.U4Se31Sh5eescGIamx9aOkNMj3HQhjSCJRpd49g9ev0";
        Claims claims = Jwts.parser()
                .setSigningKey("SldUVEVTVA==")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}

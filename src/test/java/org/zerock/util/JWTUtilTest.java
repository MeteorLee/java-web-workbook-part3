package org.zerock.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class JWTUtilTest {

    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate() {

        Map<String, Object> claimMap = Map.of("mid", "ABCDE");

        String jwtStr = jwtUtil.generateToken(claimMap, 1);

        log.info("jwtStr = " + jwtStr);

    }

    @Test
    public void testValidate() {

        // 유효 시간이 지난 토큰
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2ODIzOTg0NjYsIm1pZCI6IkFCQ0RFIiwiaWF0IjoxNjgyMzk4NDA2fQ.ZDx2MhsCWUD2lL06-qzB8-eey7yEifASTtIVVw89Yy8";

        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);

        log.info("claim = " + claim);

    }

    @Test
    public void testAll() {

        String jwtStr = jwtUtil.generateToken(Map.of("mid", "AAAA", "email", "aaaa@bbb.com"), 1);

        log.info("jwtStr = " + jwtStr);

        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);

        log.info("claim.get(\"mid\") = " + claim.get("mid"));
        log.info("claim.get(\"email\") = " + claim.get("email"));

        log.info("claim = " + claim);
    }
}
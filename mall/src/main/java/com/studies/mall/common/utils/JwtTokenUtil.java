//package com.studies.mall.common.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author yangfan
// * @description
// *
// * Jwt生成的工具类
// * JWT的格式：header.payload.signature
// * header的格式（算法、token的类型）：
// * {"alg": "HS512","typ": "JWT"}
// * payload的格式（用户名、创建时间、生成时间）：
// * {"sub":"wang","created":1489079981393,"exp":1489684781}
// * signature的生成算法：
// * (base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
// */
//
//@Component
//@Slf4j
//public class JwtTokenUtil {
//    //用户名
//    private static final String CLAIM_KEY_USERNAME = "sub";
//    //生成时间
//    private static final String CLAIM_KEY_CREATED = "created";
//    //jwt密钥
//    @Value("${jwt.secret}")
//    private String secret;
//    //jwt过期时间
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//    /**
//     * 根据负责生成JWT的token
//     *  subject    主体,即用户信息的JSON
//     *  issuer     签发人
//     *  claims     自定义参数
//     */
//    private String generateToken(Map<String, Object> claims) {
//        return Jwts.builder()
//                // 自定义属性
//                .setClaims(claims)
//                // 过期时间
//                .setExpiration(generateExpirationDate())
//                // 签名算法以及密匙
//                .signWith(SignatureAlgorithm.HS512, secret)
//                // 主题：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
//                //.setSubject(subject)
//                // 签发人
//                //.setIssuer(Optional.ofNullable(issuer).orElse(ISS))
//                .compact();
//    }
//
//    /**
//     * 从token中获取JWT中的负载
//     */
//    private Claims getClaimsFromToken(String token) {
//        Claims claims = null;
//        try {
//            claims = Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (Exception e) {
//            log.info("JWT格式验证失败:{}",token);
//        }
//        return claims;
//    }
//
//    /**
//     * 生成token的过期时间
//     */
//    private Date generateExpirationDate() {
//        return new Date(System.currentTimeMillis() + expiration * 1000);
//    }
//
//    /**
//     * 从token中获取登录用户名
//     */
//    public String getUserNameFromToken(String token) {
//        String username;
//        try {
//            Claims claims = getClaimsFromToken(token);
//            username =  claims.getSubject();
//        } catch (Exception e) {
//            username = null;
//        }
//        return username;
//    }
//
//    /**
//     * 验证token是否还有效
//     *
//     * @param token       客户端传入的token
//     * @param userDetails 从数据库中查询出来的用户信息
//     */
//    public boolean validateToken(String token, UserDetails userDetails) {
//        String username = getUserNameFromToken(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    /**
//     * 判断token是否已经失效
//     */
//    private boolean isTokenExpired(String token) {
//        Date expiredDate = getExpiredDateFromToken(token);
//        return expiredDate.before(new Date());
//    }
//
//    /**
//     * 从token中获取过期时间
//     */
//    private Date getExpiredDateFromToken(String token) {
//        Claims claims = getClaimsFromToken(token);
//        return claims.getExpiration();
//    }
//
//    /**
//     * 根据用户信息生成token
//     * @param userDetails  自定义参数
//     *
//     */
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }
//
//    /**
//     * 判断token是否可以被刷新
//     */
//    public boolean canRefresh(String token) {
//        return !isTokenExpired(token);
//    }
//
//    /**
//     * 刷新token
//     */
//    public String refreshToken(String token) {
//        Claims claims = getClaimsFromToken(token);
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }
//}
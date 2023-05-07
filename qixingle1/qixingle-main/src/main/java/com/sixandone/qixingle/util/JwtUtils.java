package com.sixandone.qixingle.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName yk
 * @Descprition:生成jwt
 * @Autor DELL
 * @Date 2023/5/3 9:44
 **/
@Slf4j
public class JwtUtils {

    private static final String secret="pblcourse";//密钥，可通过微信接口获取

    /**
     * token生成器
     * @param userId
     * @param userName
     * @param authList
     * @return token
     */
    public String createJwt(Integer userId, String userName, List<String> authList){
        Date issDate = new Date();//签发时间
        Date expireDate = new Date(issDate.getTime()+1000*60*60*24);
        //头部
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg","HS256");//加密算法：待定
        headerClaims.put("typ","JWT");
        return JWT.create().withHeader(headerClaims)
                .withIssuer("qixingle") //设置签发人
                .withIssuedAt(issDate) //签发时间
                .withExpiresAt(expireDate) //设置过期时间
                .withClaim("userId",userId)
                .withClaim("userName",userName)//自定义声明
                .withClaim("userAuth",authList)
                .sign(Algorithm.HMAC256(secret)); //使用HS256进行签名
    }

    /**
     * token校验器
     * @param jwtToken
     * @return true：校验成功 false：校验失败
     */
    public boolean verifyToken(String jwtToken){
        //创建校验器
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(jwtToken);
//            Integer userId = decodedJWT.getClaim("userId").asInt();
//            String userName = decodedJWT.getClaim("userName").asString();
//            List<String> userAuth = decodedJWT.getClaim("userAuth").asList(String.class);
            log.info("token verify successfully");
            return true;
        } catch (IllegalArgumentException e) {
            log.error("token verify",e);
            return false;
        } catch (JWTVerificationException e) {
            log.error("token verify",e);
            return false;
        }
    }

    /**
     * 从token中获取userid
     * @param jwtToken
     * @return -1：获取失败 正整数：userId
     */
    public Integer getUserIdFromToken(String jwtToken){
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            decodedJWT = jwtVerifier.verify(jwtToken);
        } catch (Exception e) {
            log.error("token verify",e);
            return -1;
        }
        Integer userId = decodedJWT.getClaim("userId").asInt();
        return userId;
    }

    /**
     * 从token中获取用户名
     * @param jwtToken
     * @return 空：获取失败 不为空：userName
     */
    public String getUserNameFromToken(String jwtToken){
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            decodedJWT = jwtVerifier.verify(jwtToken);
        } catch (Exception e) {
            log.error("token verify",e);
            return "";
        }
        String userName = decodedJWT.getClaim("userName").asString();
        return userName;
    }

    /**
     * 从token中获取权限
     * @param jwtToken
     * @return null：获取失败 List<String>；userAuth
     */
    public List<String> getUserAuthFromToken(String jwtToken){
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            decodedJWT = jwtVerifier.verify(jwtToken);
        } catch (Exception e) {
            log.error("token verify",e);
            return null;
        }
        List<String> userAuth = decodedJWT.getClaim("userAuth").asList(String.class);
        return userAuth;
    }


}

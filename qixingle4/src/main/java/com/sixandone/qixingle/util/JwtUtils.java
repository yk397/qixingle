package com.sixandone.qixingle.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sixandone.qixingle.vo.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassName yk
 * @Descprition:token工具类，用于生成token，解析touken，获取token中携带的信息
 * @Autor DELL
 * @Date 2023/5/3 9:44
 **/
@Slf4j
@Component
public class JwtUtils {

    @Value("${JWT.secret}")
    private String secret;

    @Value("${JWT.expiration}")
    private long expiration;

    /**
     * token生成器
     * @param userOpenId
     * @param authList
     * @return token
     */
    public String createJwt(String userOpenId,List<String> authList){
        Date issDate = new Date();//签发时间
        Date expireDate = new Date(issDate.getTime()+1000*expiration*24);
        //头部
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg","HS256");//加密算法：待定
        headerClaims.put("typ","JWT");
        return JWT.create().withHeader(headerClaims)
                .withIssuer("qixingle") //设置签发人
                .withIssuedAt(issDate) //签发时间
                .withExpiresAt(expireDate) //设置过期时间
                .withClaim("userOpenId",userOpenId)
                .withClaim("userAuth",authList)
                .sign(Algorithm.HMAC256(secret)); //使用HS256进行签名
    }

    /**
     * 生成token
     * @param securityUser 安全用户
     * @return token
     */
    public String createJwt(SecurityUser securityUser,List<String> authList){
        //头部
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg","HS256");//加密算法
        headerClaims.put("typ","JWT");
        //自定义声明
        Map<String, Object> auth = new HashMap<>(2);
        auth.put("openId",securityUser.getSysUser().getOpenid());
        auth.put("userName",securityUser.getUsername());

        Date issDate = new Date();//签发时间
        Date expireDate = new Date(issDate.getTime()+expiration*1000);
        return JWT.create().withHeader(headerClaims)
                .withIssuer("qixingle") //设置签发人
                .withIssuedAt(issDate) //签发时间
                .withExpiresAt(expireDate) //设置过期时间
                .withClaim("userInfo",auth)
                .withClaim("authList",authList)
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

    public Map<String,Object> getUserInfo(String jwtToken){
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(jwtToken);
            Map<String, Object> userInfo = decodedJWT.getClaim("userInfo").asMap();
            log.info("token verify successfully");
            return userInfo;
        } catch (IllegalArgumentException e) {
            log.error("token verify",e);
            return null;
        } catch (JWTVerificationException e) {
            log.error("token verify",e);
            return null;
        }

    }


    /**
     * 从token中获取openid
     * @param jwtToken token
     * @return openid
     */
    public String getUserOpenId(String jwtToken){
        DecodedJWT decodedJWT = null;
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            decodedJWT = jwtVerifier.verify(jwtToken);
        } catch (Exception e) {
            log.error("token verify",e);
            return null;
        }
        String openid = decodedJWT.getClaim("userOpenId").asString();
        return openid;
    }


    /**
     * 从token中获取权限
     * @param jwtToken token
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

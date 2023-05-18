package com.sixandone.qixingle.controller;

import com.sixandone.qixingle.util.json.JsonUtils;
import com.sixandone.qixingle.vo.HttpResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName yk
 * @Descprition: 返回值处理
 * @Autor DELL
 * @Date 2023/5/18 15:02
 **/
@RestControllerAdvice(basePackages = "com.sixandone.qixingle.controller")
public class ResponseAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            return JsonUtils.toJson(HttpResult.success(body));
        }
        if (body instanceof HttpResult) {
            return body;
        }
        if (body instanceof ResponseEntity) {
            return body;
        }
        return HttpResult.success(body);
    }
}

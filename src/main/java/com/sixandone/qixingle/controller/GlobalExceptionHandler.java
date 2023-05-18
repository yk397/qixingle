package com.sixandone.qixingle.controller;

import com.sixandone.qixingle.exception.rentException;
import com.sixandone.qixingle.vo.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName yk
 * @Descprition: 全局异常处理
 * @Autor DELL
 * @Date 2023/5/16 22:51
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理rentException 业务异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e  异常
     * @return responseEntity
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error("服务错误",e);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }




    /**
     * 处理rentException 业务异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e  异常
     * @return responseEntity
     */
    @ExceptionHandler(value = rentException.class)
    public HttpResult rentExceptionHandler(HttpServletRequest httpServletRequest, rentException e) {
        logger.info("业务异常。code:"+e.getErrorCode().geCode()+"msg"+e.getErrorCode().getDescription());
        return HttpResult.builder()
                .code(e.getErrorCode().geCode())
                .msg(e.getDescreption())
                .data(null)
                .build();
    }

}

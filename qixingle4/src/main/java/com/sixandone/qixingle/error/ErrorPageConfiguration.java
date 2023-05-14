package com.sixandone.qixingle.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * @ClassName yk
 * @Descprition:配置错误状态与默认访问路径
 * @Autor DELL
 * @Date 2023/5/10 11:14
 **/
public class ErrorPageConfiguration implements ErrorPageRegistrar {

    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        errorPageRegistry.addErrorPages(
                new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500")
        );
    }

}

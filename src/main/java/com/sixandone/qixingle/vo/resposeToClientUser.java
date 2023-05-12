package com.sixandone.qixingle.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName yk
 * @Descprition:TODO
 * @Autor DELL
 * @Date 2023/5/2 9:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class resposeToClientUser {
    private String token;
    private Object session;

}

package com.sixandone.qixingle.controller;

import com.sixandone.qixingle.util.json.JsonUtils;
import com.sixandone.qixingle.vo.resposeToClientBicycle;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class resourcesControllerTest {
    public static void main(String[] args) {
        List<resposeToClientBicycle> list = new ArrayList<>();
        final BigDecimal bigDecimal = new BigDecimal(90.3283);
        final DecimalFormat decimalFormat = new DecimalFormat("0.00");

        for (int i = 0; i < 3; i++) {
            list.add(new resposeToClientBicycle("bifehifje","brand",decimalFormat.format(bigDecimal),"feafae","fawefa","fefa"));
        }
        System.out.println(JsonUtils.toJson(list));
    }

}
package com.exercise.mysys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.GenericArrayType;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
public class anycontroller {
    @RequestMapping("/p")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值
    public String update(int a) {
        System.out.println("get");
        if(a>3)
            return "false";
        else
            return "true";
    }
}
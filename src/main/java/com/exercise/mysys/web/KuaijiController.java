package com.exercise.mysys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
public class KuaijiController {
    @RequestMapping(value = "/huokuan", method = RequestMethod.GET)
    public String huokuan() {
        return "huokuan";
    }

    @RequestMapping(value = "/yufukuan", method = RequestMethod.GET)
    public String yufukuan() {
        return "yufukuan";
    }

    @RequestMapping(value = "/yufukuan", method = RequestMethod.GET)
    public String tuihuo() {
        return "tuihuo";
    }



}

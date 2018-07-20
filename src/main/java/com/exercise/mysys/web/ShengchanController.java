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
@RequestMapping(value = "shengchan")
public class ShengchanController {
    @RequestMapping(value = "/bumen", method = RequestMethod.GET)
    public String bumen() {
        return "bumen";
    }

    @RequestMapping(value = "/jihua", method = RequestMethod.GET)
    public String jihua() {
        return "jihua";
    }

    @RequestMapping(value = "/dingdan", method = RequestMethod.GET)
    public String dingdan() {
        return "dingdan";
    }

    @RequestMapping(value = "/kucun", method = RequestMethod.GET)
    public String kucun() {
        return "kucun";
    }

}

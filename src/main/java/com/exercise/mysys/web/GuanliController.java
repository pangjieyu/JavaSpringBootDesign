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
@RequestMapping("/guanli")
public class GuanliController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String guanli() {
        return "/index/index_boss.html";
    }
    @RequestMapping(value = "/kucun", method = RequestMethod.GET)
    public String kucun() {
        return "kucun";
    }

    @RequestMapping(value = "/dingdan", method = RequestMethod.GET)
    public String dingdan() {
        return "dingdan";
    }

    @RequestMapping(value = "/tuidan", method = RequestMethod.GET)
    public String tuidan() {
        return "tuidan";
    }

    @RequestMapping(value = "/caiwu", method = RequestMethod.GET)
    public String caiwu() {

        return "caiwu";
    }

    @RequestMapping(value = "/jihua", method = RequestMethod.GET)
    public String jihua() {
        return "jihua";
    }
}

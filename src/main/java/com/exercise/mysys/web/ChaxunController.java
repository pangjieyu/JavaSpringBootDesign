package com.exercise.mysys.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/22
 */
@RequestMapping("/chaxun")
public class ChaxunController {
    @GetMapping("/kucun")
    public String kucun() {
        return "/chaxun/chaxun_kucun";
    }
    @GetMapping("/dingdan")
    public String dingdan() {
        return "/chaxun/chaxun_dingdan";
    }
    @GetMapping("/tuidan")
    public String tuidan() {
        return "/chaxun/chaxun_tuidan";
    }
    @GetMapping("/shengchan")
    public String shengchan() {
        return "/chaxun/chaxun_shengchan";
    }
}

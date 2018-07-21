package com.exercise.mysys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
@RequestMapping("/chuna")
public class ChunaController {
    @RequestMapping(value = "/tuikuan", method = RequestMethod.GET)
    public String tuikuan() {
        return "tuikuan";
    }
}

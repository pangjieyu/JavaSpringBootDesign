package com.exercise.mysys.web;

import com.exercise.mysys.domain.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
public class StaticPagesController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String home() {

        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if(nowUser.getRole().equals("boss"))
            return "index/index_boss";
        else if(nowUser.getRole().equals("admin"))
            return "redirect:/users";
        return "index";
    }

    @RequestMapping(value = "/shouye", method = RequestMethod.GET)
    public String shouye() {
        return "shouye";
    }
}

package com.exercise.mysys.web;

import com.exercise.mysys.domain.SysUser;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
public class StaticPagesController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {

        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if(!nowUser.isEffective()) {
            return "redirect:/login?logout";
        }
        if(nowUser.getRole().equals("boss"))
            return "index/index_boss";
        else if(nowUser.getRole().equals("admin"))
            return "redirect:/admin";
        else if(nowUser.getRole().equals("仓库部门"))
            return "redirect:/cangku";
        else if(nowUser.getRole().equals("财务出纳部"))
            return "redirect:/chuna";
        else if(nowUser.getRole().equals("生产部门"))
            return "redirect:/shengchan";
        else if(nowUser.getRole().equals("财务会计部"))
            return "redirect:/kuaiji";
        else if(nowUser.getRole().equals("生产计划部门"))
            return "redirect:/jihua";
        else if(nowUser.getRole().equals("销售部门"))
            return "redirect:/xiaoshou";
        return "index";
    }

    @RequestMapping(value = "/shouye", method = RequestMethod.GET)
    public String shouye(Model model) {
        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("name",nowUser.getName());
        return "shouye";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "index/index_sys";
    }

    @RequestMapping(value = "/cangku", method = RequestMethod.GET)
    public String cangku() {
        return "index/index_store";
    }
}

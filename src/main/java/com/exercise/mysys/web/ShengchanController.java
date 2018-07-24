package com.exercise.mysys.web;

import com.exercise.mysys.dao.GoodRepository;
import com.exercise.mysys.dao.ManufacturePlanRepository;
import com.exercise.mysys.domain.Good;
import com.exercise.mysys.domain.ManufacturePlan;
import com.exercise.mysys.domain.SysUser;
import com.exercise.mysys.domain.Voucher;
import com.exercise.mysys.service.findServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
@RequestMapping(value = "/shengchan")
public class ShengchanController {
    @Autowired
    private ManufacturePlanRepository manufacturePlanRepository;
    @Autowired
    private GoodRepository goodRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String shengchan() {
        return "index/index_shengchan";
    }

    @RequestMapping(value = "/jihua", method = RequestMethod.GET)
    public String jihua() {
        return "index/index_jihua";
    }

    //查询生产计划
    @GetMapping("/shengchan")
    public String shengchan(Model model) {
        model.addAttribute("shengchanList", findServices.findManufacturePlan("",""));
        return "shengchan/shengchan";
    }
    @PostMapping("/shengchan")
    public String findShengchan(HttpServletRequest request, Model model) {
        System.out.println("time:"+request.getParameter("time"));
        model.addAttribute("shengchanList", findServices.findManufacturePlan(request.getParameter("goodname"),request.getParameter("time")));
        return "shengchan/shengchan";
    }
    @GetMapping("/xiugaishengchanjihua")
    public String add() {
        return "shengchan/shengchan_xiugai";
    }


    @PostMapping("/xiugaishengchanjihua")
    @ResponseBody
    public String xiugaishengchanjihua(HttpServletRequest request)
    {
        try {
            ManufacturePlan manufacturePlan = manufacturePlanRepository.findManufacturePlanById(
                    Long.parseLong(request.getParameter("id").trim())
            );
            if (manufacturePlan == null){
                return "该生产计划不存在";
            }
            manufacturePlan.setEffective(false);
            manufacturePlanRepository.save(manufacturePlan);
            return "true";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "操作失败";
        }
    }
}

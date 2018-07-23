package com.exercise.mysys.web;

import com.exercise.mysys.dao.GoodRepository;
import com.exercise.mysys.dao.ManufacturePlanRepository;
import com.exercise.mysys.domain.Good;
import com.exercise.mysys.domain.ManufacturePlan;
import com.exercise.mysys.domain.SysUser;
import com.exercise.mysys.domain.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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

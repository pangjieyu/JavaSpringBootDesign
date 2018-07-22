package com.exercise.mysys.web;

import com.exercise.mysys.dao.*;
import com.exercise.mysys.domain.Store;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/22
 */
@Controller
@RequestMapping("/chaxun")
public class ChaxunController {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private OrderGoodRepository orderGoodRepository;
    @Autowired
    private ReturnGoodRepository returnGoodRepository;
    @Autowired
    private ManufacturePlanRepository manufacturePlanRepository;
    @Autowired
    private CustomerRepository customerRepository;

    //查询库存
    @GetMapping("/kucun")
    public String kucun(Model model) {
        model.addAttribute("kucunList", storeRepository.findAll());
        return "chaxun/chaxun_kucun";
    }

    //查询订单
    @GetMapping("/dingdan")
    public String dingdan(Model model) {
        model.addAttribute("orderList", orderGoodRepository.findAll());
        return "chaxun/chaxun_dingdan";
    }

    //查询退单
    @GetMapping("/tuidan")
    public String tuidan(Model model) {
        model.addAttribute("returnList", returnGoodRepository.findAll());
        return "chaxun/chaxun_tuidan";
    }

    //查询生产计划
    @GetMapping("/shengchan")
    public String shengchan(Model model) {
        model.addAttribute("shengchanList", manufacturePlanRepository.findAll());
        return "chaxun/chaxun_shengchan";
    }

    //查询客户信息
    @GetMapping("/kehu")
    public String kehu(Model model) {
        model.addAttribute("kuhuList", customerRepository.findAll());
        return "chaxun/chaxun_kehu";
    }
}

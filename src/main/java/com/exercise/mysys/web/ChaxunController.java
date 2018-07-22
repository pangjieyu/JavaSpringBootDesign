package com.exercise.mysys.web;

import com.exercise.mysys.dao.ManufacturePlanRepository;
import com.exercise.mysys.dao.OrderGoodRepository;
import com.exercise.mysys.dao.ReturnGoodRepository;
import com.exercise.mysys.dao.StoreRepository;
import com.exercise.mysys.domain.Store;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/kucun")
    public String kucun(Model model) {
        model.addAttribute("kucunList", storeRepository.findAll());
        return "/chaxun/chaxun_kucun";
    }

    @GetMapping("/dingdan")
    public String dingdan(Model model) {
        model.addAttribute("orderList", orderGoodRepository.findAll());
        return "/chaxun/chaxun_dingdan";
    }

    @GetMapping("/tuidan")
    public String tuidan(Model model) {
        model.addAttribute("returnList", returnGoodRepository.findAll());
        return "/chaxun/chaxun_tuidan";
    }

    @GetMapping("/shengchan")
    public String shengchan(Model model) {
        model.addAttribute("shengchanList", manufacturePlanRepository.findAll());
        return "/chaxun/chaxun_shengchan";
    }
}

package com.exercise.mysys.web;

import com.exercise.mysys.dao.GoodRepository;
import com.exercise.mysys.domain.Good;
import com.exercise.mysys.service.findServices;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/23
 */
@Controller
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("/chaxun")
    public String goods(Model model) {
        model.addAttribute("goodList", goodRepository.findAll());
        return "thing/thing_chaxun";
    }

    @PostMapping("/chaxun")
    public String findgood(HttpServletRequest request, Model model) {

        model.addAttribute("goodList", goodRepository.myFind(request.getParameter("name").trim()));
        return "thing/thing_chaxun";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable String id, Model model) {
        model.addAttribute("good", goodRepository.findGoodById(Long.parseLong(id)));
        return "thing/thing_xiugai";
    }
    @PostMapping("/edit/{id}")
    public String editGood(@PathVariable String id, HttpServletRequest request, Model model) {
        Good good = goodRepository.findGoodById(Long.parseLong(id.trim()));
        good.setName(request.getParameter("name").trim());
        good.setPrice(Integer.parseInt(request.getParameter("danjia").trim()));
        good.setUnit(request.getParameter("danwei").trim());
        good.setGuarantee(Integer.parseInt(request.getParameter("baozhi")));
        good.setLower_limit(Integer.parseInt(request.getParameter("xiaxian")));
        goodRepository.save(good);
        model.addAttribute("goodList",goodRepository.findGoodById(good.getId()));
        return "thing/thing_chaxun";
    }

}

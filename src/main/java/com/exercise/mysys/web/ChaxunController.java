package com.exercise.mysys.web;

import com.exercise.mysys.dao.*;
import com.exercise.mysys.domain.Customer;
import com.exercise.mysys.domain.Good;
import com.exercise.mysys.domain.SysUser;
import com.exercise.mysys.domain.Voucher;
import com.exercise.mysys.service.findServices;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private SysUserRepository userRepository;
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private GoodRepository goodRepository;
    //查询库存
    @GetMapping("/kucun")
    public String kucun(Model model) {
        model.addAttribute("kucunList", findServices.findGood());
        return "chaxun/chaxun_kucun";
    }
    @PostMapping("/kucun")
    public String findGood(Model model, HttpServletRequest request) {
        model.addAttribute("kucunList", findServices.findGood(request.getParameter("goodname").trim()));
        return "chaxun/chaxun_kucun";
    }

    //查询订单
    @GetMapping("/dingdan")
    public String dingdan(Model model) {
        model.addAttribute("orderList", findServices.findOrder("",""));
        return "chaxun/chaxun_dingdan";
    }

    //查询退单
    @GetMapping("/tuidan")
    public String tuidan(Model model) {
        model.addAttribute("returnList", findServices.findReturn("",""));
        return "chaxun/chaxun_tuidan";
    }
    @PostMapping("/tuidan")
    public String findtuidan(HttpServletRequest request, Model model) {
        model.addAttribute("returnList", findServices.findReturn(request.getParameter("kehu").trim(),request.getParameter("yuangong").trim()));
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
        model.addAttribute("kehuList", customerRepository.findAll());
        return "chaxun/chaxun_kehu";
    }
    @PostMapping("/kehu")
    public String findKehu(HttpServletRequest request, Model model) {
        List<Customer> list = customerRepository.myFind(request.getParameter("name").trim());
        model.addAttribute("kehuList",list);
        return "chaxun/chaxun_kehu";
    }

    //查询商品信息
    @GetMapping("/thing")
    public String thing(Model model) {
        model.addAttribute("thingList", goodRepository.findAll());
        return "chaxun/chaxun_thing";
    }
    @PostMapping("/thing")
    public String findThing(HttpServletRequest request, Model model) {
        List<Good> list = goodRepository.myFind(request.getParameter("name").trim());
        model.addAttribute("thingList",list);
        return "chaxun/chaxun_thing";
    }

    //查询员工信息
    @GetMapping("/yuangong")
    public String yuangong(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "chaxun/chaxun_yuangong";
    }
    @RequestMapping(value = "/yuangong", method = RequestMethod.POST)
    public String chazhao(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String bumen = request.getParameter("bumen");
        List<SysUser> list;
        if(name.equals("")) {
            list = userRepository.findAllByRole(bumen);
        }else {
            list = userRepository.myFind(bumen, name);
        }
        model.addAttribute("userList",list);
        return "chaxun/chaxun_yuangong";
    }

    //查询凭证
    @GetMapping("/pingzheng")
    public String pingzheng(Model model) {
        List<Voucher> list = voucherRepository.findAll();
        model.addAttribute("pingzhengList",list);
        return "chaxun/chaxun_pingzheng";
    }

    //查询入库
    @GetMapping("/ruku")
    public String ruku(Model model) {
        return "chaxun/chaxun_ruku";
    }

    //查询出库
    @GetMapping("/chuku")
    public String chuku(Model model) {
        return "chaxun/chaxun_chuku";
    }

    //查询提货
    @GetMapping("/tihuo")
    public String tihuo(Model model) {
        return "chaxun/chaxun_tihuo";
    }
}

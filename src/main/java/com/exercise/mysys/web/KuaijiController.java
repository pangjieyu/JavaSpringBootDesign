package com.exercise.mysys.web;

import com.exercise.mysys.dao.CustomerRepository;
import com.exercise.mysys.dao.OrderGoodRepository;
import com.exercise.mysys.dao.ReturnGoodRepository;
import com.exercise.mysys.dao.VoucherRepository;
import com.exercise.mysys.domain.*;
import com.exercise.mysys.service.findServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
@RequestMapping(value = "/kuaiji")
public class KuaijiController {
    @Autowired
    private VoucherRepository voucherRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderGoodRepository orderGoodRepository;
    @Autowired
    private ReturnGoodRepository returnGoodRepository;

    @GetMapping("")
    public String indexKuaiji() {
        return "index/index_kuaiji";
    }


    @GetMapping("/addVoucher")
    public String add() {
        return "kuaiji/kuaiji_sc";
    }

    @GetMapping("/addVoucherQ")
    public String addHaHaHa(){
        return "kuaiji/kuaiji_qk";
    }

    //查询凭证
    @GetMapping("/pingzheng")
    public String pingzheng(Model model) {
        model.addAttribute("pingzhengList",findServices.findVoucher("",""));
        return "kuaiji/pingzheng";
    }
    @PostMapping("/pingzheng")
    public String findPingzheng(HttpServletRequest request, Model model) {
        model.addAttribute("pingzhengList",findServices.findVoucher(request.getParameter("customerName").trim(),request.getParameter("type").trim()));
        return "kuaiji/pingzheng";
    }
    //生成凭证
    @RequestMapping(value = "/addVoucher", method = RequestMethod.POST)
    @ResponseBody
    public String addVoucher(HttpServletRequest request) throws ParseException {
        try {
            //创建一个凭证类
            Voucher voucher = new Voucher();
            //凭证设为有效
            voucher.setEffective(true);
            //设置交易是付完整
            voucher.setReceivable(false);
            //客户类
            Customer customer = customerRepository.findCustomerById(Long.parseLong(
                    request.getParameter("customer_id").trim()));
            //System.out.println(customer.getName());
            if (customer == null){
                return "没有该客户";
            }
            String customer_name = request.getParameter("customer_name").trim();
            if (!customer_name.equals(customer.getName())) {
                return "客户的编号和姓名不一致";
            }
            //设置客户编号
            voucher.setCustomer_id(Long.parseLong(
                    request.getParameter("customer_id").trim()));
            //设置金额
            voucher.setMoney(Integer.parseInt(request.getParameter("money").trim()));
            //设置凭证类型
            voucher.setType(request.getParameter("type").trim());
            //保存
            voucherRepository.save(voucher);
            //返回
            return "true";
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "操作失败";
        }
    }
    //查询订单
    @GetMapping("/dingdan")
    public String dingdan(Model model) {
        model.addAttribute("orderList", findServices.findOrder("",""));
        return "kuaiji/dingdan";
    }

    @PostMapping("/dingdan")
    public String finddingdan(HttpServletRequest request, Model model) {
        model.addAttribute("orderList", findServices.findOrder(request.getParameter("kehu").trim(),request.getParameter("yuangong").trim()));
        return "kuaiji/dingdan";
    }
    //修改订单
    @PostMapping("/addVoucher/updateDingdan")
    @ResponseBody
    public String updateDingdan(HttpServletRequest request){
        try {
            OrderGood orderGood = orderGoodRepository.findOrderGoodById(Long.parseLong(
                    request.getParameter("id").trim()
            ));
            if (orderGood == null){
                return "没有该订单";
            }
            if (!orderGood.getEffective()) {
                return "该订单无效";
            }
            orderGood.setPayment(request.getParameter("payment").trim());
            orderGoodRepository.save(orderGood);
            return "true";
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "操作失败";
        }
    }

    @PostMapping("/addVoucher/updatePingzheng")
    @ResponseBody
    public String updatePingzheng(HttpServletRequest request){
        try {
            Voucher voucher = voucherRepository.findVoucherById(Long.parseLong(request.getParameter("id").trim()));
            if (voucher == null){
                return "没有该凭证";
            }
            if (voucher.getType().equals("取款")){
                return "该凭证不是收款凭证";
            }
            voucher.setEffective(false);
            voucherRepository.save(voucher);
            return "true";
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "操作失败";
        }
    }

    //查询退单
    @GetMapping("/tuidan")
    public String tuidan(Model model) {
        model.addAttribute("returnList", findServices.findReturn("",""));
        return "kuaiji/tuidan";
    }
    @PostMapping("/tuidan")
    public String findtuidan(HttpServletRequest request, Model model) {
        model.addAttribute("returnList", findServices.findReturn(request.getParameter("kehu").trim(),request.getParameter("yuangong").trim()));
        return "kuaiji/tuidan";
    }
    @PostMapping("/addVoucher/updateTuihuodan")
    @ResponseBody
    public String updateTuihuodan(HttpServletRequest request){
        System.out.println(request.getParameter("id").trim());
        try{
            ReturnGood returnGood = returnGoodRepository.findReturnGoodById(
                    Long.parseLong(request.getParameter("id").trim())
            );
            if (returnGood == null){
                return "没有该退货单";
            }
            returnGood.setEffective(false);
            returnGoodRepository.save(returnGood);
            return "true";
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "操作失败";
        }
    }
}

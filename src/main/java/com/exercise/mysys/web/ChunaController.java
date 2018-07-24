package com.exercise.mysys.web;

import com.exercise.mysys.dao.VoucherRepository;
import com.exercise.mysys.domain.Voucher;
import com.exercise.mysys.service.findServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
@RequestMapping("/chuna")
public class ChunaController {
    @Autowired
    private VoucherRepository voucherRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String chuna() {
        return "index/index_chuna";
    }

    @RequestMapping(value = "/tuikuan", method = RequestMethod.GET)
    public String tuikuan() {
        return "chuna/chuna_xiugai";
    }

    //查询凭证
    @GetMapping("/pingzheng")
    public String pingzheng(Model model) {
        model.addAttribute("pingzhengList",findServices.findVoucher("","",3,4));
        return "chuna/pingzheng";
    }
    @PostMapping("/pingzheng")
    public String findPingzheng(HttpServletRequest request, Model model) {
        model.addAttribute("pingzhengList",findServices.findVoucher(request.getParameter("customerName").trim(),request.getParameter("type").trim(),Integer.parseInt(request.getParameter("buton1")),Integer.parseInt(request.getParameter("button2"))));
        return "chuna/pingzheng";
    }
    @PostMapping("/xiugaipingzheng")
    @ResponseBody
    //修改交易是否完成标记
    public String xiugaipingzheng(HttpServletRequest request)
    {
        try {
            Voucher voucher = voucherRepository.findVoucherById(Long.parseLong(
                    request.getParameter("id").trim()
            ));
            if (voucher == null){
                return "该凭证不存在";
            }
            if (!voucher.getEffective()){
                return "该凭证无效";
            }
            voucher.setReceivable(true);
            voucherRepository.save(voucher);
            return "true";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "操作失败";
        }
    }

    @PostMapping("/xiugaituikuanpingzheng")
    @ResponseBody
    public String xiugaituikuanpingzheng(HttpServletRequest request)
    {
        try {
            Voucher voucher = voucherRepository.findVoucherById(Long.parseLong(
                    request.getParameter("id")
            ));
            if (voucher == null){
                return "该凭证不存在";
            }
            if (voucher.getType().equals("收款")){
                return "该凭证是收款凭证，您无权销毁";
            }
            voucher.setEffective(false);
            voucherRepository.save(voucher);
            return "true";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "操作失败";
        }
    }
}

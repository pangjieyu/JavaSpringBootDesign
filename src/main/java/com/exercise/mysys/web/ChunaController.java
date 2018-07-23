package com.exercise.mysys.web;

import com.exercise.mysys.dao.VoucherRepository;
import com.exercise.mysys.domain.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping(value="chuna/xiugaipingzheng")
    @ResponseBody
    public String xiugaipingzheng(HttpServletRequest request)
    {
        Voucher voucher = new Voucher();
        voucher = voucherRepository.findVoucherById(Long.parseLong(request.getParameter("id")));
        voucher.setEffective(false);
        voucherRepository.save(voucher);
        return "sucess";
    }

    @PostMapping("chuna/xiugaituikuanpingzheng")
    @ResponseBody
    public String xiugaituikuanpingzheng(HttpServletRequest request)
    {

        Voucher voucher = null;
        voucher = voucherRepository.findVoucherById(Long.parseLong(request.getParameter("tuikuan")));
        voucher.setEffective(false);
        voucherRepository.save(voucher);
        return "sucess";
    }
}

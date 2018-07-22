package com.exercise.mysys.web;

import com.exercise.mysys.dao.VoucherRepository;
import com.exercise.mysys.domain.Voucher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
@RequestMapping("/chuna")
public class ChunaController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String chuna() {
        return "index/index_chuna";
    }

    @RequestMapping(value = "/tuikuan", method = RequestMethod.GET)
    public String tuikuan() {
        return "tuikuan";
    }

    @PostMapping(value="chuna/xiugaipingzheng")
    public String xiugaipingzheng(HttpServletRequest request)
    {
        VoucherRepository repo = null;
        Voucher voucher = null;
        voucher = repo.findOne(Long.parseLong(request.getParameter("id")));
        voucher.setEffective(false);
        repo.save(voucher);
        return "sucess";
    }

    @PostMapping("chuna/xiugaituikuanpingzheng")
    public String xiugaituikuanpingzheng(HttpServletRequest request)
    {

        VoucherRepository repo = null;
        Voucher voucher = null;
        voucher = repo.findOne(Long.parseLong(request.getParameter("id")));
        voucher.setEffective(false);
        repo.save(voucher);
        return "sucess";
    }
}

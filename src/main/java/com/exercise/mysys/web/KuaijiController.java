package com.exercise.mysys.web;

import com.exercise.mysys.dao.ReturnGoodRepository;
import com.exercise.mysys.dao.VoucherRepository;
import com.exercise.mysys.domain.ReturnGood;
import com.exercise.mysys.domain.Voucher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
public class KuaijiController {
    //@RequestMapping(value = "/huokuan", method = RequestMethod.GET)
//    public String huokuan() {
//
//        returrn "huokuan";
//    }

<<<<<<< Updated upstream
    @RequestMapping(value = "/tuihuo", method = RequestMethod.GET)
    public String tuihuo() {
        return "tuihuo";
    }
=======
//    @RequestMapping(value = "/yufukuan", method = RequestMethod.GET)
//    public String yufukuan(){
//        return "yufukuan";
//    }
>>>>>>> Stashed changes

//    @RequestMapping(value = "/yufukuan", method = RequestMethod.GET)
//    public String tuihuo() {
//
//        return "tuihuo";
//    }
//
//    @RequestMapping("/check_vouchers")
//    public List<Voucher> check_vouchers()
//    {
//        VoucherRepository repo = null;
//        return repo.findAll();
//    }
//
//    @RequestMapping("/check_returns")
//    public List<ReturnGood> check_returns()
//    {
//        ReturnGoodRepository repo = null;
//        return repo.findAll();
//    }

    

}

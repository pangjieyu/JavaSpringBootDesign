package com.exercise.mysys.web;

import com.exercise.mysys.dao.CustomerRepository;
import com.exercise.mysys.domain.Customer;
import com.exercise.mysys.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 19:39
 * @Description: 销售控制器
 */
@Controller
@RequestMapping("/xiaoshou")
public class XiaoShouController {
    private CustomerRepository customerRepository;
    //添加客户
    @RequestMapping(value = "/tianjiakehu", method = RequestMethod.POST)
    public String tianjiakehu(HttpServletRequest request){
            Customer customer = new Customer();
            customer.setName(request.getParameter("name"));
            customer.setRank(Long.parseLong(request.getParameter("rank")));
            customer.setTelephone(Long.parseLong(request.getParameter("telephone")));
            customerRepository.save(customer);
            
            return "redirect:/tianjiakehu";

    }
    @RequestMapping(value = "/tianjiakehu", method = RequestMethod.GET)
    public String kehupage(Model model){
        Msg msg = new Msg("标题", "添加客户成功", "无");
        model.addAttribute("msg", msg);
        return "tianjiakehu";
    }
    //修改客户
    public String xiugaikehu(){ return "xiugaikehu"; }
    //查询客户
    @RequestMapping(value = "/chaxunkehu", method = RequestMethod.GET)
    public String chaxunkehu(){
        return "chaxunkehu";
    }
    //折扣预付款
    @RequestMapping(value = "/折扣预付款", method = RequestMethod.GET)
    public String zhekouyufukuan(){ return "zhekouyufukuan"; }
    //修改订单
    @RequestMapping(value = "/xiugaidingdan", method = RequestMethod.GET)
    public String xiugaidingdan(){ return "xiugaidingdan"; }
    //退货单
    @RequestMapping(value = "/退货单", method = RequestMethod.GET)
    public String tuihuodan(){ return "tuihuodan"; }
    //订货单
    @RequestMapping(value = "/订货单", method = RequestMethod.GET)
    public String dinghuodan(){ return "dinghuodan"; }
    //提货单
    @RequestMapping(value = "/提货单", method = RequestMethod.GET)
    public String tihuodan(){ return "tihuodan"; }

}

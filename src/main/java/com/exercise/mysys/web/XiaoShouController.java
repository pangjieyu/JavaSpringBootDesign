package com.exercise.mysys.web;

import com.exercise.mysys.dao.*;
import com.exercise.mysys.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 19:39
 * @Description: 销售控制器
 */
@RequestMapping("/xiaoshou")
@Controller
public class XiaoShouController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    private ReturnGoodRepository returnGoodRepository;
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private OrderGoodRepository orderGoodRepository;
    @Autowired
    private PickRepository pickRepository;

    @GetMapping("")
    public String xiaoshouindex() {
        return "index/index_sale";
    }

    //填写退货单
    @RequestMapping(value="/tuihuo",method=RequestMethod.GET)
    public String tiantuihuodan()
    {
        return "sale/sale_tuidan";
    }



    //提货单页面
    @RequestMapping(value="tihuopage",method = RequestMethod.GET)
    public String tihuopage()
    {
        return "sale/sale_tihuo";
    }

    //添加商品页面
    @RequestMapping(value = "addgoodpage",method = RequestMethod.GET)
    public String addgoodpage()
    {
        return "thing/thing_tianjia";
    }
    //订货单页面
    @RequestMapping(value = "/dinghuopage",method = RequestMethod.GET)
    public String dinghuopage()
    {
        return "sale/sale_dingdan";
    }


    //填写退货单
    @PostMapping("/tuihuo")
    @ResponseBody
    public String makereturnlist(HttpServletRequest request) {
        try {
            ReturnGood returngood = new ReturnGood();
//            Long employeeid=Long.parseLong(request.getParameter("people").trim());
//
//            if(sysUserRepository.findSysUserById(employeeid) == null)
//                return "没有该雇员";
//            returngood.setEmployee_id(employeeid);

            SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            System.out.println(nowUser.getId());
            returngood.setEmployee_id(nowUser.getId());

            if(goodRepository.findGoodById(Long.parseLong(request.getParameter("id"))) == null)
                return "没有该商品";
            returngood.setGood_id(Long.parseLong(request.getParameter("id")));


            if(customerRepository.findCustomerById(Long.parseLong(request.getParameter("customer"))) == null)
                return "没有该用户";
            returngood.setCustomer_id(Long.parseLong(request.getParameter("customer")));

            returngood.setNumber(Integer.parseInt(request.getParameter("num")));
            returngood.setMoney(Integer.parseInt(request.getParameter("money2")));
            String str = request.getParameter("date");

            //Date date = new Date(str);
//        returngood.setCreatedate(D);
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(request.getParameter("date"));
            System.out.println(request.getParameter("date"));
            returngood.setCreatedate(date);
            returngood.setEffective(true);


            returnGoodRepository.save(returngood);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return "false";
        }
        return "true";
    }

    //处理订货
    @PostMapping("/dinghuo")
    @ResponseBody
    public String dinghuo(HttpServletRequest request)
    {
        try {
            OrderGood order = new OrderGood();
            //设置员工编号
//            Long employeeid = Long.parseLong(request.getParameter("people"));
//            if (sysUserRepository.findSysUserById(employeeid) == null)
//                return "员工不存在";
//            order.setEmployee_id(employeeid);
            SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            order.setEmployee_id(nowUser.getId());

            //设置商品编号
            Long goodid = Long.parseLong(request.getParameter("id"));
            if (goodRepository.findGoodById(goodid) == null)
                return "商品不存在";
            order.setGood_id(goodid);

            //设置客户编号
            Long customerid = Long.parseLong(request.getParameter("customer"));
            if(customerRepository.findCustomerById(customerid) == null)
                return "客户不存在";
            order.setCustomer_id(customerid);

            //设置商品数量
            int num = Integer.parseInt(request.getParameter("num"));
            order.setNumber(num);

            //设置预付款
            int deposit = Integer.parseInt(request.getParameter("money1"));
            order.setDeposit(deposit);

            //设置总金额
            int money = Integer.parseInt(request.getParameter("money2"));
            order.setMoney(money);

            //设置日期
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(request.getParameter("date"));
            System.out.println(request.getParameter("date"));
            order.setCreate_date(date);

            //设置有效
            order.setEffective(true);
            //设置未付款
            order.setPayment("未付款");

            //save一下
            orderGoodRepository.save(order);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return "false";
        }
        return "true";
    }

    //处理提货
    @RequestMapping(value = "tihuo",method = RequestMethod.POST)
    @ResponseBody
    public String tihuo(HttpServletRequest request)
    {
        try {
            Pick pick = new Pick();
            //写入员工编号
//            Long employeid = Long.parseLong(request.getParameter("people"));
//            if(sysUserRepository.findSysUserById(employeid) == null)
//                return "员工不存在";
//            pick.setEmployee_id(employeid);
            SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            pick.setEmployee_id(nowUser.getId());

            //写入商品编号
            Long goodid = Long.parseLong(request.getParameter("id"));
            if(goodRepository.findGoodById(goodid) == null)
                return "商品不存在";
            pick.setGood_id(goodid);
            //写入客户编号
            Long customerid = Long.parseLong(request.getParameter("customer"));
            if(customerRepository.findCustomerById(customerid) == null)
                return "客户编号为空";
            pick.setCustomer_id(customerid);
            //写入商品数量
            pick.setNumber(Integer.parseInt(request.getParameter("num")));
            //设置section
            pick.setSection(request.getParameter("date1")+"-"+request.getParameter("date2"));
            //设置日期
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(request.getParameter("date"));
            pick.setCreate_date(date);
            pick.setEffective(true);
            pickRepository.save(pick);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return "false";
        }
        return "true";
    }

    //处理添加商品
    @RequestMapping(value="/addgood",method = RequestMethod.POST)
    @ResponseBody
    public String addgood(HttpServletRequest request)
    {
        Good good = new Good();
        //设置名称
        good.setName(request.getParameter("name"));
        //设置单价
        good.setPrice(Integer.parseInt(request.getParameter("danjia")));
        //设置单位
        good.setUnit(request.getParameter("danwei"));
        //设置下限
        good.setLower_limit(Integer.parseInt(request.getParameter("xiaxian")));
        //设置保质期
        good.setGuarantee(Integer.parseInt(request.getParameter("baozhi")));

        goodRepository.save(good);
        return "true";
    }

}

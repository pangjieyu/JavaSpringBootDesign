package com.exercise.mysys.web;

import com.exercise.mysys.dao.CustomerRepository;
import com.exercise.mysys.dao.GoodRepository;
import com.exercise.mysys.dao.ReturnGoodRepository;
import com.exercise.mysys.dao.SysUserRepository;
import com.exercise.mysys.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("")
    public String xiaoshouindex() {
        return "index/index_sale";
    }

    //填写退货单
    @RequestMapping(value="/tuihuo",method=RequestMethod.GET)
    public String tiantuihuodan()
    {
        return "/sale/sale_tuidan";
    }


    //添加客户
    @RequestMapping(value = "/addCustomer",method = RequestMethod.GET)
    public String addCustomer() {
        return "customer/customer_tianjia";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    @ResponseBody
    public String addCustomer(HttpServletRequest request) throws ParseException {
        try {
            //新建一个客户类
            Customer customer = new Customer();
            //设置客户姓名
            String str = request.getParameter("name");
//            System.out.println(str + request.getParameter("t"));
            customer.setName(str);
            //设置手机号
            customer.setTelephone(Long.parseLong(request.getParameter("phone")));
            //设置地址
            customer.setAddress(request.getParameter("address"));
            //设置客户等级
            customer.setRank(Long.parseLong(request.getParameter("rank")));
            //保存
            System.out.println(customer.getId());
            System.out.println(customer.getName()+"  "+customer.getTelephone()+"  "+customer.getAddress()+"  "+customer.getRank());
            customerRepository.save(customer);
            //返回界面
        }
        catch (Exception e)
        {
            return "false";
        }
        return "true";
    }

    //修改客户
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable String id, HttpServletRequest request) throws ParseException {
        //新建一个客户类
        Customer customer = customerRepository.findCustomerById(Long.parseLong(id));
        //设置客户姓名
        customer.setName(request.getParameter("name"));
        //设置客户登记
        customer.setRank(Long.parseLong(request.getParameter("rank")));
        //设置客户手机号
        customer.setTelephone(Long.parseLong(request.getParameter("telephone")));
        //修改客户
        customerRepository.save(customer);
        return "redirect:/shouye";
    }

    //填写退货单
    @PostMapping("/tuihuo")
    @ResponseBody
    public String makereturnlist(HttpServletRequest request) {
        try {
            ReturnGood returngood = new ReturnGood();
            Long employeeid=Long.parseLong(request.getParameter("people").trim());

            if(sysUserRepository.findSysUserById(employeeid) == null)
                return "没有该雇员";
            returngood.setEmployee_id(employeeid);


            if(goodRepository.findGoodById(Long.parseLong(request.getParameter("id"))) == null)
                return "没有该商品";
            returngood.setGood_id(Long.parseLong(request.getParameter("id")));


            if(customerRepository.findCustomerById(Long.parseLong(request.getParameter("customer"))) == null)
                return "没有该用户";
            returngood.setCustomer_id(Long.parseLong(request.getParameter("customer")));

            returngood.setNumber(Integer.parseInt(request.getParameter("people")));
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
}

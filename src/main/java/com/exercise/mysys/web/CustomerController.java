package com.exercise.mysys.web;

import com.exercise.mysys.dao.CustomerRepository;
import com.exercise.mysys.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/21 16:25
 * @Description: 用户类的控制器
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //添加客户
    @RequestMapping(value = "/addCustomer",method = RequestMethod.GET)
    public String addCustomer() {
        return "customer/customer_tianjia";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String add(HttpServletRequest request) throws ParseException {
        //新建一个客户类
        Customer customer = new Customer();
        //设置客户姓名
        customer.setName(request.getParameter("name"));
        //设置手机号
        customer.setTelephone(Long.parseLong(request.getParameter("telephone")));
        //设置客户等级
        customer.setRank(Long.parseLong(request.getParameter("rank")));
        //保存
        customerRepository.save(customer);
        //返回界面
        return "redirect:/shouye";
    }
    //修改客户信息
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable Long id , Model model) {
        model.addAttribute("user",customerRepository.findCustomerById(id));
        return "editCustomer";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editCustomer(@PathVariable Long id, HttpServletRequest request) throws ParseException {
        //找到该用户
        Customer customer = customerRepository.findCustomerById(id);
        //设置姓名
        customer.setName(request.getParameter("name"));
        //设置手机号
        customer.setTelephone(Long.parseLong(request.getParameter("telephone")));
        //设置客户等级
        customer.setRank(Long.parseLong(request.getParameter("rank")));
        //保存
        customerRepository.save(customer);
        //返回首页
        return "redirect:/shouye";
    }
}

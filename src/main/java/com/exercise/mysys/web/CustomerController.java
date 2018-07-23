package com.exercise.mysys.web;

import com.exercise.mysys.dao.CustomerRepository;
import com.exercise.mysys.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/21 16:25
 * @Description: 用户类的控制器
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    //添加客户
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

}

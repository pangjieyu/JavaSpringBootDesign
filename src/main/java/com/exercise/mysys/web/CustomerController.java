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
@RequestMapping("/custommer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    //显示客户列表
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("customerList", customerRepository.findAll());
        return "customer/customer_kehu";
    }
    //添加客户
    @RequestMapping(value = "/addCustomer",method = RequestMethod.GET)
    public String addCustomer() {
        return "customer/customer_tianjia";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String add(HttpServletRequest request) throws ParseException {
        try {
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
        }
        catch (Exception e)
        {
            return "false";
        }
        return "true";
    }

}

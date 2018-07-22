package com.exercise.mysys.web;

import com.exercise.mysys.dao.CustomerRepository;
import com.exercise.mysys.dao.GoodRepository;
import com.exercise.mysys.domain.Customer;
import com.exercise.mysys.domain.Good;
import com.exercise.mysys.domain.Msg;
import com.exercise.mysys.domain.SysUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 19:39
 * @Description: 销售控制器
 */
@RequestMapping("/xiaoshou")
@Controller
public class XiaoShouController {
    private CustomerRepository customerRepository;
    private GoodRepository goodRepository;

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
    public String addCustomer(HttpServletRequest request) throws ParseException {
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

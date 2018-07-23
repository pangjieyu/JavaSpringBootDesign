package com.exercise.mysys.web;

import com.exercise.mysys.dao.CustomerRepository;
import com.exercise.mysys.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/23
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
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
    //查询客户
    @GetMapping("/find")
    public String kehu(Model model) {
        model.addAttribute("kehuList", customerRepository.findAll());
        return "customer/customer_chaxun";
    }
    @PostMapping("/find")
    public String findKehu(HttpServletRequest request, Model model) {
        List<Customer> list = customerRepository.myFind(request.getParameter("name").trim());
        model.addAttribute("kehuList",list);
        return "customer/customer_chaxun";
    }

    //修改客户
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable String id, Model model) {
        model.addAttribute("customer",customerRepository.findCustomerById(Long.parseLong(id.trim())));
        return "customer/customer_xiugai";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable String id, HttpServletRequest request, Model model) throws ParseException {
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
        model.addAttribute("kehuList",customerRepository.myFind(customer.getName()));
        return "customer/customer_chaxun";
    }

}

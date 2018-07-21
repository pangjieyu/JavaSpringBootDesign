package com.exercise.mysys.web;

import com.exercise.mysys.dao.SysUserRepository;
import com.exercise.mysys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
public class SysUserController {
    @Autowired
    private SysUserRepository userRepository;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "sys/sys_yuangong";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser() {
        return "sys/sys_tianjia";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String add(HttpServletRequest request) throws ParseException {
        /**
         * root
         * $2a$10$kke9EHzAFTKWJTQcTzFi0.IFlJmJLd6BhOtPKlAoq3iH9G.s3KAtG
         * INSERT INTO `sqlDesign`.`sys_user` (`address`, `effective`, `hiretime`, `name`, `password`, `role`, `salary`, `sex`, `telephone`, `username`) VALUES ('a', false, '2018-07-21 03:30:34', 'a', '$2a$10$kke9EHzAFTKWJTQcTzFi0.IFlJmJLd6BhOtPKlAoq3iH9G.s3KAtG', 'admin', 0, '0', 0, 'root')
         *
         */
        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if (nowUser.getRole().equals("admin")) {
            SysUser x = new SysUser();
            //用户名
            x.setUsername(request.getParameter("username"));
            //姓名
            x.setName(request.getParameter("name"));
            //性别
            x.setSex(request.getParameter("sex"));
            BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
            //设置密码
            x.setPassword(encoder.encode(request.getParameter("password").trim()));
            //设置地址
            x.setAddress(request.getParameter("address"));

            //设置入职时间
            DateFormat fmt =new SimpleDateFormat("yyyy/MM/dd");
            Date date = fmt.parse(request.getParameter("date"));
            x.setHiretime(date);

            //默认有效
            x.setEffective(true);
            x.setSalary(Integer.parseInt(request.getParameter("salary")));
            x.setTelephone(Integer.parseInt(request.getParameter("telephone")));
            x.setRole(request.getParameter("bumen"));
            userRepository.save(x);
            return "redirect:/admin";
        }
        else {
            return "redirect:/login";
        }

    }

}

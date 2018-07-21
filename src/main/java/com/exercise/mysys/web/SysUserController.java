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
        return "userList";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String add(HttpServletRequest request) {
        /**
         * root
         * $2a$10$kke9EHzAFTKWJTQcTzFi0.IFlJmJLd6BhOtPKlAoq3iH9G.s3KAtG
         * INSERT INTO `sqlDesign`.`sys_user` (`id`, `address`, `effective`, `hiretime`, `password`, `role`, `salary`, `telephone`, `username`) VALUES (0, 'a', true, '2018-07-21 00:50:40', '$2a$10$kke9EHzAFTKWJTQcTzFi0.IFlJmJLd6BhOtPKlAoq3iH9G.s3KAtG', 'admin', 0, 0, 'root')
         *
         *
         */
        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if (nowUser.getRole().equals("admin")) {
            SysUser x = new SysUser();
            x.setUsername(request.getParameter("username"));
            BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
            x.setPassword(encoder.encode(request.getParameter("password").trim()));
//            x.setAddress(request.getParameter("address"));
//            x.setEffective(true);
//            x.setHiretime(new Date());
//            x.setSalary(Integer.parseInt(request.getParameter("salary")));
//            x.setTelephone(Integer.parseInt(request.getParameter("telephone")));
            x.setAddress("address");
            x.setEffective(true);
            x.setHiretime(new Date());
            x.setSalary(10);
            x.setTelephone(123);
            x.setRole("user");
            userRepository.save(x);
            return "redirect:/";
        }
        else {
            return "redirect:/login";
        }

    }

}

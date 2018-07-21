package com.exercise.mysys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.GenericArrayType;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
public class anycontroller {
    @RequestMapping(value="p",method = RequestMethod.GET)
    public String update() {
        System.out.println("yes");
        return "p";
    }
//    @RequestMapping(value="c",method = RequestMethod.POST)
//    @ResponseBody//此注解不能省略 否则ajax无法接受返回值
//    public String up() {
//        System.out.println("get");
//        return "n";
//    }

    @RequestMapping(value = "/c", method = RequestMethod.POST)
    @ResponseBody
    public String submit(HttpServletRequest re)
            throws Exception {

        System.out.println("get");
        //这里就可以获取里面的上传过来的数据了

        //做一些存库操作，以及返回的数据
        return re.getParameter("url");
    }

//    @RequestMapping(value = "/c", method = RequestMethod.POST)
//    public BaseBody submit(HttpServletRequest request)
//            throws Exception {
//        System.out.println("get");
//        BaseBody body = new BaseBody();
//        body.id = request.getParameter("url");
//        return body;
//    }
}
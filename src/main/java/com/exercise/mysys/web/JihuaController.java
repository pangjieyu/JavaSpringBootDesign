package com.exercise.mysys.web;

import com.exercise.mysys.dao.GoodRepository;
import com.exercise.mysys.dao.ManufacturePlanRepository;
import com.exercise.mysys.domain.Good;
import com.exercise.mysys.domain.ManufacturePlan;
import com.exercise.mysys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/23 17:09
 * @Description: TODO
 */
@Controller
@RequestMapping(value = "/jihua")
public class JihuaController {
    @Autowired
    private ManufacturePlanRepository manufacturePlanRepository;
    @Autowired
    private GoodRepository goodRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String jihua() {
        return "index/index_jihua";
    }

    @GetMapping("/tianjiashengchanjihua")
    public String addShengchanjihua(){
        return "shengchan/shengchan_order";
    }

    @PostMapping("/tianjiashengchanjihua")
    @ResponseBody
    public String tianjiashengchanjihua(HttpServletRequest request){
        try {
            //获取当前用户
            SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();

            //新建一个生产计划
            ManufacturePlan manufacturePlan = new ManufacturePlan();
            //设置生产计划有效
            manufacturePlan.setEffective(true);
            //设置员工编号
            manufacturePlan.setEmployee_id(nowUser.getId());
            List<Good> list = goodRepository.myFindJingque(request.getParameter("name").trim());
            if (list.size() == 0){
                return "不存在该商品";
            }
            Good good = list.get(0);
            manufacturePlan.setGood_id(good.getId());
            manufacturePlan.setNumber(Integer.parseInt(request.getParameter("number").trim()));
            manufacturePlan.setMoney(Integer.parseInt(request.getParameter("money").trim()));
            //设置生产时间
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(request.getParameter("date"));
            manufacturePlan.setManufacture_date(date);
            manufacturePlanRepository.save(manufacturePlan);
            return "true";
        }
        catch (Exception e){
            System.out.println(e.toString());
            return "操作失败";
        }

    }
}

package com.exercise.mysys.web;

import com.exercise.mysys.dao.*;
import com.exercise.mysys.domain.*;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.GenericArrayType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 张江瑜
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
@RequestMapping(value = "/cangku")
public class CangkuController {

    @Autowired
    private InKuRepository inKuRepository;
    @Autowired
    private OutKuRepository outKuRepository;
    @Autowired
    private DestroyRepository destroyRepository;
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    private PickRepository pickRepository;

    @GetMapping("/ruku")
    public String ruku() {
        return "cangku/cangku_ruku";
    }

    @PostMapping("/ruku")
    @ResponseBody
    public String tianjiaruku(HttpServletRequest request) {
        //初始化一个入库单
        InKu inKu = new InKu();
        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
            try {
                System.out.println("0");
                inKu.setEmployee_id(nowUser.getId());
                //按商品名称查询
                List<Good> list = goodRepository.myFind(request.getParameter("goodname").trim());
                System.out.println(list.size());
                if(list.size() == 0){
                    return "没有该商品";
                }
                //取出第一个商品
                Good good = list.get(0);
                //设置商品编号
                inKu.setGood_id(good.getId());
                //设置商品数量
                inKu.setNumber(Integer.parseInt(request.getParameter("number").trim()));
                //设置产生时间
                DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse(request.getParameter("date"));
                inKu.setIn_date(date);
                inKuRepository.save(inKu);
                return "true";
            }
            catch (Exception ex) {
                return "操作失败";
            }
    }

    @RequestMapping(value = "/chuku", method = RequestMethod.GET)
    public String chuku() {
        return "cangku/cangku_chuku";
    }

    @PostMapping("/chuku")
    @ResponseBody
    public String tianjiachuku(HttpServletRequest request) {
        //初始化一个出库单
        OutKu outku = new OutKu();
        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
            try {
                //System.out.println("0");
                //设置员工编号
                outku.setEmployee_id(nowUser.getId());
                //按商品名称查询
                List<Good> list = goodRepository.myFind(request.getParameter("goodname").trim());
                //System.out.println(list.size());
                if (list.size() == 0) {
                    return "没有该商品";
                }
                //取出第一个商品
                Good good = list.get(0);
                //设置商品编号
                outku.setGood_id(good.getId());
                //设置商品数量
                //System.out.println("3");
                outku.setNumber(Integer.parseInt(request.getParameter("number").trim()));
                //设置产生时间
                //System.out.println("4");
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse(request.getParameter("date"));
                outku.setOut_date(date);
                //System.out.println("5");
                outKuRepository.save(outku);
                return "true";
            } catch (Exception ex) {
                return "操作失败";
            }
    }

    @PostMapping("/chuku/xiugai")
    @ResponseBody
    public String xiugaiyouxiao(HttpServletRequest request)
    {
        try {
            System.out.println(request.getParameter("tihuo"));
            //查找对应id的提货单
            Pick pick = pickRepository.findPickById(Long.parseLong(request.getParameter("tihuo").trim()));
            //将有效标记设为无效
            pick.setEffective(false);
            //保存
            pickRepository.save(pick);
            return "true";
        }
        catch (Exception ex){
            return "修改失败";
        }
    }

    @RequestMapping(value = "/xiaohui", method = RequestMethod.GET)
    public String xiaohui(){
        return "cangku/cangku_xiaohui";
    }

    @PostMapping("/xiaohui")
    @ResponseBody
    public String tianjiaxiaohui(HttpServletRequest request){
        //初始化一个销毁单
        Destroy destroy = new Destroy();
        SysUser nowUser = (SysUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
            try {
                //System.out.println("0");
                //设置员工编号
                destroy.setEmployee_id(nowUser.getId());
                //按商品名称查询
                List<Good> list = goodRepository.myFind(request.getParameter("goodname").trim());
                //System.out.println(list.size());
                if (list.size() == 0) {
                    return "没有该商品";
                }
                //取出第一个商品
                Good good = list.get(0);
                //设置商品编号
                destroy.setGood_id(good.getId());
                //设置商品数量
                //System.out.println("3");
                destroy.setNumber(Integer.parseInt(request.getParameter("number").trim()));
                //设置产生时间
                //System.out.println("4");
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse(request.getParameter("date"));
                destroy.setDestroy_date(date);
                //System.out.println("5");
                destroyRepository.save(destroy);
                return "true";
            } catch (Exception ex) {
                return "操作失败";
            }
        }
}

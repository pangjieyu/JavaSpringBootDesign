package com.exercise.mysys.web;

import com.exercise.mysys.dao.*;
import com.exercise.mysys.domain.*;
import com.exercise.mysys.service.findServices;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.GenericArrayType;
import java.text.DateFormat;
import java.text.ParseException;
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
    @Autowired
    private StoreRepository storeRepository;

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

    //查询提货
    @GetMapping("/tihuo")
    public String tihuo(Model model) {
        model.addAttribute("tihuoList", findServices.findPick("",""));
        return "cangku/tihuo";
    }
    @PostMapping("/tihuo")
    public String findTihuo(HttpServletRequest request, Model model) {
        model.addAttribute("tihuoList", findServices.findPick(request.getParameter("kehu").trim(),request.getParameter("yuangong").trim()));
        return "cangku/tihuo";
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

    @RequestMapping(value = "/tianjia", method = RequestMethod.GET)
    public String tianjia(){
        return "cangku/cangku_tianjia";
    }

    @PostMapping("/tianjia")
    @ResponseBody
    public String tianjiakucun(HttpServletRequest request){
        try{
            //新建一个库存
            Store store = new Store();
            //查找商品id
            List<Good> list = goodRepository.myFind(request.getParameter("name").trim());
            if(list.size() == 0){
                return "没有该商品";
            }
            Good good = list.get(0);
            store.setGood_id(good.getId());
            store.setNumber(Integer.parseInt(request.getParameter("number").trim()));
            InKu inKu = inKuRepository.findInKuById(Long.parseLong(request.getParameter("pihao").trim()));
            if(inKu == null){
                return "不存在批号入库单";
            }
            store.setIn_id(Long.parseLong(request.getParameter("pihao").trim()));
            store.setPosition(request.getParameter("position"));
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fmt.parse(request.getParameter("date"));
            store.setIn_time(date);
            storeRepository.save(store);
            return "true";
        }
        catch (Exception ex){
            return "操作失败";
        }
    }

    @GetMapping("/kucun")
    public String kucun1(Model model){
        model.addAttribute("kucunList",findServices.findGood("",""));
        return "cangku/cangku_chaxun";
    }

    @PostMapping("/kucun")
    public String kucun(HttpServletRequest request,Model model) {
        model.addAttribute("kucunList", findServices.findGood(request.getParameter("name").trim(), request.getParameter("id").trim()));
        return "cangku/cangku_chaxun";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable String id ,Model model) {
        Store store = storeRepository.findStoreById(Long.parseLong(id));
        model.addAttribute("store",store);
        return "cangku/cangku_xiugai";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable String id, HttpServletRequest request,Model model) throws ParseException {
        Store store = storeRepository.findStoreById(Long.parseLong(id));
        store.setGood_id(Long.parseLong(request.getParameter("id").trim()));
        store.setNumber(Integer.parseInt(request.getParameter("number").trim()));
        store.setPosition(request.getParameter("position"));
        store.setIn_id(Long.parseLong(request.getParameter("pihao").trim()));
        storeRepository.save(store);
        Good good = goodRepository.findGoodById(Long.parseLong(request.getParameter("id").trim()));
        model.addAttribute("kucunList", findServices.findGood(good.getName(), store.getIn_id().toString()));
        return "cangku/cangku_chaxun";
    }

}

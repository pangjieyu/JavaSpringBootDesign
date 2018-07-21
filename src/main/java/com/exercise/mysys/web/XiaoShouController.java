package com.exercise.mysys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 19:39
 * @Description: 销售控制器
 */
@Controller
@RequestMapping("/xiaoshou")
public class XiaoShouController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String shengchan() {
        return "/index/index_sale.html";
    }
    //添加客户
    @RequestMapping(value = "/添加客户", method = RequestMethod.GET)
    public String tianjiakehu(){ return "tianjiakehu"; }
    //修改客户
    @RequestMapping(value = "/修改客户", method = RequestMethod.GET)
    public String 修改客户(){ return "xiugaikehu"; }
    //查询客户
    @RequestMapping(value = "/查询客户", method = RequestMethod.GET)
    public String chaxunkehu(){ return "chaxunkehu"; }
    //折扣预付款
    @RequestMapping(value = "/折扣预付款", method = RequestMethod.GET)
    public String zhekouyufukuan(){ return "zhekouyufukuan"; }
    //修改订单
    @RequestMapping(value = "/修改订单", method = RequestMethod.GET)
    public String xiugaidingdan(){ return "xiugaidingdan"; }
    //退货单
    @RequestMapping(value = "/退货单", method = RequestMethod.GET)
    public String tuihuodan(){ return "tuihuodan"; }
    //订货单
    @RequestMapping(value = "/订货单", method = RequestMethod.GET)
    public String dinghuodan(){ return "dinghuodan"; }
    //提货单
    @RequestMapping(value = "/提货单", method = RequestMethod.GET)
    public String tihuodan(){ return "tihuodan"; }

}

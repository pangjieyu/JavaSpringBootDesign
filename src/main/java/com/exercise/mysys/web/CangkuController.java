package com.exercise.mysys.web;

import com.exercise.mysys.dao.InKuRepository;
import com.exercise.mysys.domain.InKu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.GenericArrayType;

/**
 * @author 庞界宇
 * @ProjectName 食品企业订货销售系统
 * @date 2018/7/20
 */
@Controller
@RequestMapping(value = "/cangku")
public class CangkuController {

    private InKuRepository inKuRepository;
    @GetMapping("/ruku")
    public String ruku() {
        return "cangku/cangku_ruku";
    }
    @PostMapping("/ruku")
    public String tianjiaruku(HttpServletRequest request) {
        InKu inKu = new InKu();
        inKu.setNumber(Integer.parseInt(request.getParameter("number").trim()));
        inKuRepository.save(inKu);
        return "/shouye";
    }

    @RequestMapping(value = "/chuku", method = RequestMethod.GET)
    public String chuku() {
        return "chuku";
    }

    @RequestMapping(value = "/xiaohui", method = RequestMethod.GET)
    public String xiaohui() {
        return "xiaohui";
    }
}
